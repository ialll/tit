package org.tit_admin_service.demo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tit_admin_dao.demo.DBTestDao;
import org.tit_admin_dao.demo.MyBatisTestDao;
import org.tit_admin_model.demo.TestDomain;
import org.tit_admin_service.demo.DBTestService;
@Service
@Transactional
public class DBTestServiceImpl implements DBTestService{
	@Qualifier("dbTestDaoImpl") 
	private @Autowired DBTestDao dao; 
	private @Autowired MyBatisTestDao myBatisDao;
	@Override
	public String testDB() throws Exception {
		dao.testDB();
		return null;
	}
	@Override
	public String testDBByMyBatis(int id) {
		TestDomain test=myBatisDao.selectByPrimaryKey(1);
		return test.getName();
	}

}
