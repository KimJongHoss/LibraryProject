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
import kr.co.dong.domain.BookListBean;
import kr.co.dong.domain.LibrarianBean;
import kr.co.dong.domain.LibraryBean;
import kr.co.dong.domain.LoanDTO;
import kr.co.dong.domain.LoanJoinDTO;
import kr.co.dong.domain.pageDTO;
import kr.co.dong.service.AdminService;
import kr.co.dong.service.BookService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	BookService service;
	
	@Autowired
	AdminService adminService;
	
//	도서관 모든 도서 목록
	@GetMapping("librarianBooklist")
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
		
		return "librarian/booklist";
		
	}
	
//	도서 상세
	@GetMapping("librarianBookdetail")
	public String detail(@RequestParam("page")int page
			, @RequestParam("isbncode")String isbncode
			, @RequestParam("library_code")int library_code
			, Model model) {
		
		logger.info("--> library code " + library_code);
		
		BookJoinDTO bjd = service.detail(isbncode, library_code);
		model.addAttribute("book", bjd);
		model.addAttribute("page", page);
		
		return "librarian/bookdetail";
		
	}
	
//	도서찾기
	@GetMapping("librarian/booksearch")
	public String search(HttpServletRequest request
			, @RequestParam("page")int page
			, String keyword
			, Model model) throws UnsupportedEncodingException{
		
		request.setCharacterEncoding("utf-8");
		
		logger.info("--> keyword " + keyword);
		logger.info("--> page " + page);
		model.addAttribute("page", page);
		
//		페이지 생성
		pageDTO bookpage = new pageDTO();
		
		bookpage.setPage(page);
		bookpage.setPostNum(10);
		bookpage.setCount(service.bookSearchCount(keyword));
		logger.info("--> PostNum " + bookpage.getPostNum());
		logger.info("--> disPlayPost " + bookpage.getDisplayPost());
		logger.info("--> count " + bookpage.getCount());
		
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
		
		return "librarian/booksearch";
		
	}
	
//	도서 정보추가 이동
	@GetMapping("librarian/bookinsert")
	public String bookInsert(@RequestParam("page")int page
			, Model model) {
		
		model.addAttribute("page", page);
		
		logger.info("도서 추가 폼으로 이동");
		
		return "librarian/bookinsert";
	
	}
	
//	도서 정보추가
	@PostMapping("librarian/bookinsert")
	public String bookInsert(HttpServletRequest request
			, BookBean bookinsert
			, @RequestParam("page")int page) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		
		logger.info("--> bookinsert " + bookinsert);
		
		int insert = service.insert(bookinsert);
		
		return "redirect:/librarian/bookinfolist?page=" + page;
		
	}
	
//	도서관 소장 도서추가 이동
	@GetMapping("librarian/booklistinsert")
	public String bookListInsertForm(@RequestParam("page")int page
			, Model model) {
		
		model.addAttribute("page", page);
		logger.info("도서 목록 추가 이동");
		
		return "librarian/booklistinsert";
		
	}
	
//	도서관 소장 도서추가
	@PostMapping("librarian/booklistinsert")
	public String bookListInsert(HttpServletRequest request
			, BookJoinDTO bookinsert
			, @RequestParam("page")int page) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		
		logger.info("--> bookinsert " + bookinsert);
		
		int insert = service.libraryBookInsert(bookinsert);
		
		return "redirect:/librarian/booklist?page=" + page;
		
	}
	
//	도서 정보 수정 이동
	@GetMapping("librarian/bookupdate")
	public String bookUpdateForm(@RequestParam("isbncode")String isbncode
			, @RequestParam("page")int page
			, Model model) {
		
		logger.info("도서 수정 폼으로 이동");
		
		
		BookBean before = service.bookupdatebefore(isbncode);
		model.addAttribute("update", before);
		model.addAttribute("page", page);
		model.addAttribute("isbncode", isbncode);
		logger.info("--> bjd" + before);
		
		return "librarian/bookupdate";
		
	}
	
