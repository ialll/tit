package org.tit_admin_service.demo;

public interface DBTestService {
	/**
	 * 数据库测试Service
	 * @return
	 * @throws Exception
	 */
	public String testDB() throws Exception;

	public String testDBByMyBatis(int id);
}
