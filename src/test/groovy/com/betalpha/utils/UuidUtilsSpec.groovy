package com.betalpha.utils

import spock.lang.Specification


/**
 * spec for {@link UuidUtils}
 * @author xiehai1
 * @date 2017/11/16 14:52
 * @Copyright ( c ) gome inc Gome Co.,LTD
 */
class UuidUtilsSpec extends Specification {
    def getUuid(){
        given:
        def uuid = UuidUtils.getUuid()

        expect:
        uuid != null
        uuid.length() == 32
    }
}