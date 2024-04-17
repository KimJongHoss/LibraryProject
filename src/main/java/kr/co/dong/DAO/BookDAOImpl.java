package kr.co.dong.DAO;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dong.domain.BookBean;
import kr.co.dong.domain.BookJoinDTO;
import kr.co.dong.domain.BookListBean;
import kr.co.dong.domain.LoanDTO;
import kr.co.dong.domain.LoanJoinDTO;

@Repository
public class BookDAOImpl implements BookDAO{

	@Autowired
	SqlSession sqlSession;
	
	private final static String namespaces = "kr.co.dong.bookMapper";
	
//	보유한 도서 총수
	@Override
	public int count() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(namespaces + ".count");
	}

//	도서 정보보기
	@Override
	public List<BookJoinDTO> allList(int displayPost, int postNum) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> all = new HashMap<String, Object>();

		all.put("displayPost", displayPost);
		all.put("postNum", postNum);
	
		return sqlSession.selectList(namespaces + ".allList", all);
	}
	
//	도서 상세보기
	@Override
	public BookJoinDTO detail(String isbncode, int library_code) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> book = new HashMap<String, Object>();
		
		book.put("isbncode", isbncode);
		book.put("library_code", library_code);
		
		return sqlSession.selectOne(namespaces + ".detail", book);
	}

//	도서 검색
	@Override
	public List<BookJoinDTO> search(String keyword, int displayPost, int postNum) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> search = new HashMap<String, Object>();
		
		search.put("keyword", keyword);
		search.put("displayPost", displayPost);
		search.put("postNum", postNum);
		
		return sqlSession.selectList(namespaces + ".search", search);
	}
	
//	도서 검색 총수
	@Override
	public int bookSearchCount(String keyword) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(namespaces + ".bookSearchCount", keyword);
	}

//	도서 대출 총 수
	@Override
	public int loanCount() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(namespaces + ".loanCount");
	}

//	도서 대출(상세)등록
	@Override
	public int loan_Detail(LoanJoinDTO ljd) {
		// TODO Auto-generated method stub
		
		return sqlSession.insert(namespaces + ".loan_Detail", ljd);
	}

//	도서 대출(목록)등록
	@Override
	public int loan(LoanJoinDTO ljd) {
		// TODO Auto-generated method stub
		
		return sqlSession.insert(namespaces + ".loan", ljd);
	}
	
//	도서 대출/반납증
	@Override
	public LoanJoinDTO loanReturnCert(int loan_detail_num) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(namespaces + ".loanReturnCert", loan_detail_num);
	}

//	도서 대출 개수 수정
	@Override
	public int bookListStatusUpdate(int loan_status, int book_list_num) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> update = new HashMap<String, Object>();
		
		update.put("loan_status", loan_status);
		update.put("book_list_num", book_list_num);
		
		return sqlSession.update(namespaces + ".bookListStatusUpdate", update);
	}

//	도서 정보
	@Override
	public BookJoinDTO bookDetail(String isbncode) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("kr.co.dong.adminmapper.bookDetail", isbncode);
	}
	
//	도서 정보 추가
	@Override
	public int insert(BookBean bjd) {
		// TODO Auto-generated method stub
		
		return sqlSession.insert("kr.co.dong.adminmapper.insert", bjd);
	}

//	도서관 소장 도서 추가
	@Override
	public int libraryBookInsert(BookJoinDTO bjd) {
		// TODO Auto-generated method stub
		
		return sqlSession.insert("kr.co.dong.adminmapper.libraryBookInsert", bjd);
	}

//	도서 정보 수정
	@Override
	public int update(BookJoinDTO bjd) {
		// TODO Auto-generated method stub
		
		return sqlSession.update("kr.co.dong.adminmapper.update", bjd);
	}
	
//	도서관 소장 도서 수정
	@Override
	public int libraryBookUpdate(BookJoinDTO bjd) {
		// TODO Auto-generated method stub
		
		return sqlSession.update("kr.co.dong.adminmapper.libraryBookUpdate", bjd);
	}

//	도서 정보 삭제
	@Override
	public int delete(String isbncode) {
		// TODO Auto-generated method stub
		
		return sqlSession.delete("kr.co.dong.adminmapper.delete", isbncode);
	}

