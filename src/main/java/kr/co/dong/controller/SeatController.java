package kr.co.dong.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dong.domain.SeatRoomDTO;
import kr.co.dong.service.SeatRoomService;

@Controller
public class SeatController {
private static final Logger logger = LoggerFactory.getLogger(SeatController.class);
	
	@Autowired
	SeatRoomService service;
	
//  좌석 리스트 가져오기
	@GetMapping(value="openBoard/readingroomListAll")
	public String getList(Model model) {
		logger.info("좌석으로 이동완료!");
		List<SeatRoomDTO> list = null;
		list = service.list();
		System.out.println(list);
		model.addAttribute("list", list);
		return "openBoard/readingroomListAll";
	}
	
//	좌석 예약하기(GET)
	@GetMapping(value="openBoard/reservation")
	public void getReservation(@RequestParam("seat_no") int seat_no,  Model model) {
		
	}
//	좌석 예약하기(POST)
	@PostMapping(value="openBoard/reservation") 
	public String postReservation(SeatRoomDTO sr) {
		
		return "redirect:openBoard/readingroomListAll";
	}
	
//	좌석 수정하기(GET)
	@GetMapping(value="openBoard/modify")
	public void getModify(Model model) {
		
	}
//	좌석 수정하기(POST)
	@PostMapping(value="openBoard/modify")
	public String postModify(Model model) {
		return "redirect:openBoard/readingroomListAll";
	}
	
//	좌석 취소하기
	@GetMapping(value="openBoard/cancel")
	public String getCancel(Model model) {
		return "redirect:openBoard/cancel";
	}
	
}
