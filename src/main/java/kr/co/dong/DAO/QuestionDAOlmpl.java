package kr.co.dong.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dong.domain.QuestionDTO;


@Repository
public class QuestionDAOlmpl implements QuestionDAO{
	@Autowired
	private SqlSession sqlSession;
	private static final String nameSpace="kr.co.dong.boardMapper";
//	글 목록
	@Override
	public List<QuestionDTO> questionAndlist(){
		return sqlSession.selectList(nameSpace + ".questionAndlist");
	}
//	글 추가
	@Override
	public int questionAndregister(QuestionDTO questionDTO) {
		return sqlSession.insert(nameSpace+".questionAndregister", questionDTO);
	}
//	글 수정
	@Override
	public int questionAndupdateReadCnt(QuestionDTO questionDTO) {
		return sqlSession.update(nameSpace + ".questionAndupdateReadCnt",questionDTO);
	}
//  글 삭제
	@Override
	public int questionAnddelete(int question_num) {
		return sqlSession.delete(nameSpace + ".questionAnddelete", question_num);
	}
//	글 조회
//	조회수
	@Override
	public int questionAndcount(int question_num) {
		return sqlSession.update(nameSpace + ".questionAndcount", question_num);
	}
//	
	@Override
	public QuestionDTO questionAndview(int question_num) {
		return sqlSession.selectOne(nameSpace + ".questionAndview", question_num);
	}
	// 게시물 총 갯수
		@Override
		public int questioncount() {
		 return sqlSession.selectOne(nameSpace + ".questioncount"); 
		}
	// 게시물 목록 + 페이징
		@Override
		public List<QuestionDTO> questionlistPage(int displayPost, int postNum) {

		 HashMap<String, Object> data = new HashMap<String, Object>();
		  
		 data.put("displayPost", displayPost);
		 data.put("postNum", postNum);
		  
		 return sqlSession.selectList(nameSpace + ".questionlistPage", data);
		}
}
