package org.tit_admin_control.core.actor.impl;

import akka.actor.TypedActor;
import akka.actor.TypedActorExtension;
import akka.actor.TypedActorFactory;
import akka.actor.UntypedActor;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.tit_admin_control.core.actor.MailSenderActor;
import org.tit_admin_common.core.Props;
import org.tit_admin_common.core.exception.service.NotYetImplementedException;
import org.tit_admin_model.core.entity.User;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * Mail sender actor impl
 *
 * @author: 刘晓勇
 */
public class MailSenderActorImpl extends UntypedActor implements MailSenderActor {
    private VelocityEngine velocityEngine;
    private JavaMailSender javaMailSender;
    private Props props;


    @Override 
    public void sendUserEmailIdVerificationMail(User user) throws NotYetImplementedException {
        throw new NotYetImplementedException("email verification");
    }


    @Override 
    public void sendUserEmailIdConfirmationMail(final User user) {
        Map model = new HashMap();
        model.put("user", user);

        MimeMessagePreparator preparator = prepareMail(user.getEmail(), props.fromAddress,
                props.subConfirmationEmail, "velocity/confirmation.vm", model);
        this.javaMailSender.send(preparator);
    }


    public MimeMessagePreparator prepareMail(final String to, final String from, final String subject,
                                             final String template, final Map model) {
        return new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(to);
                message.setFrom(from);
                message.setSubject(subject);
                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, template, model);
                message.setText(text, true);
            }
        };
    }


    public VelocityEngine getVelocityEngine() {
        return velocityEngine;
    }


    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }


    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }


    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public Props getProps() {
        return props;
    }


    public void setProps(Props props) {
        this.props = props;
    }
}
