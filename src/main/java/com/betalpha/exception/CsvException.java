package com.betalpha.exception;

/**
 * csv application exception
 * @author xiehai1
 * @date 2017/11/16 12:46
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class CsvException extends RuntimeException {
    public CsvException(String message){
        super(message);
    }

    public CsvException(Throwable throwable){
        super(throwable);
    }
}
