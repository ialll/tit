package org.tit_admin_dao.core;

import org.tit_admin_model.core.entity.User;

/**
 * @author 刘晓勇
 *
 */
public interface UserDao {
	/**
	 * @return
	 * @throws Exception
	 */
	public User insert(User u);

	public User findByUsername(String username);

	public Object findByEmail(String email);

	public User update(User user);
}
