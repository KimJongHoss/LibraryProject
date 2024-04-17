package kr.co.dong.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import kr.co.dong.domain.BookBean;
import kr.co.dong.domain.BookJoinDTO;
import kr.co.dong.domain.BookListBean;
import kr.co.dong.domain.LoanDTO;
import kr.co.dong.domain.LoanJoinDTO;

public interface BookService {

	public int count(); //보유한 도서 총수
	public List<BookJoinDTO> allList(int displayPost, int postNum); //도서 정보보기
	public BookJoinDTO detail(String isbncode, int library_code); //도서 상세
	public List<BookJoinDTO> search(String keyword, int displayPost, int postNum); //도서 검색
	public int bookSearchCount(String keyword); //도서 검색 총수
	public int loanCount(); //도서 대출 총 수
	public int loan_Detail(LoanJoinDTO ljd); //도서 대출(상세)등록
	public int loan(LoanJoinDTO ljd); //도서 대출(목록)등록
	public LoanJoinDTO loanReturnCert(int loan_detail_num); //도서 대출/반납증
	public int bookListStatusUpdate(int loan_status, int book_list_num); //도서 대출 개수 수정
	public BookJoinDTO bookDetail(String isbncode);//도서 정보
	public int insert(BookBean bjd); //도서 정보 추가
	public int libraryBookInsert(BookJoinDTO bjd); //도서관 소장 도서 추가
	public int update(BookJoinDTO bjd); //도서 정보 수정
	public int libraryBookUpdate(BookJoinDTO bjd); //도서관 소장 도서 수정
	public int delete(String isbncode); //도서 정보 삭제
	public int libraryBookDelete(int book_list_num); //도서관 소장 도서 삭제
	public List<LoanDTO> loanList(int displayPost, int postNum); //도서 대출 리스트
	public LoanJoinDTO loanDetailList(int loan_detail_num, int library_code); //대출 상세 
	public int returnbook(int loan_detail_num);// 도서 반납
	public int librarianisbncodeCheck(String isbncode);//도서추가 isbncode 중복확인
	public List<LoanDTO> loanListSearch(String keyword, int displayPost, int postNum);//대출리스트 검색
	public int loanSearchCount(String keyword);//대출검색 수량
	public List<BookBean> bookList(int displayPost, int postNum);//도서 정보 목록
	public int bookInfoCount();//도서 정보 총수
	public List<BookBean> bookInfoSearch(String keyword, int displayPost, int postNum);//도서정보 검색
	public int bookInfoSearchCount(String keyword);//도서정보 검색 총수
	public BookBean bookupdatebefore(String isbncode);//도서정보 수정용 정보
	public int librarianListCheck(String isbncode, int library_code);//도서 목록 추가 도서 중복 확인
	public int bookListCheck(String isbncode);//도서 목록 등록 확인
	
	public int marketin(Map<String, Object> map);
}
