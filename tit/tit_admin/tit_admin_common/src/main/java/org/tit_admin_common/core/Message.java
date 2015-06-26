package org.tit_admin_common.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

/**
 * @author: 刘晓勇
 */
@Component
@ImportResource("classpath:../spring/appServlet/applicationContext-properties.xml")
public class Message {
    public @Value("#{msgProps['regSuccess']}") String registerSuccess;
    public @Value("#{msgProps['regError']}") String registerError;
    public @Value("#{msgProps['loginSuccess']}") String loginSuccess;
    public @Value("#{msgProps['loginError']}") String loginError;
    public @Value("#{msgProps['resendEmail']}") String resendEmail;
    public @Value("#{msgProps['emailCnfSuccess']}") String emailCnfSuccess;
    public @Value("#{msgProps['userExists']}") String userExists;
    public @Value("#{msgProps['emailExists']}") String emailExists;

    public @Value("#{msgProps['auth.userNotFound']}") String aUserNotFound;
    public @Value("#{msgProps['auth.userNotFound.code']}") int aUserNotFoundCode;
    public @Value("#{msgProps['auth.failed']}") String aFailed;
    public @Value("#{msgProps['auth.failed.code']}") int aFailedCode;
    public @Value("#{msgProps['auth.parametersMissing']}") String aParamMissing;
    public @Value("#{msgProps['auth.parametersMissing.code']}") int aParamMissingCode;

    public static final String invLatitude = "Invalid latitude";
    public static final String invLongitude = "Invalid longitude";
}
