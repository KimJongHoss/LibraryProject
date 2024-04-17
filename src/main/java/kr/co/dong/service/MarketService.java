package kr.co.dong.service;

import java.util.List;
import java.util.Map;

import kr.co.dong.domain.MarketListDTO;

public interface MarketService {

	// 책 리스트
	List<MarketListDTO> list(String userid);

	// 장바구니 목록 삭제
	int delete(List<Object> list);

	// 도서 대출 기능
	int loanadd(List<Object> bookList, List<String> idList, int cnt, String userid, List<Integer> loanCountList);
	
	// 대출 목록 카운트
	int count();
}
