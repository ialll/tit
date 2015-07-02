package org.tit_admin_dao.core.impl;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.tit_admin_dao.core.UserDao;
import org.tit_admin_model.core.entity.User;
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao{
	private @Autowired JdbcTemplate springJDBCTemplate;
	
	@Override
	@Transactional
	public User insert(User u) {
			String sql="insert into tit_user t(userName,email,mobile,role,address,passWord,loginCount,currentLoginAt,lastLoginAt,currentLoginIp,lastLoginIp,createDt,updateDt) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			Object [] para ={u.getUserName(),u.getEmail(),u.getMobile(),u.getRole(),u.getAddress(),u.getPassWord(),u.getLoginCount(),u.getCurrentLoginAt(),u.getLastLoginAt(),u.getCurrentLoginIp(),u.getLastLoginIp(),new Date(),new Date()};
			this.springJDBCTemplate.update(sql, para);
			return u;
		
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
