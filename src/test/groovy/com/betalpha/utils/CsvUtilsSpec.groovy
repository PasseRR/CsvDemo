package com.betalpha.utils

import com.betalpha.model.TimeSeriesData
import org.springframework.mock.web.MockMultipartFile
import spock.lang.Specification


/**
 * spec for {@link CsvUtils}
 * @author xiehai1
 * @date 2017/11/16 15:04
 * @Copyright ( c ) gome inc Gome Co.,LTD
 */
class CsvUtilsSpec extends Specification {
    def getFileNameWithoutSuffix() {
        expect:
        fileNameWithoutSuffix == CsvUtils.getFileNameWithoutSuffix(fileNameWithSuffix)

        where:
        fileNameWithSuffix || fileNameWithoutSuffix
        "a.txt"            || "a"
        "b.x.txt"          || "b.x"
        "c.1.3.4"          || "c.1.3"
        "a"                || "a"
        "abc"              || "abc"
    }

    def parseCvs(){
        given:
        def file = new File(this.getClass().getClassLoader().getResource("2017-11-16.csv").getFile())
        expect:
        file != null
        file.exists()

        when:
        def inputStream = new FileInputStream(file)
        def multipartFile = new MockMultipartFile(file.getName(), inputStream)
        then:
        multipartFile != null
        multipartFile.getSize() == file.length()

        when:
        def list = CsvUtils.parseCvs(multipartFile, '\t' as char, TimeSeriesData.class, "stockCode")
        then:
        list != null
        list.size() == 3
    }
}