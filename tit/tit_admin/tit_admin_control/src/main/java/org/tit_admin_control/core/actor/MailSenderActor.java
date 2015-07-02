package org.tit_admin_control.core.actor;

import org.tit_admin_common.core.exception.service.NotYetImplementedException;
import org.tit_admin_model.core.entity.User;


/**
 * Typed Actor to offload the mail sending activity
 * of the current thread
 *
 * @author: 刘晓勇
 */
public interface MailSenderActor {
    /**
     * Sends a mail to the user asking him/her to
     * verify his email id.
     *
     * @param user
     */
    public void sendUserEmailIdVerificationMail(final User user) throws NotYetImplementedException;


    /**
     * Sends a mail to the user informing him/her of successful
     * confirmation of their email address.
     *
     * @param user
     */
    public void sendUserEmailIdConfirmationMail(final User user);
}
