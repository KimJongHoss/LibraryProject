																																																		package kr.co.dong.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.dong.controller.BoardController;
import kr.co.dong.domain.AnswerBean;
import kr.co.dong.domain.CommentDTO;
import kr.co.dong.domain.FreeDTO;
import kr.co.dong.domain.NoticeDTO;
import kr.co.dong.domain.QuestionDTO;
import kr.co.dong.domain.pageDTO;
import kr.co.dong.service.FreeService;
import kr.co.dong.service.LibrarianService;
import kr.co.dong.service.NoticeService;
import kr.co.dong.service.QuestionService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
		@Inject
		FreeService freeService;
		@Inject
		LibrarianService librarianservice;
		
		
//목록보기 
		@RequestMapping(value="free/list", method= RequestMethod.GET)
		public String freeAndlist(Model model, @RequestParam("page") int page) {
			model.addAttribute("page", page);
//페이지 생성 및 하단 번호 만들기
			pageDTO freepage = new pageDTO();
			
			freepage.setPage(page);
			freepage.setPostNum(10);
			freepage.setCount(freeService.freecount());  
		    logger.info("--> count " + freepage.getCount());

			List<FreeDTO> list = null; 
			list = freeService.freelistPage(freepage.getDisplayPost(), freepage.getPostNum());
			model.addAttribute("list", list); 
			
			model.addAttribute("pageNum", freepage.getPageNum());
			logger.info("--> pageNum " + freepage.getPageNum());
//			번호키
			model.addAttribute("startNum", freepage.getStartNum());
			model.addAttribute("endNum",freepage.getEndNum());
			logger.info("--> startNum " + freepage.getStartNum());
			logger.info("--> endNum " + freepage.getEndNum());
						
//			이동키
			model.addAttribute("prev", freepage.getPrev());
			model.addAttribute("next", freepage.getNext());
			logger.info("--> prev " + freepage.getPrev());
			logger.info("--> next " + freepage.getNext());
			
		return "free/listPage";
		}

		
//상세보기 
		@RequestMapping(value="free/view", method= RequestMethod.GET)
		public String freeAndview(@RequestParam("free_board_num")int free_board_num, Model model) {
			FreeDTO freeDTO= freeService.freeAndview(free_board_num);
			freeService.freeAndcount(free_board_num);
			
			model.addAttribute("freeDTO", freeDTO);
			return "free/view";
		}
//글쓰기
		@RequestMapping(value="free/write", method= RequestMethod.GET)
		public String freeAndwrite() {
			logger.info("글쓰기 이동");
			return "free/write";
		}
//글쓰기 
		@RequestMapping(value="free/write", method= RequestMethod.POST)
		public String freeAndwrite(FreeDTO freeDTO, HttpServletRequest request,RedirectAttributes rttr) throws Exception {
			request.setCharacterEncoding("UTF-8");
			logger.info("내용" + freeDTO);
			int r = freeService. freeAndregister(freeDTO);
			
			if(r>0) {
				rttr.addFlashAttribute("msg","추가에 성공하였습니다.");
			}
			return "redirect:list?page=1";
		}
//글수정 
		@RequestMapping(value="free/update", method= RequestMethod.GET)
		public String freeAndupdate(@RequestParam("free_board_num")int free_board_num, Model model) {
			logger.info("글 수정 이동");
			
			FreeDTO freeDTO= freeService.freeAndview(free_board_num);
			model.addAttribute("freeDTO", freeDTO);
			
			return "free/update";
		}
//글수정
		@RequestMapping(value="free/update", method= RequestMethod.POST)
		public String freeAndupdate(@RequestParam("free_board_num")int free_board_num, @RequestParam("writer")String writer , FreeDTO freeDTO, HttpServletRequest request,RedirectAttributes rttr) throws Exception {
			request.setCharacterEncoding("UTF-8");
			freeDTO.setFree_board_num(free_board_num);
			freeDTO.setWriter(writer);
			logger.info("내용" + freeDTO);
			int r = freeService. freeAndupdateReadCnt(freeDTO);
			
			if(r>0) {
				rttr.addFlashAttribute("msg","수정에 성공하였습니다.");
				
			}
			return "redirect:/free/list?page=1";
		}	
		
