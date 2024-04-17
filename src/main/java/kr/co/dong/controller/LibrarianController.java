//	사서 권한 기능 Controller
package kr.co.dong.controller;


import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dong.domain.AnswerBean;
import kr.co.dong.domain.BookBean;
import kr.co.dong.domain.DeliveryBean;
import kr.co.dong.domain.InterBean;
import kr.co.dong.domain.LibrarianBean;
import kr.co.dong.domain.LibraryBean;
import kr.co.dong.domain.NoticeDTO;
import kr.co.dong.domain.QuestionDTO;
import kr.co.dong.domain.saveBlacklistBean;
import kr.co.dong.domain.saveOverdueBean;
import kr.co.dong.domain.toRegularBean;
import kr.co.dong.service.LibrarianService;
import kr.co.dong.service.NoticeService;
import kr.co.dong.service.QuestionService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LibrarianController {
	
	private static final Logger logger = LoggerFactory.getLogger(LibrarianController.class);
	
	@Autowired
	LibrarianService librarianService;
	@Autowired
	QuestionService questionService;
	@Inject
	NoticeService noticeService;
	
//	@GetMapping(value = "librarianBooklist")
//	public String librarianBooklist(Model model) {
//		logger.info("이곳은 사서 권한 도서 목록입니다. ");
//		List<BookBean> list = librarianService.Booklist();
//		model.addAttribute("book", list);
//		return "librarian/booklist";
//	}
	
//	@GetMapping(value = "librarianRegularMemListAll")
//	public String librarianRegularMemListAll(Model model) {
//		logger.info("이곳은 사서 권한 정회원 전환 신청 전체 목록 보기입니다. ");
//		List<toRegularBean> list = librarianService.toRegularlist();
//		System.out.println(list);
//		model.addAttribute("regular", list);
//		return "librarian/regularMemListAll";
//	}
	
	@GetMapping(value = "librarianRegularMemListOne")
	public String librarianRegularMemListOne(@RequestParam("apply_code")int apply_code
			,Model model) {
		logger.info("이곳은 사서 권한 정회원 전환 신청 상세 보기입니다. ");
		System.out.println(apply_code);
		toRegularBean bean = librarianService.toRegularSelectOne(apply_code);
		model.addAttribute("regular", bean);
		
		return "librarian/regularMemListOne";
	}
	
	@PostMapping(value = "librarianRegularMemOk")
	public String librarianRegularMemOk(@RequestParam(value="apply_code", required=false)int apply_code
			,toRegularBean toregularbean
			,Model model) {
		logger.info("이곳은 사서 권한 정회원 전환 신청 수락 기능입니다. ");
		
		int r = librarianService.toRegularOk(toregularbean);
		System.out.println(apply_code);
		System.out.println(r);
		toregularbean = librarianService.toRegularSelectOne(apply_code);
		
		String userid = toregularbean.getUserid();
		System.out.println(userid);
		int r1 = librarianService.toRegularLevelUp(userid);
		System.out.println(r1);
		
		model.addAttribute("regular", apply_code);
		
		return "redirect:librarianRegularMemListAll";
	}
	
	@PostMapping(value = "librarianRegularMemNo")
	public String librarianRegularMemNo(@RequestParam("apply_code")int apply_code
			,toRegularBean toregularbean
			,Model model) {
		logger.info("이곳은 사서 권한 정회원 전환 신청 거절 기능입니다. ");
		
		int r = librarianService.toRegularNo(toregularbean);
		System.out.println(r);
		
		model.addAttribute("regular", apply_code);		
		
		return "redirect:librarianRegularMemListAll";
	}

//	연체 구제 신청
	@GetMapping(value = "librarianSaveOverdueListAll")
	public String librarianSaveOverdueListAll(Model model) {
		logger.info("이곳은 사서 권한 연체 구제 신청 전체 목록 보기입니다. ");
		List<saveOverdueBean> list = librarianService.saveOverduelist();
		System.out.println(list);
		model.addAttribute("saveOverdue", list);
		return "librarian/saveOverdueListAll";
	}
	
	@GetMapping(value = "librarianSaveOverdueListOne")
	public String librarianSaveOverdueListOne(@RequestParam("save_code")int save_code
			,Model model) {
		logger.info("이곳은 사서 권한 연체 구제 신청 상세 보기입니다. ");
		System.out.println(save_code);
		saveOverdueBean bean = librarianService.saveOverdueSelectOne(save_code);
		model.addAttribute("saveOverdue", bean);
		
		return "librarian/saveOverdueListOne";
	}
	
	@PostMapping(value = "librarianSaveOverdueOk")
	public String librarianSaveOverdueOk(@RequestParam(value="save_code", required=false)int save_code
			,saveOverdueBean saveoverduebean
			,Model model) {
		logger.info("이곳은 사서 권한 연체 구제 신청 수락 기능입니다. ");
		
		saveoverduebean = librarianService.saveOverdueSelectOne(save_code);
		System.out.println(save_code);
		System.out.println(saveoverduebean);
		int r = librarianService.saveOverdueOk(saveoverduebean);
		System.out.println(r);
		
		String userid = saveoverduebean.getUserid();
		System.out.println(userid);
		
		int r1 = librarianService.howManyOverdue(userid);
		System.out.println(r1);
		
		int r2 = librarianService.saveOverdueLevelUp(userid);
		System.out.println(r2);
		
		model.addAttribute("saveOverdue", save_code);
		
		return "redirect:librarianSaveOverdueListAll";
	}
	
	@PostMapping(value = "librarianSaveOverdueNo")
	public String librarianSaveOverdueNo(@RequestParam("save_code")int save_code
			,saveOverdueBean bean
			,Model model) {
		logger.info("이곳은 사서 권한 연체 구제 신청 거절 기능입니다. ");
		
		int r = librarianService.saveOverdueNo(bean);
		System.out.println(r);
		
		model.addAttribute("saveOverdue", save_code);		
		
		return "redirect:librarianSaveOverdueListAll";
	}
	
//	블랙리스트 구제 신청
	@GetMapping(value = "librarianBlacklistListAll")
	public String librarianBlacklistListAll(Model model) {
		logger.info("이곳은 사서 권한 블랙리스트 구제 신청 전체 목록 보기입니다. ");
		
		List<saveBlacklistBean> list = librarianService.saveBlacklistlist();
		System.out.println(list);
		model.addAttribute("blacklist", list);
		
		return "librarian/blacklistListAll";
	}
	
	@GetMapping(value = "librarianBlacklistListOne")
	public String librarianBlacklistListOne(@RequestParam("save_code")int save_code
			,Model model) {
		logger.info("이곳은 사서 권한 블랙리스트 구제 신청 상세 보기입니다. ");
		System.out.println(save_code);
		saveBlacklistBean bean = librarianService.saveBlacklistSelectOne(save_code);
		model.addAttribute("blacklist", bean);
		
		return "librarian/blacklistListOne";
	}
	
	@PostMapping(value = "librarianBlacklistOk")
	public String librarianBlacklistOk(@RequestParam(value="save_code", required=false)int save_code
			,saveBlacklistBean sob
			,Model model) {
		logger.info("이곳은 사서 권한 블랙리스트 구제 신청 수락 기능입니다. ");
		
		int r = librarianService.saveBlacklistOk(sob);
		System.out.println(save_code);
		System.out.println(r);
		sob = librarianService.saveBlacklistSelectOne(save_code);
		
		String userid = sob.getUserid();
		System.out.println(userid);
		int r1 = librarianService.saveBlacklistLevelUp(userid);
		System.out.println(r1);
		
		model.addAttribute("blacklist", save_code);
		
		return "redirect:librarianBlacklistListAll";
	}
	
	@PostMapping(value = "librarianBlacklistNo")
	public String librarianBlacklistNo(@RequestParam("save_code")int save_code
			,saveBlacklistBean sob
			,Model model) {
		logger.info("이곳은 사서 권한 블랙리스트 구제 신청 거절 기능입니다. ");
		
		int r = librarianService.saveBlacklistNo(sob);
		System.out.println(r);
		
		model.addAttribute("blacklist", save_code);		
		
		return "redirect:librarianBlacklistListAll";
	}
	
//	Q&A 답변 기능
	@GetMapping(value = "librarianQnaListAll")
	public String librarianQnaListAll(Model model) {
		logger.info("이곳은 사서 권한 Q&A 목록 보기입니다. ");
		List<QuestionDTO> list = librarianService.answerListAll();
		System.out.println(list);
		model.addAttribute("list", list);
		return "librarian/qnaListAll";
	}
	
	@GetMapping(value = "librarianQnaListOne")
	public String librarianQnaListOne(@RequestParam("question_num")int question_num
			,Model model) {
		logger.info("이곳은 사서 권한 Q&A 상세 보기입니다. ");
		System.out.println(question_num);
		QuestionDTO questionDTO= questionService.questionAndview(question_num);
		
		model.addAttribute("question", questionDTO);
		
		return "librarian/qnaListOne";
	}
	
	@GetMapping(value="librarianQnaAnswer")
	public String librarianQnaAnswerForm(@RequestParam("question_num")int question_num
			,Model model) {
		logger.info("이곳은 사서 권한 Q&A 답변 폼 페이지입니다. ");
		System.out.println(question_num);
		QuestionDTO questionDTO= questionService.questionAndview(question_num);
		System.out.println(questionDTO);
		model.addAttribute("question", questionDTO);
		
		
		return "librarian/qnaAnswer";
	}
	
	@PostMapping(value="librarianQnaAnswer")
	public String librarianQnaAnswer(@RequestParam("question_num")int question_num
			,@RequestParam("content")String content
			,@RequestParam("writer")String writer
			,AnswerBean bean
			,Model model) {
		logger.info("이곳은 사서 권한 Q&A 답변 기능입니다. ");
		System.out.println(question_num);
		System.out.println(content);
		System.out.println(writer);
		
		bean.setQuestion_num(question_num);
		bean.setContent(content);
		bean.setWriter(writer);
		System.out.println(bean);
		
		
		int r =librarianService.answerClear(question_num);
		int r1 = librarianService.answerInsert(bean);
		System.out.println(r);
		System.out.println(r1);
		
		return "redirect:librarianQnaListAll";
	}
	
//	공지사항 기능
	@GetMapping(value = "librarianNoticeListAll")
	public String librarianNoticeListAll(Model model) {
		logger.info("이곳은 사서 권한 공지사항 목록 보기입니다. ");
		List<NoticeDTO> list = noticeService.noticeAndlist();
		System.out.println(list);
		model.addAttribute("list", list);

		return "librarian/noticeListAll";
	}
	
	@GetMapping(value = "librarianNoticeListOne")
	public String librarianNoticeListOne(@RequestParam("notice_num")int notice_num
			,Model model) {
		logger.info("이곳은 사서 권한 공지사항 상세 보기입니다. ");
		System.out.println(notice_num);
		NoticeDTO noticeDTO= noticeService.noticeAndview(notice_num);
		
		model.addAttribute("notice", noticeDTO);
		
		return "librarian/noticeListOne";
	}
	
	@GetMapping(value = "librarianNoticeAdd")
	public String adminLibrarianAddForm() {
		logger.info("이곳은 사서 권한 공지사항 추가 폼 페이지입니다. ");
		
		return "librarian/noticeAdd";
	}
	
	@PostMapping(value = "librarianNoticeAdd")
	public String librarianNoticeAdd(@RequestParam("title")String title
			,@RequestParam("content")String content
			,@RequestParam("writer")String writer
			,NoticeDTO noticeDTO,
			Model model) {
		logger.info("이곳은 사서 권한 공지사항 추가 기능입니다. ");
				
		noticeDTO.setContent(title);
		noticeDTO.setContent(content);
		noticeDTO.setWriter(writer);
		
		librarianService.noticeAdd(noticeDTO);
		
		return "redirect:librarianNoticeListAll";
	}
	
	@GetMapping(value = "librarianNoticeUpdate")
	public String adminLibrarianUpdate(@RequestParam("notice_num")String notice_num
			,Model model) {
		logger.info("이곳은 사서 권한 공지사항 수정 폼입니다. ");
		
		int notice_num_int = Integer.parseInt(notice_num);
		NoticeDTO noticeDTO = noticeService.noticeAndview(notice_num_int);
		System.out.println(noticeDTO);
		model.addAttribute("notice", noticeDTO);
		
		return "librarian/noticeUpdate";
	}
	
	@PostMapping(value = "librarianNoticeUpdate")
	public String librarianNoticeUpdate(@RequestParam("notice_num")String notice_num
			,@RequestParam("title")String title
			,@RequestParam("content")String content
			,@RequestParam("writer")String writer
			,NoticeDTO noticeDTO
			,Model model) {
		logger.info("이곳은 사서 권한 공지사항 수정 기능입니다. ");
		
		librarianService.noticeUpdate(noticeDTO);
		
		model.addAttribute("notice", notice_num);
		
		return "redirect:librarianNoticeListOne?notice_num="+notice_num;
	}
	
	@PostMapping(value = "librarianNoticeDelete")
	public String librarianNoticeDelete(@RequestParam("notice_num")String notice_num
			,Model model) {
		logger.info("이곳은 사서 권한 공지사항 삭제 기능입니다. ");
		int notice_num_int = Integer.parseInt(notice_num);
		int r = librarianService.noticeDelete(notice_num_int);
		
		System.out.println(r);
		
		model.addAttribute("notice", notice_num_int);
		
		return "redirect:librarianNoticeListAll";
	}
	
	
//	상호대차 관리
	@GetMapping(value = "librarianInterlibListAll")
	public String librarianInterlibListAll(Model model) {
		logger.info("이곳은 사서 권한 상호대차 신청 목록 보기입니다. ");
		
		List<InterBean> list = librarianService.interliblist();
		System.out.println(list);
		model.addAttribute("list",list);
		
		return "librarian/interlibListAll";
	}
	
	@GetMapping(value = "librarianInterlibListOne")
	public String librarianInterlibListOne(@RequestParam("interid")int interid
			,Model model) {
		logger.info("이곳은 사서 권한 상호대차 신청 상세 보기입니다. ");
		System.out.println(interid);
		InterBean interbean= librarianService.interlibSelectOne(interid);
		System.out.println(interbean);
		model.addAttribute("inter", interbean);
		
		return "librarian/interlibListOne";
	}
	
	@PostMapping(value = "librarianInterlibOk")
	public String librarianInterlibOk(@RequestParam("interid")int interid
			,InterBean interbean
			,Model model) {
		logger.info("이곳은 사서 권한 상호대차 신청 수락 기능입니다. ");
		
		int r = librarianService.interlibOk(interbean);
		System.out.println(interid);
		System.out.println(r);
		
		return "redirect:librarianInterlibListAll";
	}
	
	@PostMapping(value = "librarianInterlibNo")
	public String librarianInterlibNo(@RequestParam("interid")int interid
			,InterBean interbean
			,Model model) {
		logger.info("이곳은 사서 권한 상호대차 신청 거절 기능입니다. ");
		
		int r = librarianService.interlibNo(interbean);
		System.out.println(interid);
		System.out.println(r);
		
		return "redirect:librarianInterlibListAll";
	}
	
//	배송 관리
	@GetMapping(value = "librarianDeliveryListAll")
	public String librarianDeliveryListAll(Model model) {
		logger.info("이곳은 사서 권한 배송 신청 목록 보기입니다. ");
		
		List<DeliveryBean> list = librarianService.deliverylist();		
		System.out.println(list);
		model.addAttribute("delivery",list);
		
		return "librarian/deliveryListAll";
	}
	
	@GetMapping(value = "librarianDeliveryListOne")
	public String librarianDeliveryListOne(@RequestParam("deliveryid")int deliveryid
			,Model model) {
		logger.info("이곳은 사서 권한 배송 신청 상세 보기입니다. ");
		System.out.println(deliveryid);
		DeliveryBean bean = librarianService.deliverySelectOne(deliveryid);
		System.out.println(bean);
		model.addAttribute("delivery", bean);
		
		return "librarian/deliveryListOne";
	}
	
	@PostMapping(value = "librarianDeliveryOk")
	public String librarianDeliveryOk(@RequestParam("deliveryid")int deliveryid
			,DeliveryBean bean
			,Model model) {
		logger.info("이곳은 사서 권한 배송 신청 수락 기능입니다. ");
		
		System.out.println(deliveryid);
		int r = librarianService.deliveryOk(bean);
		System.out.println(r);
		
		return "redirect:librarianDeliveryListAll";
	}
	
	@PostMapping(value = "librarianDeliveryNo")
	public String librarianDeliveryNo(@RequestParam("deliveryid")int deliveryid
			,DeliveryBean bean
			,Model model) {
		logger.info("이곳은 사서 권한 배송 신청 거절 기능입니다. ");
		
		int r = librarianService.deliveryNo(bean);
		System.out.println(bean);
		System.out.println(r);
		
		return "redirect:librarianDeliveryListAll";
	}

//	열람실 관리
	@GetMapping(value = "librarianReadingRoomListAll")
	public String librarianReadingroomListAll(Model model) {
		logger.info("이곳은 사서 권한 열람실 목록입니다. ");
		
		return "librarian/readingRoomListAll";
	}
	
	
	
	
}
