package kr.co.dong.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dong.domain.BookBean;
import kr.co.dong.domain.BookJoinDTO;
import kr.co.dong.domain.BookListBean;
import kr.co.dong.domain.LoanJoinDTO;
import kr.co.dong.domain.pageDTO;
import kr.co.dong.service.BookService;



@Controller
public class BookController {

	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	BookService service;
	
//	도서관 모든 도서 목록
	@GetMapping("book/list")
	public String list(@RequestParam("page")int page
			, Model model) {
		
		logger.info("--> page " +page);
		model.addAttribute("page", page);
		
//		페이지 생성 및 하단 번호 만들기
		pageDTO bookpage = new pageDTO();
		
		bookpage.setPage(page);
		bookpage.setPostNum(10);
		bookpage.setCount(service.count());
		logger.info("--> PostNum " + bookpage.getPostNum());
		logger.info("--> disPlayPost " + bookpage.getDisplayPost());
		
//		모든 도서 정보보기
		List<BookJoinDTO> allBook = null;
		
		allBook = service.allList(bookpage.getDisplayPost(), bookpage.getPostNum());

		model.addAttribute("allBook", allBook);
		
		model.addAttribute("pageNum", bookpage.getPageNum());
		
		logger.info("--> pageNum " + bookpage.getPageNum());
		logger.info("--> pagecnt " + bookpage.getPageCnt());
		
//		번호키
		model.addAttribute("startNum", bookpage.getStartNum());
		logger .info("--> startNum " + bookpage.getStartNum());
		model.addAttribute("endNum", bookpage.getEndNum());
		logger .info("--> endNum " + bookpage.getEndNum());
		
//		이동키
		model.addAttribute("prev", bookpage.getPrev());
		model.addAttribute("next", bookpage.getNext());
		
		return "book/list";
		
	}
	
	@GetMapping("book/marketin")
	public String marketin(@RequestParam Map<String, Object> map
			, HttpSession session
			, Model model) {
		System.out.println(map);
		map.put("userid", session.getAttribute("userid"));
		int result = service.marketin(map);
		logger.info("--> result " + result);
		
		if(result == 0) {
			return "redirect:/";
		}
		return "redirect:/book/list?page="+(String)map.get("page");
	}
	
	
//	도서 상세
	@GetMapping("book/detail")
	public String detail(@RequestParam("page")int page
			, @RequestParam("isbncode")String isbncode
			, @RequestParam("library_code")int library_code
			, Model model) {
		
		logger.info("--> library code " + library_code);
		
		BookJoinDTO bjd = service.detail(isbncode, library_code);
		model.addAttribute("book", bjd);
		model.addAttribute("page", page);
		
		return "book/detail";
		
	}
	
//	도서찾기
	@GetMapping("book/search")
	public String search(HttpServletRequest request
			, @RequestParam("page")int page
			, String keyword
			, Model model) throws UnsupportedEncodingException{
		
		request.setCharacterEncoding("utf-8");
		
		logger.info("--> page " + page);
		model.addAttribute("page", page);
		
//		페이지 생성
		pageDTO bookpage = new pageDTO();
		
		bookpage.setPage(page);
		bookpage.setPostNum(10);
		bookpage.setCount(service.bookSearchCount(keyword));
		logger.info("--> PostNum " + bookpage.getPostNum());
		logger.info("--> disPlayPost " + bookpage.getDisplayPost());
		
//		도서 검색
		List<BookJoinDTO> search = service.search(keyword, bookpage.getDisplayPost(), bookpage.getPostNum());
		model.addAttribute("search", search);

		logger.info("--> search " + search);
				
		model.addAttribute("pageNum", bookpage.getPageNum());
		logger.info("--> pageNum " + bookpage.getPageNum());
		
		
//		번호키
		model.addAttribute("startNum", bookpage.getStartNum());
		model.addAttribute("endNum", bookpage.getEndNum());
//		이동키
		model.addAttribute("prev", bookpage.getPrev());
		model.addAttribute("next", bookpage.getNext());
		
		return "book/search";
		
	}
	
//	도서 대출
	@PostMapping("book/loan")
	public String bookloan(HttpServletRequest request
			, String isbncode
			, Integer library_code
			, Integer page
			, Model model
			, HttpSession session) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		
		model.addAttribute("page", page);
		
		int loan_detail_num = service.loanCount() + 1;
		model.addAttribute("loan_detail_num", loan_detail_num);
		
		logger.info("--> isbncode " + isbncode);
		logger.info("--> code " + library_code);
		logger.info("--> num " + loan_detail_num);
		logger.info("--> userid " + session.getAttribute("userid"));
		
//		loan DB insert
		
		LoanJoinDTO loan = new LoanJoinDTO();
		loan.setIsbncode(isbncode);
		loan.setLibrary_code(library_code);
		loan.setLoan_detail_num(loan_detail_num);		
		loan.setUserid(String.valueOf(session.getAttribute("userid")));
		logger.info("--> ljd " + loan);
		
//		loan_detail DB insert
		
		LoanJoinDTO loan_detail = new LoanJoinDTO();
		loan_detail.setIsbncode(isbncode);
		loan_detail.setLibrary_code(library_code);
		loan_detail.setLoan_detail_num(loan_detail_num);
		loan_detail.setUserid(String.valueOf(session.getAttribute("userid")));
		logger.info("--> ljd " + loan_detail);
		
		int loanInsert = service.loan(loan);
		int loanDetail = service.loan_Detail(loan_detail);
		
	
//		대출증 페이지에서 출력할 데이터
//		도서 정보
		BookJoinDTO book = service.detail(isbncode, library_code);
		model.addAttribute("book", book);
		
//		도서 목록 대출 개수 수정
		int loan_status = book.getLoan_status() + 1;
		int book_list_num = book.getBook_list_num();
		int bookListStatusUpdate = service.bookListStatusUpdate(loan_status, book_list_num);

//		도서 대출증
		LoanJoinDTO loanCert = service.loanReturnCert(loan_detail_num);
		model.addAttribute("loanDetail", loanCert);
		
		
		return "book/loan";
	
	}
}
