//	관리자 page Controller
package kr.co.dong.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ManagerController {
	
	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	@GetMapping(value = "managerMain")
	public String managerMain() {
		logger.info("Welcome 관리자 메인 페이지! ");
		
		return "manager/managerMain";
	}
	
	@GetMapping(value = "underConstruction")
	public String underConstruction() {
		logger.info("이 페이지는 공사중입니다! ");
		
		return "manager/underConstruction";
	}
	
}
