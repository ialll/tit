package org.tit_admin_common.core.exception.auth;

import org.tit_admin_common.core.exception.BaseException;


/**
 * Exception indicating Auth credentials missing.
 *
 * @author: 刘晓勇
 */
public class AuthCredentialsMissingException extends BaseException {
    private static final long serialVersionUID = 672693922566865605L;


    public AuthCredentialsMissingException(String message) {
        super(message);
    }


    public AuthCredentialsMissingException(String message, Object errorCode) {
        super(message, errorCode);
    }
}
