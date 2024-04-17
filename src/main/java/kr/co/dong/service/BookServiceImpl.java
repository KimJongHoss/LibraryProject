package kr.co.dong.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dong.DAO.BookDAO;
import kr.co.dong.domain.BookBean;
import kr.co.dong.domain.BookJoinDTO;
import kr.co.dong.domain.BookListBean;
import kr.co.dong.domain.LoanDTO;
import kr.co.dong.domain.LoanJoinDTO;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDAO dao;
	
	@Autowired
	SqlSession sqlSession;

//	보유한 도서 총수
	@Override
	public int count() {
		// TODO Auto-generated method stub
		
		return dao.count();
	}

//	도서 정보 보기
	@Override
	public List<BookJoinDTO> allList(int displayPost, int postNum) {
		// TODO Auto-generated method stub
		
		return dao.allList(displayPost, postNum);
	}

//	도서 상세보기
	@Override
	public BookJoinDTO detail(String isbncode, int library_code) {
		// TODO Auto-generated method stub
		
		return dao.detail(isbncode, library_code);
	}

//	도서 검색
	@Override
	public List<BookJoinDTO> search(String keyword, int displayPost, int postNum) {
		// TODO Auto-generated method stub
		
		return dao.search(keyword, displayPost, postNum);
	}

//	도서 검색 총수
	@Override
	public int bookSearchCount(String keyword) {
		// TODO Auto-generated method stub
		
		return dao.bookSearchCount(keyword);
	}
	
//	도서 대출 총 수
	@Override
	public int loanCount() {
		// TODO Auto-generated method stub
		
		return dao.loanCount();
	}
	
//	도서 대출(상세)등록
	@Override
	public int loan_Detail(LoanJoinDTO ljd) {
		// TODO Auto-generated method stub
		
		return dao.loan_Detail(ljd);
	}

//	도서 대출(목록)등록 
	@Override
	public int loan(LoanJoinDTO ljd) {
		// TODO Auto-generated method stub
		
		return dao.loan(ljd);
	}

//	도서 대출/반납증 
	@Override
	public LoanJoinDTO loanReturnCert(int loan_detail_num) {
		// TODO Auto-generated method stub
		
		return dao.loanReturnCert(loan_detail_num);
	}
	
//	도서 대출 개수 수정
	@Override
	public int bookListStatusUpdate(int loan_status, int book_list_num) {
		// TODO Auto-generated method stub
		
		return dao.bookListStatusUpdate(loan_status, book_list_num);
	}
	
	
//	도서 정보
	@Override
	public BookJoinDTO bookDetail(String isbncode) {
		// TODO Auto-generated method stub
		
		return dao.bookDetail(isbncode);
	}
	
//	도서 정보 추가
	@Override
	public int insert(BookBean bjd) {
		// TODO Auto-generated method stub
		
		return dao.insert(bjd);
	}

//	도서관 소장 도서 추가
	@Override
	public int libraryBookInsert(BookJoinDTO bjd) {
		// TODO Auto-generated method stub
		
		return dao.libraryBookInsert(bjd);
	}

//	도서 정보 수정
	@Override
	public int update(BookJoinDTO bjd) {
		// TODO Auto-generated method stub
		
		return dao.update(bjd);
	}
	
//	도서관 소장 도서 수정
	@Override
	public int libraryBookUpdate(BookJoinDTO bjd) {
		// TODO Auto-generated method stub
		
		return dao.libraryBookUpdate(bjd);
	}

//	도서 정보 삭제
	@Override
	public int delete(String isbncode) {
		// TODO Auto-generated method stub
		
		return dao.delete(isbncode);
	}

//	도서관 소장 도서 삭제
	@Override
	public int libraryBookDelete(int book_list_num) {
		// TODO Auto-generated method stub
		
		return dao.libraryBookDelete(book_list_num);
	}

//	도서 대출 리스트
	@Override
	public List<LoanDTO> loanList(int displayPost, int postNum) {
		// TODO Auto-generated method stub
		
		return dao.loanList(displayPost, postNum);
	}
	
//	대출 상세
	@Override
	public LoanJoinDTO loanDetailList(int loan_detail_num, int library_code) {
		// TODO Auto-generated method stub
		
		return dao.loanDetailList(loan_detail_num, library_code);
	}
	
//  도서 반납
	@Override
	public int returnbook(int loan_detail_num) {
		// TODO Auto-generated method stub
		
		return dao.returnbook(loan_detail_num);
	}

//	도서 추가 isbncode 중복확인
	@Override
	public int librarianisbncodeCheck(String isbncode) {
		// TODO Auto-generated method stub
		
		return dao.librarianisbncodeCheck(isbncode);
	}

//	대출리스트 검색
	@Override
	public List<LoanDTO> loanListSearch(String keyword, int displayPost, int postNum) {
		// TODO Auto-generated method stub
		
		return dao.loanListSearch(keyword, displayPost, postNum);
	}

//  대출검색 수량
	@Override
	public int loanSearchCount(String keyword) {
		// TODO Auto-generated method stub
		
		return dao.loanSearchCount(keyword);
	}

//	도서 정보 목록
	@Override
	public List<BookBean> bookList(int displayPost, int postNum) {
		// TODO Auto-generated method stub

		return dao.bookList(displayPost, postNum);
	}

//	도서 정보 총 수
	@Override
	public int bookInfoCount() {
		// TODO Auto-generated method stub
		
		return dao.bookInfoCount();
	}

//	도서정보 검색
	@Override
	public List<BookBean> bookInfoSearch(String keyword, int displayPost, int postNum) {
		// TODO Auto-generated method stub
		
		return dao.bookInfoSearch(keyword, displayPost, postNum);
	}

//	도서정보 검색 총수
	@Override
	public int bookInfoSearchCount(String keyword) {
		// TODO Auto-generated method stub
		
		return dao.bookInfoSearchCount(keyword);
	}

//	도서정보 수정용 정보
	@Override
	public BookBean bookupdatebefore(String isbncode) {
		// TODO Auto-generated method stub
	
		return dao.bookupdatebefore(isbncode);
	}

//	도서 목록추가 도서 중복확인
	@Override
	public int librarianListCheck(String isbncode, int library_code) {
		// TODO Auto-generated method stub
		
		return dao.librarianListCheck(isbncode, library_code);
	}

//	도서 목록 등록 확인
	@Override
	public int bookListCheck(String isbncode) {
		// TODO Auto-generated method stub
		
		return dao.bookListCheck(isbncode);
	}
	
	@Override
	public int marketin(Map<String, Object> map) {
		int marketSelect = dao.marketSelect(map);
		int select = dao.bookSelect(map);
		if(marketSelect != 1) {
			if(select != 0) {
				return dao.marketin(map);
			}
		}
		return 0;
	}












}
