package org.tit_admin_common.core.exception.auth;

import org.tit_admin_common.core.exception.BaseException;


/**
 * Exception indication Authentication failure
 *
 * @author: 刘晓勇
 */
public class AuthenticationFailedException extends BaseException {
    private static final long serialVersionUID = -8799659324455306881L;


    public AuthenticationFailedException(String message) {
        super(message);
    }


    public AuthenticationFailedException(String message, Object errorCode) {
        super(message, errorCode);
    }
}
