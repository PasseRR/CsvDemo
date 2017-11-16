package com.betalpha

import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

/**
 * base spec
 * @author xiehai1
 * @date 2017/11/16 14:52
 * @Copyright ( c ) gome inc Gome Co.,LTD
 */
@WebAppConfiguration
@ContextConfiguration(classes = CsvApplication.class, initializers = ConfigFileApplicationContextInitializer.class)
class BaseSpec extends Specification {

}