package com.betalpha

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.util.CollectionUtils
import org.springframework.util.FileCopyUtils
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.context.WebApplicationContext
import spock.lang.Shared

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * base spec for controller
 * @author xiehai1
 * @date 2017/11/16 15:42
 * @Copyright ( c ) gome inc Gome Co.,LTD
 */
class BaseControllerSpec extends BaseSpec {
    @Shared
    MockMvc mockMvc
    @Autowired
    WebApplicationContext webApplicationContext

    def webApplicationContext() {
        expect:
        this.webApplicationContext != null
    }

    def setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build()
    }

    def doGet(String url, MultiValueMap<String, String> params) throws Exception {
        this.mockMvc.perform(get(url).params(params))
            .andDo(print())
            .andExpect(status().isOk())
    }

    def doGet(String url) {
        this.doGet(url, new LinkedMultiValueMap<>())
    }

    def doPostFile(String url, String fileName, String originalFilename, MultiValueMap<String, String> map) {
        def file = this.getFile(fileName, originalFilename)
        MockMultipartHttpServletRequestBuilder mockMultipartHttpServletRequestBuilder = fileUpload(url).file(file)
        if (!CollectionUtils.isEmpty(map)) {
            mockMultipartHttpServletRequestBuilder.params(map);
        }

        this.mockMvc.perform(mockMultipartHttpServletRequestBuilder)
            .andDo(print())
            .andExpect(status().isOk())
    }

    def doPostFile(String url, String fileName, String originalFilename) {
        this.doPostFile(url, fileName, originalFilename, new LinkedMultiValueMap<>())
    }

    def private MockMultipartFile getFile(String fileName, String originalFilename) throws IOException {
        new MockMultipartFile(
            fileName,
            originalFilename,
            null,
            FileCopyUtils.copyToByteArray(
                this.getClass()
                    .getClassLoader()
                    .getResourceAsStream(originalFilename)
            )
        )
    }
}