//글삭제
		@RequestMapping(value="free/delete", method= RequestMethod.GET)
		public String delete(@RequestParam("bno")int bno,RedirectAttributes rttr) {
			int Delete = freeService.Delete(bno);
			int r = freeService. freeAnddelete(bno);
			
			if(r>0) {
				rttr.addFlashAttribute("msg","글 삭제에 성공하였습니다.");
			return "redirect:/free/list?page=1";
				
			}
			return "redirect:/free/view?bno="+bno;
		}
		
		
		
		
// 공지사항
		@Inject
		NoticeService noticeService;
//목록보기 
		//목록보기 
				@RequestMapping(value="notice/list", method= RequestMethod.GET)
				public String noticeAndlist(Model model, @RequestParam("page") int page) {
					model.addAttribute("page", page);
		//페이지 생성 및 하단 번호 만들기
					pageDTO noticepage = new pageDTO();
					
					noticepage.setPage(page);
					noticepage.setPostNum(10);
					noticepage.setCount(noticeService.noticecount());  
				    logger.info("--> count " + noticepage.getCount());

					List<NoticeDTO> list = null; 
					list = noticeService.noticelistPage(noticepage.getDisplayPost(), noticepage.getPostNum());
					model.addAttribute("list", list); 
					
					model.addAttribute("pageNum", noticepage.getPageNum());
					logger.info("--> pageNum " + noticepage.getPageNum());
//					번호키
					model.addAttribute("startNum", noticepage.getStartNum());
					model.addAttribute("endNum",noticepage.getEndNum());
					logger.info("--> startNum " + noticepage.getStartNum());
					logger.info("--> endNum " + noticepage.getEndNum());
								
//					이동키
					model.addAttribute("prev", noticepage.getPrev());
					model.addAttribute("next", noticepage.getNext());
					logger.info("--> prev " + noticepage.getPrev());
					logger.info("--> next " + noticepage.getNext());
					
				return "notice/listPage";
				}
//상세보기 
		@RequestMapping(value="notice/view", method= RequestMethod.GET)
		public String noticeAndview(@RequestParam("notice_num")int notice_num, Model model) {
			NoticeDTO noticeDTO= noticeService.noticeAndview(notice_num);
			noticeService.noticeAndcount(notice_num);
			
			model.addAttribute("noticeDTO", noticeDTO);
			return "notice/view";
		}
		
		
		
// Q&A
		@Inject
		QuestionService questionService;
//목록 
			//목록보기 
			@RequestMapping(value="qna/list", method= RequestMethod.GET)
			public String questionAndlist(Model model, @RequestParam("page") int page) {
				model.addAttribute("page", page);
	//페이지 생성 및 하단 번호 만들기
				pageDTO questionpage = new pageDTO();
				
				questionpage.setPage(page);
				questionpage.setPostNum(10);
				questionpage.setCount(questionService.questioncount());  
			    logger.info("--> count " + questionpage.getCount());

				List<QuestionDTO> list = null; 
				list = questionService.questionlistPage(questionpage.getDisplayPost(), questionpage.getPostNum());
				model.addAttribute("list", list); 
				
				model.addAttribute("pageNum", questionpage.getPageNum());
				logger.info("--> pageNum " + questionpage.getPageNum());
//				번호키
				model.addAttribute("startNum", questionpage.getStartNum());
				model.addAttribute("endNum",questionpage.getEndNum());
				logger.info("--> startNum " + questionpage.getStartNum());
				logger.info("--> endNum " + questionpage.getEndNum());
							
//				이동키
				model.addAttribute("prev", questionpage.getPrev());
				model.addAttribute("next", questionpage.getNext());
				logger.info("--> prev " + questionpage.getPrev());
				logger.info("--> next " + questionpage.getNext());
				
			return "qna/listPage";
			}
