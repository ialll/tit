package org.tit_admin_common.core.exception;

/**
 * The exception class to be extended by all
 * custom Exception classes
 *
 * @author 刘晓勇
 */
public class BaseException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // To be set by exception throwing class
    protected Object errorCode;


    public BaseException(String message) {
        super(message);
    }


    public BaseException(String message, Object errorCode) {
        super(message);
        this.errorCode = errorCode;
    }


    public Object getErrorCode() {
        return errorCode;
    }
}
