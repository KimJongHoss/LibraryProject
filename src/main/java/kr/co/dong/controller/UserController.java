package kr.co.dong.controller;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.dong.domain.LibrarianBean;
import kr.co.dong.domain.UserDTO;
import kr.co.dong.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService userService;
	
	@GetMapping("user/usermain")
	public void test() {
		
	}
	
	@GetMapping("road")
	public String road() {
		
		return "road/Sample";
	}
	
	@RequestMapping("popup/jusoPopup")
	public String popup() {
		
		return "user/jusoPopup";
	}
	
	@GetMapping("user/login")
	public String login() {
		
		return "user/login";
	}
	
	@RequestMapping("user/login")
	public String login(UserDTO userDTO
			, HttpServletResponse response
			, HttpSession session) throws IOException {
		String recrypt = userService.crypt(userDTO.getUserid());
		if(recrypt == null) {
			return "redirect:/user/login";
		}
		if(BCrypt.checkpw(userDTO.getUserpassword(), recrypt) != true) {
			return "redirect:/user/login";
		}
		userDTO.setUserpassword(recrypt);
		UserDTO result = userService.login(userDTO);
		
		// aop이용해서 처리
//		int rank = userService.rankCheck(result.getUserid());
//		if(rank == 1) { // 관리자
//			session.setAttribute("admin", result.getUserid());
//			return ""; // 관리자 페이지
//		} else if(rank == 10) { // 사서
//			session.setAttribute("librarain", result.getUserid());
//			return ""; // 사서 페이지
//		} else if(rank == 20) { // 준회원
//			session.setAttribute("junuser", result.getUserid());
//		} else if (rank == 50) { // 블랙리스트
//			session.setAttribute("", result)
//		}
		session.setAttribute("username", result.getUsername());
		session.setAttribute("userid", result.getUserid());
		session.setAttribute("rankid", result.getRankid());
		return "redirect:/";
	}
	
	@RequestMapping("user/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
	
	@GetMapping("user/member")
	public String member() {
		
		return "user/member";
	}
	
	@RequestMapping("user/member")
	public String member(UserDTO userDTO
			, @RequestParam("juso") String juso) {
		userDTO.setUseremail(userDTO.getUseremail() + juso);
		userDTO.setUserpassword(BCrypt.hashpw(userDTO.getUserpassword(), BCrypt.gensalt()));
		userService.member(userDTO);
		
		return "redirect:/user/login";
	}
	
	@GetMapping("user/findid")
	public String findId() {
		
		return "user/findid";
	}
	
	@RequestMapping("user/findid")
	public String findId(UserDTO userDTO
			, Model model) {
		String userid = userService.findId(userDTO);
		System.out.println(userid);
		if(userid == null) {
			return "redirect:/user/login";
		}
			
		
		logger.info(userid);
		model.addAttribute("userid", userid); // 모달창으로 던져주기 하려 했으나 다음 기회에
		return "user/idcheck";
	}
	
	@GetMapping("user/forgotpassword")
	public String findPassword() {
		return "user/forgotpassword";
	}
	
	@RequestMapping("user/forgotpassword")
	public String findPassword(UserDTO userDTO
			, Model model) {
		String userPassword = userService.findPassword(userDTO);
		if(userPassword == null) {
			return "user/login";
		}
		model.addAttribute("userid", userDTO.getUserid());
		return "user/updatepassword";
	}
	
	@RequestMapping("user/updatepassword")
	public String updatePassword(UserDTO userDTO) {
		userDTO.setUserpassword(BCrypt.hashpw(userDTO.getUserpassword(), BCrypt.gensalt()));
		userService.updatePassword(userDTO);
		
		return "redirect:/user/login";
	}
	
	@RequestMapping("user/idcheck")
	@ResponseBody
	public Integer idCheck(@RequestParam("id") String userid) {
		if(userid == "") {
			return -1;
		}
		int result = userService.idCheck(userid);
		System.out.println(result);
		
		return result;
	}
	
	@GetMapping("info/auth")
	public void auth() {
		
	}
	
	@RequestMapping("info/auth")
	public String auth(@RequestParam("userpassword") String userpassword
			, HttpSession session) {
		if(BCrypt.checkpw(userpassword, userService.crypt((String)session.getAttribute("userid"))) != true) {
			return "redirect:/";
		}
		userService.auth((String)session.getAttribute("userid"));
		return "redirect:/info/list";
	}
	
	@GetMapping("info/list")
	public void list(HttpSession session
			, Model model) {
		model.addAttribute("info", userService.infolist((String) session.getAttribute("userid")));
	}
	
	@RequestMapping("info/update")
	public String update(UserDTO userDTO) {
		userService.update(userDTO);
		return "redirect:/info/list";
	}
	
	@GetMapping("info/infoupdatepassword")
	public void updatePassword() {
		
	}
	
	@RequestMapping("info/infoupdatepassword")
	public String updatePassword(HttpSession session
			, UserDTO userDTO) {
		userDTO.setUserpassword(BCrypt.hashpw(userDTO.getUserpassword(), BCrypt.gensalt()));
		userDTO.setUserid((String) session.getAttribute("userid"));
		userService.updatePassword(userDTO);
		return "redirect:/";
	}
	
	@RequestMapping("info/remove")
	public String delete(HttpSession session) {
		userService.delete((String) session.getAttribute("userid"));
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("info/interlib")
	public String interlib() {
		
		return "";
	}
	
	@GetMapping("info/loan")
	public String loan() {
		
		return "";
	}
	@GetMapping("info/delivery")
	public String delivery() {
		
		return "";
	}
	@GetMapping("info/readingroom")
	public String readingroom() {
		
		return "";
	}
	
	//	사서 로그인
	@GetMapping("loginmanager")
	public String loginmanager() {
		
		return "user/loginmanager";
	}
	
	@PostMapping("loginmanager")
	public String loginmanager(LibrarianBean LB, 
			HttpSession session) throws IOException {
	    LibrarianBean result = userService.loginmanager(LB);
	    
	    if(result == null) {
	    	return "redirect:/user/login";
	    }
	    session.setAttribute("name", result.getName());
	    session.setAttribute("id", result.getId());
	    session.setAttribute("etc", result.getEtc());
	    
	    return "redirect:/";
	}
	
	@GetMapping(value = "underConstruction_user")
	public String underConstruction_user() {
		logger.info("이 페이지는 공사중입니다!(유저 페이지)");
		
		return "user/underConstruction_user";
	}
	
}
