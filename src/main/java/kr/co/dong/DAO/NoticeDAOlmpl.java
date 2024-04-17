package kr.co.dong.DAO;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dong.domain.NoticeDTO;


@Repository
public class NoticeDAOlmpl implements NoticeDAO{
	@Autowired
	private SqlSession sqlSession;
	private static final String nameSpace="kr.co.dong.boardMapper";
	
//	글 목록
	@Override
	public List<NoticeDTO> noticeAndlist(){
		return sqlSession.selectList(nameSpace + ".noticeAndlist");
	}

//	조회수
	@Override
	public int noticeAndcount(int bno) {
		return sqlSession.update(nameSpace + ".noticeAndcount", bno);
	}
//	글 조회	
	@Override
	public NoticeDTO noticeAndview(int bno) {
		return sqlSession.selectOne(nameSpace + ".noticeAndview", bno);
	}
	// 게시물 총 갯수
		@Override
		public int noticecount() {
		 return sqlSession.selectOne(nameSpace + ".noticecount"); 
		}
		// 게시물 목록 + 페이징
		@Override
		public List<NoticeDTO> noticelistPage(int displayPost, int postNum) {

		 HashMap<String, Object> data = new HashMap<String, Object>();
		  
		 data.put("displayPost", displayPost);
		 data.put("postNum", postNum);
		  
		 return sqlSession.selectList(nameSpace + ".noticelistPage", data);
		}
}
