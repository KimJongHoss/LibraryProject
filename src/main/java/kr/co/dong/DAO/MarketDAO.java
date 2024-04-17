package kr.co.dong.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.dong.domain.MarketListDTO;

public interface MarketDAO {
	
	// 책 리스트
	List<MarketListDTO> list(String userid);
	
	// 장바구니 목록 삭제
	int delete(List<Object> idList);
	
	// 도서 대출 기능
	int loanadd(List<String> bookList);
	
	// 사용할 수 있는 도서 확인
	int available(List<String> bookList);
	
	// 대출 목록 카운트
	int count();
	
	// 대출 상세 삽입
	int marketdetail(int loanCount, String userid, String isbncode);
	
	// 대출 목록 삽입
	int marketloan(int loanCount, String userid, String isbncode);
}
