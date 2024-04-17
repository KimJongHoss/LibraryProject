package kr.co.dong.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dong.DAO.FreeDAO;
import kr.co.dong.domain.CommentDTO;
import kr.co.dong.domain.FreeDTO;


@Service
public class FreeServiceImpl implements FreeService {
	@Inject
	private FreeDAO FreeDAO;
	
	@Override
	public List<FreeDTO> freeAndlist() {
		return FreeDAO.freeAndlist();
	}
//조회수
	@Override
	public int freeAndcount(int free_board_num) {
		return FreeDAO.freeAndcount(free_board_num);
	}
//상세 
	public FreeDTO freeAndview(int free_board_num) {
		return FreeDAO.freeAndview(free_board_num);
	}
//	삭제 
	@Override
	public int freeAnddelete(int bno) {
		return FreeDAO.freeAnddelete(bno);
	}
//	쓰기 
	@Override
	public int freeAndregister(FreeDTO freeDTO) {
		return FreeDAO.freeAndregister(freeDTO);
	}
//	수정
	@Override
	public int freeAndupdateReadCnt(FreeDTO freeDTO) {
		return FreeDAO.freeAndupdateReadCnt(freeDTO);
	}
//	댓글리스트 
	@Override
	public List<CommentDTO> Detail1(int free_board_num) {
		return FreeDAO.Detail1(free_board_num);
	}
//	댓글쓰기 
	@Override
	public int reply(CommentDTO commentDTO) {
		return FreeDAO.reply(commentDTO);
	}
//	댓글수정 
	@Override
	public int replyupdate(CommentDTO commentDTO) {
		return FreeDAO.replyupdate(commentDTO);
	}
//	댓글삭제 
	@Override
	public int replyDelete(int commentDTO) {
		return FreeDAO.replyDelete(commentDTO);
	}	
//	게시글+댓글 삭제 
	public int Delete(int bno) {
		return FreeDAO.Delete(bno);
	}
	// 게시물 총 갯수
	@Override
	public int freecount() {
	 return FreeDAO.freecount();
	}
	// 게시물 목록 + 페이징
	@Override
	public List<FreeDTO> freelistPage(int displayPost, int postNum) {
	 return FreeDAO.freelistPage(displayPost, postNum);
	}
}