//	도서 정보 수정
	@PostMapping("librarian/bookupdate")
	public String bookUpdate(HttpServletRequest request
			, BookJoinDTO bookinsert
			, @RequestParam("page")int page) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		
		
		logger.info("--> bookinsert " + bookinsert);
		
		int update = service.update(bookinsert);
		
		
		return "redirect:/librarian/bookinfolist?page=" + page;
		
	}
	
//	도서관 소장 도서수정 이동
	@GetMapping("librarian/booklistupdate")
	public String booklistupdateForm(HttpServletRequest request
			, @RequestParam("isbncode")String isbncode
			, @RequestParam("library_code")int library_code
			, @RequestParam("page")int page
			, Model model) {
		
		logger.info("도서관 소장 도서 수정으로 이동");
		
		BookJoinDTO booklistupdate = service.detail(isbncode, library_code);
		model.addAttribute("library_code", library_code);
		model.addAttribute("listupdate", booklistupdate);
		model.addAttribute("page", page);
		
		logger.info("--> listupdate " + booklistupdate);
		
		return"librarian/booklistupdate";
		
	}
	
//	도서관 소장 도서수정
	@PostMapping("librarian/booklistupdate")
	public String booklistupdate(HttpServletRequest requset
			, BookJoinDTO bookinsert
			, @RequestParam("page")int page) throws UnsupportedEncodingException {
		
		requset.setCharacterEncoding("utf-8");
		
		logger.info("--> bookinsert " + bookinsert);
		
		int listupdate= service.libraryBookUpdate(bookinsert);
		
		return "redirect:/librarian/bookdetail?isbncode=" + bookinsert.getIsbncode() + "&library_code=" + bookinsert.getLibrary_code() + "&page=" + page;
	}
	
//	도서삭제
	@ResponseBody
	@PostMapping("librarian/bookdelete")
	public int bookdelete(@RequestParam("isbncode")String isbncode) {
		
		return service.delete(isbncode);
		
	}
	
	
//	도서관 소장 도서 삭제
	@GetMapping("librarian/booklistdelete")
	public String booklistdelete(@RequestParam("book_list_num")int book_list_num
			, @RequestParam("page")int page) {
		
		int listdelete = service.libraryBookDelete(book_list_num);
		
		logger.info("도서관 소장 도서가 삭제되었습니다.");
		
		return "redirect:/librarian/booklist?page=" + page;
		
	}
	
	
//	도서 대출 리스트
	@GetMapping("librarianLoanlist")
	public String loanlist(@RequestParam("page")int page
			, Model model) {
		
		logger.info("--> page " + page);
		model.addAttribute("page", page);
		
//		페이지 생성 및 하단 번호 만들기
		pageDTO loanpage = new pageDTO();
		
		loanpage.setPage(page);
		loanpage.setPostNum(10);
		loanpage.setCount(service.loanCount());
		logger.info("--> PostNum " + loanpage.getPostNum());
		logger.info("--> displayPost " + loanpage.getDisplayPost());
		
//		대출 목록 
		List<LoanDTO> loanlist = null;
		
		loanlist = service.loanList(loanpage.getDisplayPost(), loanpage.getPostNum());
		
		model.addAttribute("loanlist", loanlist);
		model.addAttribute("pageNum", loanpage.getPageNum());
		
		logger.info("--> pageNum " + loanpage.getPageNum());
		logger.info("--> pagecnt " + loanpage.getPageCnt());
		
//		번호키
		model.addAttribute("startNum", loanpage.getStartNum());
		model.addAttribute("endNum", loanpage.getEndNum());
		
//		이동키
		model.addAttribute("prev", loanpage.getPrev());
		model.addAttribute("next", loanpage.getNext());
		
		return "librarian/loanlist";
		
	}
	
//	대출 상세
	@GetMapping("librarian/loandetail")
	public String loandetail(@RequestParam("loan_detail_num")int loan_detail_num
			, @RequestParam("library_code")int library_code
			, @RequestParam("page")int page
			, Model model) {
		
		LoanJoinDTO loandetail = service.loanDetailList(loan_detail_num, library_code);
		model.addAttribute("loandetail", loandetail);
		model.addAttribute("page", page);
		
		
		return "librarian/loandetail";
		
	}
	
