package org.tit_admin_service.core.impl;

import org.tit_admin_common.core.Message;
import org.tit_admin_common.core.Validity;
import org.tit_admin_common.core.exception.database.NotFoundException;
import org.tit_admin_dao.core.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tit_admin_model.core.entity.User;
import org.tit_admin_service.core.UserService;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Service impl class to implement services for accessing the User object entity.
 * This class acts as an interface between the outer world and the UserRepository
 *
 * @author: 刘晓勇
 */
@Service
@Transactional
public class UserServiceImpl  implements UserService {
	@Qualifier("userDaoImpl")
	private @Autowired UserDao userRepository;
    private @Autowired Message msg;

    @Override public boolean isValidPass(User user, String pass) {
        return user.getPassWord().equals(User.hashPassword(pass));
    }


    @Override
    public User registerUser(User user, HttpServletRequest request) {
        user.setPassWord(User.hashPassword(user.getPassWord()));
        user.setCurrentLoginAt(new Date());
        user.setCurrentLoginIp(request.getRemoteHost());
        user.setLoginCount(0);
        return userRepository.insert(user);
    }


    @Override public User loginUser(final User user, final HttpServletRequest request) {
        user.setLastLoginAt(user.getCurrentLoginAt());
        user.setLastLoginIp(user.getCurrentLoginIp());
        user.setCurrentLoginAt(new Date());
        user.setCurrentLoginIp(request.getRemoteHost());
        user.setLoginCount(user.getLoginCount() + 1);
        user.setUpdateDt(new Date());

        return userRepository.update(user);
    }


    @Override public boolean isUsernameExists(String username) {
        if (userRepository.findByUsername(username) != null) {
            return true;
        } else
            return false;
    }


    @Override public boolean isEmailExists(String email) {
        if (userRepository.findByEmail(email) != null) {
            return true;
        } else
            return false;
    }


    @Override 
    public Validity validate(User user) {
        Validity validity = new Validity(false);

        // Check for username and email uniqueness
        if (isUsernameExists(user.getUserName())) {
            validity.addError(msg.userExists);
        }

        if (isEmailExists(user.getEmail())) {
            validity.addError(msg.emailExists);
        }

        return validity;
    }


    @Override 
    public User findByUsername(String username) throws NotFoundException {
        User user = userRepository.findByUsername(username);

        if(user != null) {
            return user;
        } else {
            throw new NotFoundException("User not found","1001");
        }
    }



}
