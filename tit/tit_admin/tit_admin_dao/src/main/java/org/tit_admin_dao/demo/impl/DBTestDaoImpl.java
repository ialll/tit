package org.tit_admin_dao.demo.impl;

import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tit_admin_dao.demo.DBTestDao;
@Repository
public class DBTestDaoImpl implements DBTestDao{
	private @Autowired JdbcTemplate springJDBCTemplate;
	@Override
	public String testDB() throws Exception {
		List list=this.springJDBCTemplate.queryForList("select t.name from test_o2o t ");
		return null;
	}

}