//	도서반납
	@GetMapping("librarianReturn")
	public String bookreturn(HttpServletRequest request
			, @RequestParam("loan_detail_num")int loan_detail_num
			, @RequestParam("isbncode")String isbncode
			, @RequestParam("library_code")int library_code
			, Integer page
			, Model model) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		
		model.addAttribute("page", page);
		
		int returnbook = service.returnbook(loan_detail_num);
		
		logger.info(returnbook+"성공여부");
		logger.info("--> isbncode " + isbncode);
		logger.info("--> code " + library_code);
		logger.info("--> num " + loan_detail_num);
		
		
//		반납증 페이지에서 출력할 데이터
//		도서 정보
		
		BookJoinDTO book = service.detail(isbncode, library_code);
		model.addAttribute("book", book);
		
//		도서 반납증
		LoanJoinDTO loanCert = service.loanReturnCert(loan_detail_num);
		model.addAttribute("loanDetail", loanCert);
		
		return "librarian/return";
		
	}

//	도서 추가 isbncode 중복확인
	@ResponseBody
	@PostMapping("/librarianisbncodeCheck")
	public int librarianisbncodeCheck(@RequestParam("isbncode")String isbncode) {
		
		logger.info("--> isbncode" + isbncode);
		int isbncodeCheck = '0'; 
		isbncodeCheck = service.librarianisbncodeCheck(isbncode); 
		
		return isbncodeCheck;
	}
	
//	대출리스트 검색
	@GetMapping("librarian/loansearch")
	public String loanListsearch(HttpServletRequest request
			, @RequestParam("page")int page
			, String keyword
			, Model model) throws UnsupportedEncodingException{
		
		request.setCharacterEncoding("utf-8");
		
		logger.info("--> page " + page);
		model.addAttribute("page", page);
		
//		페이지 생성
		pageDTO loanpage = new pageDTO();
		
		loanpage.setPage(page);
		loanpage.setPostNum(10);
		loanpage.setCount(service.loanSearchCount(keyword));
		logger.info("--> PostNum " + loanpage.getPostNum());
		logger.info("--> disPlayPost " + loanpage.getDisplayPost());
		logger.info("--> count " + loanpage.getCount());
		
//		도서 검색
		List<LoanDTO> search = service.loanListSearch(keyword, loanpage.getDisplayPost(), loanpage.getPostNum());
		model.addAttribute("search", search);

		logger.info("--> search " + search);
				
		model.addAttribute("pageNum", loanpage.getPageNum());
		logger.info("--> pageNum " + loanpage.getPageNum());
		
		
//		번호키
		model.addAttribute("startNum", loanpage.getStartNum());
		model.addAttribute("endNum", loanpage.getEndNum());
//		이동키
		model.addAttribute("prev", loanpage.getPrev());
		model.addAttribute("next", loanpage.getNext());
		
		return "librarian/loansearch";
		
	}
	
//	도서 정보 목록
	@GetMapping("librarianBookinfolist")
	public String bookinfolist(@RequestParam("page")int page
			, Model model) {
		
		logger.info("--> page " + page);
		model.addAttribute("page", page);
		
//		페이지생성
		pageDTO bookinfo = new pageDTO();
		
		bookinfo.setPage(page);
		bookinfo.setPostNum(10);
		bookinfo.setCount(service.bookInfoCount());
		logger.info("--> PostNum " + bookinfo.getPostNum());
		logger.info("--> displayPost " + bookinfo.getDisplayPost());
		logger.info("--> count " + bookinfo.getCount());
		
//		도서 정보 목록
		List<BookBean> bookinfolist = service.bookList(bookinfo.getDisplayPost(), bookinfo.getPostNum());
		model.addAttribute("bookinfolist", bookinfolist);
		model.addAttribute("pageNum", bookinfo.getPageNum());
		logger.info("--> bookinfolist " + bookinfolist);
		logger.info("--> pageNum " + bookinfo.getPageNum());
				
//		번호키
		model.addAttribute("startNum", bookinfo.getStartNum());
		model.addAttribute("endNum", bookinfo.getEndNum());
//		이동키
		model.addAttribute("prev", bookinfo.getPrev());
		model.addAttribute("next", bookinfo.getNext());
		
		return "librarian/bookinfolist";
		
	}
	
