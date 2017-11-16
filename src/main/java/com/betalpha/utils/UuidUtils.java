package com.betalpha.utils;

import java.util.UUID;

/**
 * @author xiehai1
 * @date 2017/11/16 14:45
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public final class UuidUtils {
    private UuidUtils(){

    }

    /**
     * generate uuid
     * @return uuid
     */
    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.replace("-", "");
    }
}
