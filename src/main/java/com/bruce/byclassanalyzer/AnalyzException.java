package com.bruce.byclassanalyzer;

/**
 * Created by bruceyuan on 17-9-16.
 */
public class AnalyzException extends RuntimeException {
    public AnalyzException(String message) {
        super(message);
    }

    public AnalyzException(Throwable cause) {
        super(cause);
    }

    public AnalyzException(String message, Throwable cause) {
        super(message, cause);
    }
}