//	도서정보 검색
	@GetMapping("librarian/bookinfosearch")
	public String bookinfosearch(HttpServletRequest request
			, @RequestParam("page")int page
			, String keyword
			, Model model) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		
		logger.info("--> page " + page);
		logger.info("--> keyword " + keyword);
		model.addAttribute("page", page);
		
//		페이지 생성
		pageDTO infosearch = new pageDTO();
		
		infosearch.setPage(page);
		infosearch.setPostNum(10);
		infosearch.setCount(service.bookInfoSearchCount(keyword));
		logger.info("--> postNum " + infosearch.getPostNum());
		logger.info("--> displayPost " + infosearch.getDisplayPost());
		logger.info("--> count " + infosearch.getCount());
		
//		도서정보 검색
		List<BookBean> bookinfosearch = service.bookInfoSearch(keyword, infosearch.getDisplayPost(), infosearch.getPostNum());
		model.addAttribute("bookinfosearch", bookinfosearch);
		model.addAttribute("pageNum", infosearch.getPageNum());
		logger.info("--> bookinfosearch " + bookinfosearch);
		logger.info("--> pageNum " + infosearch.getPageNum());
		
//		번호키
		model.addAttribute("startNum", infosearch.getStartNum());
		model.addAttribute("endNum", infosearch.getEndNum());
		logger.info("--> startNum " + infosearch.getStartNum());
		logger.info("--> endNum " + infosearch.getEndNum());
//		이동키
		model.addAttribute("prev", infosearch.getPrev());
		model.addAttribute("next", infosearch.getNext());
		logger.info("--> prev " + infosearch.getPrev());
		logger.info("--> next " + infosearch.getNext());
		
		return "librarian/bookinfosearch";
	}
	
//	도서 목록추가 도서 중복확인
	@ResponseBody
	@PostMapping("/librarianlistCheck")
	public int librarianlistCheck(@RequestParam("isbncode")String isbncode
			,@RequestParam("library_code")int library_code) {
		
		logger.info("--> isbncode " + isbncode);
		logger.info("--> library_code " + library_code);
		int listCheck = '0'; 
		listCheck = service.librarianListCheck(isbncode, library_code); 
		logger.info("--> listCheck " + listCheck);
		
		return listCheck;
	}
	
//	도서 목록 등록 확인
	@ResponseBody
	@PostMapping("/bookListCheck")
	public int booklistCheck(@RequestParam("isbncode")String isbncode) {
		
		
		return service.bookListCheck(isbncode);
	}
	
//	도서관 Mapping
	@GetMapping(value = "adminLibraryListAll")
	public String adminLibraryListAll(Model model) {
		logger.info("이곳은 관리자 권한 도서관 목록 보기입니다. ");
		
		List<LibraryBean> list = adminService.librarylist();
		model.addAttribute("library", list);
		return "admin/libraryListAll";
	}
	
	@GetMapping(value = "adminLibraryListOne")
	public String adminLibraryListOne(@RequestParam("library_code")int library_code
			,Model model) {
		logger.info("이곳은 관리자 권한 도서관 정보 상세 보기입니다. ");
		
		LibraryBean bean = adminService.librarySelectOne(library_code);
		model.addAttribute("library", bean);
		
		return "admin/libraryListOne";
	}
	
	@GetMapping(value = "adminLibraryAdd")
	public String adminLibraryAdd() {
		logger.info("이곳은 관리자 권한 도서관 추가 폼 페이지입니다. ");
		
		return "admin/libraryAdd";
	}
	
	@PostMapping(value = "adminLibraryAdd")
	public String adminLibraryAdd(LibraryBean librarybean
			,Model model) {
		logger.info("이곳은 관리자 권한 도서관 추가 기능입니다. ");
		
		int r = adminService.libraryInsert(librarybean);
		
		return "redirect:adminLibraryListAll";
	}
	
	@GetMapping(value = "adminLibraryUpdate")
	public String adminLibraryUpdate(@RequestParam("library_code")int library_code
			,Model model) {
		logger.info("이곳은 관리자 권한 도서관 수정 폼입니다. ");
		
		LibraryBean librarybean = adminService.librarySelectOne(library_code);
		model.addAttribute("library", librarybean);
		
		
		return "admin/libraryUpdate";
	}
	
	@PostMapping(value = "adminLibraryUpdate")
	public String adminLibraryUpdate(@RequestParam("library_code")int library_code
			,LibraryBean librarybean
			,Model model) {
		logger.info("이곳은 관리자 권한 도서관 수정 기능입니다. ");
		
		int r = adminService.libraryUpdate(librarybean);
		
		model.addAttribute("library", library_code);
		
		return "redirect:adminLibraryListOne?library_code="+library_code;
	}
	
	@PostMapping(value = "adminLibraryDelete")
	public String adminLibraryDelete(@RequestParam("library_code")int library_code
			,Model model) {
		logger.info("이곳은 관리자 권한 도서관 삭제 기능입니다. ");
		
		int r = adminService.libraryDelete(library_code);
		
		System.out.println(r);
		
		model.addAttribute("library", library_code);
		
		return "redirect:adminLibraryListAll";
	}
	
