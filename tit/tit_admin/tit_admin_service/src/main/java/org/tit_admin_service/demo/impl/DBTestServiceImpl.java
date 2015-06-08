package org.tit_admin_service.demo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tit_admin_dao.demo.DBTestDao;
import org.tit_admin_dao.demo.impl.DBTestDaoImpl;
import org.tit_admin_service.demo.DBTestService;
@Service
@Transactional
public class DBTestServiceImpl implements DBTestService{
	private @Autowired DBTestDao dao; 
	@Override
	public String testDB() throws Exception {
		dao.testDB();
		return null;
	}

}
