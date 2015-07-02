package org.tit_admin_common.core;

import org.apache.commons.lang.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * Method to commonly validate the Spring 
 * entity constraints on an object passed
 *
 * @author: 刘晓勇
 */
public class EntityValidator<T> {
    
    private Logger log = LoggerFactory.getLogger(EntityValidator.class);

    /**
     * Validate the T object
     *
     * @param bean
     * @return
     */
    public Validity validate(T bean, Class<T> beanClass) {
        HashSet<String> err = new HashSet<String>();
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<T>> violations = validator.validate(bean);
        for (ConstraintViolation<T> violation : violations) {
            String propertyPath = violation.getPropertyPath().toString().toLowerCase();
            String message = violation.getMessage();
            String errMsg = WordUtils.capitalize(propertyPath) + " " + message;

            log.error("Invalid Value: '" + errMsg);
            err.add(errMsg);
        }


        List result = new ArrayList(err);
        return new Validity(result.isEmpty(), result);
    }

}
