package org.tit_admin_common.core.exception.validation;

/**
 * Framework level exception class to provide a general validation
 * exception class to be used by the various validation classes
 *
 * @author 刘晓勇
 */
public class ValidationException extends Exception {
    private static final long serialVersionUID = 1L;


    @Override
    public String getMessage() {
        return "[Validation Exception] The object under validation failed the check.\n" + super.getMessage();
    }
}
