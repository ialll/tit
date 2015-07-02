package org.tit_admin_service.core;


import javax.servlet.http.HttpServletRequest;

import org.tit_admin_common.core.Validity;
import org.tit_admin_common.core.exception.database.NotFoundException;
import org.tit_admin_model.core.entity.User;

/**
 * Service class to have business logic operation on User entity
 *
 * @author: 刘晓勇
 */
public interface UserService {

    /**
     * Register a new user into the system
     *
     * @param user
     * @param request
     *
     * @return
     */
    public User registerUser(User user, HttpServletRequest request);


    /**
     * Login a new user into the system
     *
     * @param user
     * @param request
     *
     * @return
     */
    public User loginUser(User user, HttpServletRequest request);

    /**
     * Method to validate whether the given password
     * is same as users password stored in the system
     *
     * @param user
     * @param pass
     *
     * @return
     */
    public boolean isValidPass(User user, String pass);


    /**
     * Validates whether the given username already
     * exists in the system.
     *
     * @param username
     *
     * @return
     */
    public boolean isUsernameExists(String username);


    /**
     * Validates whether the given email already
     * exists in the system.
     *
     * @param email
     *
     * @return
     */
    public boolean isEmailExists(String email);


    /**
     * Finds a user entity by the given username
     *
     * @param username
     * @return
     */
    public User findByUsername(String username) throws NotFoundException  ;
    /** 
     * 校验用户信息
     * @param user
     * @return
     */
    public Validity validate(User user);
}
