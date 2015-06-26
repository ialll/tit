package org.tit_admin_common.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Loaded from the property files
 *
 * @author 刘晓勇
 *
 */
@Component
@ImportResource("classpath:../spring/appServlet/applicationContext-properties.xml")
public class Props {
    public @Value("#{fProps['yourwebproject.host']}") String fHost;
    public @Value("#{fProps['yourwebproject.api.path']}") String fApiPath;
    public @Value("#{fProps['yourwebproject.web.path']}") String fWebPath;
    public @Value("#{fProps['yourwebproject.user.country']}") String fUserCountry;

    public @Value("#{mailProps['mail.fromAddress']}") String fromAddress;
    public @Value("#{mailProps['mail.sub.verificationEmail']}") String subVerificationEmail;
    public @Value("#{mailProps['mail.sub.confirmationEmail']}") String subConfirmationEmail;
    public @Value("#{mailProps['mail.verifyUrl']}") String verifyUrl;

    public List<String> webAuthRoutes;
    public List<String> apiAuthRoutes;


    @PostConstruct
    public void init() {
        webAuthRoutes = Arrays.asList(
                fWebPath + "/dashboard"
        );

        apiAuthRoutes = Arrays.asList(
                fApiPath + "/user" + "/register",
                fApiPath + "/user" + "/login"
        );
    }
}
