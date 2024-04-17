//	관리자 권한 기능 Controller
package kr.co.dong.controller;



import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.dong.domain.BookBean;
import kr.co.dong.domain.BookJoinDTO;
import kr.co.dong.domain.LibrarianBean;
import kr.co.dong.domain.LibraryBean;
import kr.co.dong.domain.LoanDTO;
import kr.co.dong.domain.LoanJoinDTO;
import kr.co.dong.domain.UserDTO;
import kr.co.dong.domain.pageDTO;
import kr.co.dong.domain.saveBlacklistBean;
import kr.co.dong.domain.saveOverdueBean;
import kr.co.dong.domain.toRegularBean;
import kr.co.dong.service.AdminService;
import kr.co.dong.service.ApplicationService;
import kr.co.dong.service.BookService;
import kr.co.dong.service.LibrarianService;
import kr.co.dong.service.UserService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class ApplicationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	
	@Autowired
	UserService userservice;
	
	@Autowired
	ApplicationService applicationservice;
	
	
//	정회원 전환 신청 Mapping

	@GetMapping(value = "toRegular")
	public String toRegularForm() {
		logger.info("이곳은 정회원 전환 신청 폼 페이지입니다. ");
		
		return "application/toRegular";
	}
	
	@PostMapping(value = "toRegular")
	public String toRegular(@RequestParam("userid")String userid
			,@RequestParam("content")String content
			,toRegularBean bean
			,UserDTO userbean
			,Model model) {
		logger.info("이곳은 정회원 전환 신청 기능입니다. ");
		
		userbean = userservice.infolist(userid);
		
		bean.setUserid(userid);
		bean.setApply_reason(content);
		bean.setUseremail(userbean.getUseraddress());
		bean.setRankid(userbean.getRankid());
		
		int r = applicationservice.toRegularInsert(bean);
		System.out.println("정회원 전환 신청 성공 여부(성공:1, 실패:0) -> "+r);
		
		return "redirect:/";
	}
//	연체 구제 신청 Mapping
	
	@GetMapping(value = "overdueHelp")
	public String overdueHelpForm() {
		logger.info("이곳은 연체 구제 신청 폼 페이지입니다. ");
		
		return "application/overdueHelp";
	}
	
	@PostMapping(value = "overdueHelp")
	public String overdueHelp(@RequestParam("userid")String userid
			,@RequestParam("title")String title
			,@RequestParam("content")String content
			,saveOverdueBean bean
			,UserDTO userbean
			,Model model) {
		logger.info("이곳은 연체 구제 신청 기능입니다. ");
		
		userbean = userservice.infolist(userid);
		
		bean.setUserid(userid);
		bean.setReason(content);
		bean.setRankid(userbean.getRankid());
		
		
		
		return "redirect:/";
	}
//	블랙리스트 구제 신청 Mapping
	
	@GetMapping(value = "blacklistHelp")
	public String blacklistHelpForm() {
		logger.info("이곳은 블랙리스트 구제 신청 폼 페이지입니다. ");
		
		return "application/blacklistHelp";
	}
	
	@PostMapping(value = "blacklistHelp")
	public String blacklistHelp(@RequestParam("userid")String userid
			,@RequestParam("content")String content
			,saveBlacklistBean bean
			,UserDTO userbean
			,Model model) {
		logger.info("이곳은 블랙리스트 구제 신청 기능입니다. ");
		
		userbean = userservice.infolist(userid);
		
		bean.setUserid(userid);
		bean.setReason(content);
		bean.setUseremail(userbean.getUseraddress());
		bean.setRankid(userbean.getRankid());
		
		System.out.println(bean);
		
		int r = applicationservice.blacklistHelpInsert(bean);
		System.out.println("블랙리스트 구제 신청 성공 여부(성공:1, 실패:0) -> "+r);
		
		return "redirect:/";
	}
	
	
	
}
