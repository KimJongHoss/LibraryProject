package kr.co.dong.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dong.DAO.MarketDAO;
import kr.co.dong.domain.MarketListDTO;

@Service
public class MarketServiceImpl implements MarketService {

	@Inject
	private MarketDAO marketDAO;

	@Override
	public List<MarketListDTO> list(String userid) {
		return marketDAO.list(userid);
	}

	@Override
	public int delete(List<Object> idList) {
		return marketDAO.delete(idList);
	}

	@Override
	public int loanadd(List<Object> idList, List<String> bookList, int cnt, String userid, List<Integer> loanCountList) {
		System.out.println(bookList);
		System.out.println(idList);
		int available = marketDAO.available(bookList);
		//marketDAO.marketdetail(bookList, loanCount, useridList);
		if (available == cnt) {
			for(int i = 0; i < cnt; i++ ) {
				int loanCount = loanCountList.get(i);
				String isbncode = bookList.get(i);
				marketDAO.marketdetail(loanCount, userid, isbncode);
				marketDAO.marketloan(loanCount, userid, isbncode);
			}
			marketDAO.delete(idList);
			return marketDAO.loanadd(bookList);
		}
		return 0;
	}

	@Override
	public int count() {
		return marketDAO.count();
	}

}
