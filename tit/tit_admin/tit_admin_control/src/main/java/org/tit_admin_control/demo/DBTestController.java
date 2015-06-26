package org.tit_admin_control.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tit_admin_control.core.BaseApiController;
import org.tit_admin_service.demo.DBTestService;

@Controller
@RequestMapping("/DBtest")
public class DBTestController extends BaseApiController{
	private @Autowired DBTestService dbTestService;
	@RequestMapping("/direct")
	public @ResponseBody String simple() {
		try {
			dbTestService.testDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hello world!";
	}
	@RequestMapping("/MyBatisTest")
	public @ResponseBody String myBatisTest() {
		String result="";
		try {
			result=dbTestService.testDBByMyBatis(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
