package com.vivek.exception

/**
 * Created by vivek on 22/8/17.
 */
class CodingException extends Exception {

    CodingException(String message) {
        super(message);
    }

    CodingException(String message, Throwable cause) {
        super(message, cause);
    }
}
