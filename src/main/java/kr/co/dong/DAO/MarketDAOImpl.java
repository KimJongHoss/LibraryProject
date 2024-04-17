package kr.co.dong.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dong.domain.MarketListDTO;

@Repository
public class MarketDAOImpl implements MarketDAO{
	
	private final String namespaces = "kr.co.dong.mapper.market"; 

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<MarketListDTO> list(String userid) {
		return sqlSession.selectList(namespaces + ".list", userid);
	}

	@Override
	public int delete(List<Object> list) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", list);
		return sqlSession.delete(namespaces + ".delete", map);
	}

	@Override
	public int loanadd(List<String> bookList) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("loan", bookList);
		
		return sqlSession.update(namespaces + ".loanadd", map);
		
	}

	@Override
	public int available(List<String> bookList) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("isbncode", bookList);
		
		return sqlSession.selectOne(namespaces + ".available", map);
	}
	
	@Override
	public int count() {
		return sqlSession.selectOne(namespaces + ".count");
	}

	@Override
	public int marketdetail(int loanCount, String userid, String isbncode) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("isbncode", isbncode);
		map.put("loan_detail_num", loanCount);
		map.put("userid", userid);
		
		return sqlSession.insert(namespaces + ".marketdetail", map);
	}

	@Override
	public int marketloan(int loanCount, String userid, String isbncode) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("isbncode", isbncode);
		map.put("loan_detail_num", loanCount);
		map.put("userid", userid);
		
		return sqlSession.insert(namespaces + ".marketloan", map);
	}



	

}