//	사서 Mapping
	@GetMapping(value = "adminLibrarianListAll")
	public String adminLibrarianListAll(Model model) {
		logger.info("이곳은 관리자 권한 사서 목록 보기입니다. ");
		
		List<LibrarianBean> list = adminService.librarianlist();
		model.addAttribute("librarian", list);
		return "admin/librarianListAll";
	}
	
	@GetMapping(value = "adminLibrarianListOne")
	public String adminLibrarianListOne(@RequestParam("id")String id
			,Model model) {
		logger.info("이곳은 관리자 권한 사서 정보 상세 보기입니다. ");
		
		LibrarianBean bean = adminService.librarianSelectOne(id);
		model.addAttribute("librarian", bean);
		return "admin/librarianListOne";
	}
	
	@GetMapping(value = "adminLibrarianAdd")
	public String adminLibrarianAddForm() {
		logger.info("이곳은 관리자 권한 사서 추가 폼 페이지입니다. ");
		
		return "admin/librarianAdd";
	}
	
	@PostMapping(value = "adminLibrarianAdd")
	public String adminLibrarianAdd(LibrarianBean librarianbean,
			Model model) {
		logger.info("이곳은 관리자 권한 사서 추가 기능입니다. ");
		
		adminService.librarianInsert(librarianbean);
		
		return "redirect:adminLibrarianListAll";
	}
	
	@RequestMapping("librarianIdCheck")
	@ResponseBody
	public Integer librarianIdCheck(@RequestParam("id") String id) {
		logger.info("이곳은 관리자 권한 사서 추가 아이디 체크 기능입니다. ");
		System.out.println(id);
		if(id == "") {
			return -1;
		}
		int result = adminService.idCheck(id);
		System.out.println(result);
		
		return result;
	}
	
	@GetMapping(value = "adminLibrarianUpdate")
	public String adminLibrarianUpdate(@RequestParam("id")String id
			,Model model) {
		logger.info("이곳은 관리자 권한 사서 수정 폼입니다. ");
		
		LibrarianBean librarianbean = adminService.librarianSelectOne(id);
		model.addAttribute("librarian", librarianbean);
		
		
		return "admin/librarianUpdate";
	}
	
	@PostMapping(value = "adminLibrarianUpdate")
	public String adminLibrarianUpdate(@RequestParam("id")String id
			,LibrarianBean librarianbean
			,Model model) {
		logger.info("이곳은 관리자 권한 사서 수정 기능입니다. ");
		
		int r = adminService.librarianUpdate(librarianbean);
		
		model.addAttribute("librarian", id);
		
		return "redirect:adminLibrarianListOne?id="+id;
	}
	
	@PostMapping(value = "adminLibrarianDelete")
	public String adminLibrarianDelete(@RequestParam("id")String id
			,Model model) {
		logger.info("이곳은 관리자 권한 사서 삭제 기능입니다. ");
		
		int r = adminService.librarianDelete(id);
		
		System.out.println(r);
		
		model.addAttribute("librarian", id);
		
		return "redirect:adminLibrarianListAll";
	}
}
