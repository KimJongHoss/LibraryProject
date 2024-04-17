package kr.co.dong.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dong.domain.CommentDTO;
import kr.co.dong.domain.FreeDTO;


@Repository
public class FreeDAOlmpl implements FreeDAO{
	@Autowired
	private SqlSession sqlSession;
	private static final String nameSpace="kr.co.dong.boardMapper";
//	글 목록
	@Override
	public List<FreeDTO> freeAndlist(){
		return sqlSession.selectList(nameSpace + ".freeAndlist");
	}
//	글 추가
	@Override
	public int freeAndregister(FreeDTO freeDTO) {
		return sqlSession.insert(nameSpace+".freeAndregister", freeDTO);
	}
//	글 수정
	@Override
	public int freeAndupdateReadCnt(FreeDTO freeDTO) {
		return sqlSession.update(nameSpace + ".freeAndupdateReadCnt",freeDTO);
	}
//  글 삭제
	@Override
	public int freeAnddelete(int bno) {
		return sqlSession.delete(nameSpace + ".freeAnddelete", bno);
	}
//	글 조회
//	조회수
	@Override
	public int freeAndcount(int bno) {
		return sqlSession.update(nameSpace + ".freeAndcount", bno);
	}
//	상세 
	@Override
	public FreeDTO freeAndview(int bno) {
		return sqlSession.selectOne(nameSpace + ".freeAndview", bno);
}
//	댓글리스트 
	@Override
	public List<CommentDTO> Detail1(int free_board_num) {
		return sqlSession.selectList(nameSpace + ".detail1", free_board_num);
	}
//	댓글쓰기 
	@Override
	public int reply(CommentDTO commentDTO) {
		return sqlSession.insert(nameSpace + ".reply", commentDTO);
	}
//	댓글수정 
	@Override
	public int replyupdate(CommentDTO commentDTO) {
		return sqlSession.update(nameSpace + ".replyupdate",commentDTO);
	}
//	댓글삭제 
	@Override
	public int replyDelete(int commentDTO) {
		return sqlSession.delete(nameSpace + ".replyDelete", commentDTO);
	}
//	게시글 + 댓글삭제 
	@Override
	public int Delete(int bno) {
		return sqlSession.delete(nameSpace + ".Delete", bno);
	}
	// 게시물 총 갯수
	@Override
	public int freecount() {
	 return sqlSession.selectOne(nameSpace + ".freecount"); 
	}
	// 게시물 목록 + 페이징
	@Override
	public List<FreeDTO> freelistPage(int displayPost, int postNum) {

	 HashMap<String, Object> data = new HashMap<String, Object>();
	  
	 data.put("displayPost", displayPost);
	 data.put("postNum", postNum);
	  
	 return sqlSession.selectList(nameSpace + ".freelistPage", data);
	}
	


}