//	도서관 소장 도서 삭제
	@Override
	public int libraryBookDelete(int book_list_num) {
		// TODO Auto-generated method stub
		
		return sqlSession.delete("kr.co.dong.adminmapper.libraryBookDelete", book_list_num);
	}
	
//	도서 대출 리스트
	@Override
	public List<LoanDTO> loanList(int displayPost, int postNum) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> loanlist = new HashMap<String, Object>();
		
		loanlist.put("displayPost", displayPost);
		loanlist.put("postNum", postNum);
		
		return sqlSession.selectList("kr.co.dong.adminmapper.loanList", loanlist);
	}

//	대출 상세
	@Override
	public LoanJoinDTO loanDetailList(int loan_detail_num, int library_code) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> list = new HashMap<String, Object>();
		
		list.put("loan_detail_num", loan_detail_num);
		list.put("library_code", library_code);
		
		return sqlSession.selectOne("kr.co.dong.adminmapper.loanDetailList", list);
	}
	
//  도서 반납
	@Override
	public int returnbook(int loan_detail_num) {
		// TODO Auto-generated method stub	
		
		return sqlSession.update("kr.co.dong.adminmapper.returnbook", loan_detail_num);
	}

//	도서 추가 isbncode 중복확인
	@Override
	public int librarianisbncodeCheck(String isbncode) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("kr.co.dong.adminmapper.librarianisbncodeCheck", isbncode);
	}

//	대출리스트 검색
	@Override
	public List<LoanDTO> loanListSearch(String keyword, int displayPost, int postNum) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> loanSearch = new HashMap<String, Object>();
		
		loanSearch.put("keyword", keyword);
		loanSearch.put("displayPost", displayPost);
		loanSearch.put("postNum", postNum);
		
		return sqlSession.selectList("kr.co.dong.adminmapper.loanListSearch", loanSearch);
	}

//	도서검색 수량
	@Override
	public int loanSearchCount(String keyword) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("kr.co.dong.adminmapper.loanSearchCount", keyword);
	}

//	도서 정보 목록
	@Override
	public List<BookBean> bookList(int displayPost, int postNum) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> booklist = new HashMap<String, Object>();
		
		booklist.put("displayPost", displayPost);
		booklist.put("postNum", postNum);

		return sqlSession.selectList("kr.co.dong.adminmapper.bookList", booklist);
	}

//	도서 정보 총수
	@Override
	public int bookInfoCount() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("kr.co.dong.adminmapper.bookInfoCount");
	}

//	도서정보 검색
	@Override
	public List<BookBean> bookInfoSearch(String keyword, int displayPost, int postNum) {
		// TODO Auto-generated method stub

		HashMap<String, Object> infoSearch = new HashMap<String, Object>();
		
		infoSearch.put("keyword", keyword);
		infoSearch.put("displayPost", displayPost);
		infoSearch.put("postNum", postNum);
		
		return sqlSession.selectList("kr.co.dong.adminmapper.bookInfoSearch", infoSearch);
	}

//	도서정보 검색 총수
	@Override
	public int bookInfoSearchCount(String keyword) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("kr.co.dong.adminmapper.bookInfoSearchCount", keyword);
	}

//	도서정보 수정용 정보
	@Override
	public BookBean bookupdatebefore(String isbncode) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("kr.co.dong.adminmapper.bookupdatebefore", isbncode);
	}

//	도서 목록 추가 도서 중복확인
	@Override
	public int librarianListCheck(String isbncode, int library_code) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> listcheck = new HashMap<String, Object>();
		
		listcheck.put("isbncode", isbncode);
		listcheck.put("library_code", library_code);
		
		return sqlSession.selectOne("kr.co.dong.adminmapper.librarianListCheck", listcheck);
	}

//	도서 목록 등록 확인
	@Override
	public int bookListCheck(String isbncode) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("kr.co.dong.adminmapper.bookListCheck", isbncode);
	}


//	 marketin(Map<String, Object> map)
	@Override
	public int marketin(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespaces + ".marketin", map);
	}

	@Override
	public int bookSelect(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespaces + ".bookselect", map);
	}

	@Override
	public int marketSelect(Map<String, Object> map) {
		return sqlSession.selectOne(namespaces + ".marketselect", map);
	}







	


	
	

}