//상세 
		@RequestMapping(value="qna/view", method= RequestMethod.GET)
		public String questionAndview(@RequestParam("question_num")int question_num, 
				Model model) {
			QuestionDTO questionDTO= questionService.questionAndview(question_num);
			questionService.questionAndcount(question_num);
			AnswerBean bean = librarianservice.answerListOne(question_num);
			System.out.println(bean);
			model.addAttribute("questionDTO", questionDTO);
			model.addAttribute("answer", bean);
			
			return "qna/view";
		}
//글쓰기
		@RequestMapping(value="qna/write", method= RequestMethod.GET)
		public String questionAndwrite() {
			logger.info("글쓰기 이동");
			return "qna/write";
		}
		@RequestMapping(value="qna/write", method= RequestMethod.POST)
		public String questionAndwrite(QuestionDTO questionDTO, HttpServletRequest request,RedirectAttributes rttr) throws Exception {
			request.setCharacterEncoding("UTF-8");
			logger.info("내용" + questionDTO);
			int r = questionService.questionAndregister(questionDTO);
			
			if(r>0) {
				rttr.addFlashAttribute("msg","추가에 성공하였습니다.");
			}
			return "redirect:list?page=1";
		}	
//글수정
		@RequestMapping(value="qna/update", method= RequestMethod.GET)
		public String questionAndupdate(@RequestParam("bno")int bno, Model model) {
			QuestionDTO questionDTO= questionService.questionAndview(bno);
			logger.info("글 수정 이동");
			model.addAttribute("questionDTO", questionDTO);
			return "qna/update";
		}
//글수정
		@RequestMapping(value="qna/update", method= RequestMethod.POST)
		public String questionAndupdate(@RequestParam("bno")int bno, @RequestParam("writer")String writer , QuestionDTO questionDTO, HttpServletRequest request,RedirectAttributes rttr) throws Exception {
			request.setCharacterEncoding("UTF-8");
			
			questionDTO.setQuestion_num(bno);
			questionDTO.setWriter(writer);
			logger.info("내용" + questionDTO);
			int r = questionService.questionAndupdateReadCnt(questionDTO);
			
			if(r>0) {
				rttr.addFlashAttribute("msg","수정에 성공하였습니다.");
				
			}
			return "redirect:/qna/list?page=1";
		}	
		
// 게시글 삭제 
		@RequestMapping(value="qna/delete", method= RequestMethod.GET)
		public String questionAnddelete(@RequestParam("bno")int bno,RedirectAttributes rttr) {
			
			int r = questionService.questionAnddelete(bno);
			
			if(r>0) {
				rttr.addFlashAttribute("msg","글 삭제에 성공하였습니다.");
			return "redirect:/qna/list?page=1";
				
			}
			return "redirect:/qna/view?bno="+bno;
		}
		//댓글 
				@ResponseBody
				@PostMapping(value="free/replylist")
				public List<CommentDTO> replylist(@RequestParam("free_board_num")int free_board_num){
					return freeService.Detail1(free_board_num);
				}
				
		//댓글쓰기
				@ResponseBody
				@PostMapping(value="free/reply")
				public int reply(CommentDTO commentDTO) {
					return freeService.reply(commentDTO);
					}
		//댓글수정
				@ResponseBody
				@PostMapping(value="free/replyupdate")
				public int replyupdate(CommentDTO commentDTO) {
					return freeService.replyupdate(commentDTO);
				}
		//댓글삭제 
				@ResponseBody
				@PostMapping(value="free/replyDelete")
				public int replyDelete(int bno) {
					return freeService.replyDelete(bno);
				}
				
			}
	
