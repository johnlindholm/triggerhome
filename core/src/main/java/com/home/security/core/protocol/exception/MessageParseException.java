package com.home.security.core.protocol.exception;

/**
 * Created by john on 2014-11-26.
 */
public class MessageParseException extends Throwable {

    public MessageParseException() {
        super();
    }

    public MessageParseException(String message) {
        super(message);
    }

    public MessageParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
