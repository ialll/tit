package org.tit_admin_control.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tit_admin_service.demo.DBTestService;

@Controller
@RequestMapping("/DBtest")
public class DBTestController {
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
}
