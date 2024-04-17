package kr.co.dong.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.dong.controller.ServiceController;
import kr.co.dong.domain.BookBean;
import kr.co.dong.domain.BookJoinDTO;
import kr.co.dong.domain.DeliveryBean;
import kr.co.dong.domain.InterBean;
import kr.co.dong.domain.LibraryBean;
import kr.co.dong.domain.UserDTO;
import kr.co.dong.service.AdminService;
import kr.co.dong.service.DeliveryService;
import kr.co.dong.service.InterService;
import kr.co.dong.service.UserService;

@Controller
public class ServiceController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
	// System.out.println(출력을 원하는 데이터);을 써도 상관없음

    @Autowired
    AdminService adminService;
    @Autowired
    InterService interService;
    @Autowired
    DeliveryService deliveryService;
    @Autowired
    UserService userService;
    
    // URL 경로 '/user/inter'로 GET 요청이 왔을 때 처리하는 메서드
	@GetMapping("user/inter")
	public String interlist(@RequestParam("isbncode") String isbncode
            ,@RequestParam("library_code") int library_code   // param(부르는 값) 받은 값 jsp에서 던져줘야지만 사용 가능하다
            ,Model model) {
		
		 // 로그에 ISBN 코드와 도서관 코드 출력
		System.out.println(isbncode);
		System.out.println(library_code);
		
		 // 관리자 서비스를 사용하여 도서관 목록 조회
		List<LibraryBean> library = adminService.librarylist(); 
		// adminService.librarylist()를 library에 담음
		
		//담은 데이터 출력
		System.out.println(library);
		
		// 모델에 도서관 목록 추가
		model.addAttribute("isbncode", isbncode); 
		model.addAttribute("library", library);
		model.addAttribute("library_code", library_code);
		// 해당 데이터를 모델에 담고 "데이터"로 명칭하여 보낸다
		
		return "user/inter"; // user/inter.jsp로 이동
	}
	
	  // URL 경로 '/user/inter'로 POST 요청이 왔을 때 처리하는 메서드
	@PostMapping("user/inter")
	public String inter(Model model,
	                    @RequestParam("isbncode") String isbncode,
	                    @RequestParam("library_code") int library_code,
	                    HttpSession session,   // 던져진 세션 받아오기 (로그인파트 쪽에서 세션을 뿌렸을경우)
	                    InterBean interBean) { // 세션값을 interBean에 저장하기위해 호출
		
		// 도서관 코드를 사용하여 도서관 정보 조회
	    LibraryBean librarybean = adminService.librarySelectOne(library_code);  
	    // library_code를 selectOne 시킨걸 libraryBean에 담았다
	    
	    // 세션에서 사용자 아이디와 이름 가져오기
	    interBean.setUserid((String)session.getAttribute("userid"));
	    interBean.setUsername((String)session.getAttribute("username"));
        // getter, setter할때 쓰던거        ((초기 값이 object이기에 String으로 변환) session.getAttribute("가져올 세션"))
	    
	    // ISBN 코드 설정
	    System.out.println(isbncode);
	    interBean.setIsbncode(isbncode);
	    // param으로 가져온 isbncode를 interBean에 set한다
	    
	    // 도서관 이름 설정
	    interBean.setLibraryname(librarybean.getName());
	    System.out.println(interBean);
	    // interbean의 libraryname에 담는다 (librarybean에서 libraryname을 가져온다)
	    
	    // 해당 interbean을 테이블에 저장시킨다
	    interService.interinsert(interBean);
	    
	    return "redirect:../book/list?isbncode=" + isbncode + "&library_code="+library_code+"&page=1";
	}

	 // URL 경로 '/user/deliveryform'로 GET 요청이 왔을 때 처리하는 메서드
		@GetMapping("user/deliveryform")
		public String deliveryform(Model model,
	                           @RequestParam("isbncode") String isbncode,
	                           @RequestParam("library_code") int library_code,
	                           HttpSession session) {
		 // 세션에서 사용자 아이디 가져오기
	    String userid = (String) session.getAttribute("userid");
	    //던진 세션을 userid에 담아낸다 
	    
	    // 사용자 정보 조회
	    UserDTO user = userService.infolist(userid);
	    //담아낸 userid를 사용하여 userserivce에 있는 사용자 정보 조회 메소드를 가져온다
	    // 또한 해당 값을 user에 담아낸다
	    
	    // 배송 정보 설정
	    DeliveryBean bb = new DeliveryBean(); 
	    // deliverybean을 bb로 사용하고 호출한다(현재 해당 값은 비어있다)
	    
	    if (user != null) { // 유저가 null이 아닐경우
	    	bb.setEtc(userid);
	    	bb.setUsername(user.getUsername());
	        bb.setUseraddress(user.getUseraddress()); //bb에 (user정보를 가져와서) bb안에 있는 데이터에  set시킨다  
	        bb.setUsernumber(user.getUserphonenum());
	    }

	    // ("해당 데이터를 부를때", 담아내는 데이터)
	    model.addAttribute("isbncode", isbncode);
	    model.addAttribute("library_code", library_code); //model에 데이터를 담아낸다
	    model.addAttribute("bb", bb);  

	    return "user/deliveryform"; // user/deliveryform.jsp로 이동
	}

	  // URL 경로 '/user/deliveryform'로 POST 요청이 왔을 때 처리하는 메서드
	@PostMapping("user/deliveryform")
	public String delivery(DeliveryBean bb, HttpSession session, UserDTO ud) {
		// 세션에서 사용자 아이디 가져오기
	    String userid = (String) session.getAttribute("userid");
	    String username = (String) session.getAttribute("username");
	    
	    // 사용자 정보 조회
	    userService.infolist(userid);
	    ud = userService.infolist(userid);
	    
	    // 주소, 번호, 이름 설정
	    bb.setUseraddress(bb.getUseraddress());
	    bb.setUsernumber(bb.getUsernumber());
	    bb.setUsername(username); // 세션으로 이미 가져왔기에 따로 get을 사용할 필요는 없다
	    bb.setEtc(userid);
	    
     	// 배송 정보 등록
	    int b = deliveryService.deliveryinsert(bb); // DB에 저장하기위해 작성
	    logger.info("" + bb);
	    
	    return "redirect:../book/list?page=1"; // book/list.jsp로 이동
	}


}
