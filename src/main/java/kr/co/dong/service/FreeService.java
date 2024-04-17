package kr.co.dong.service;

import java.util.List;

import kr.co.dong.domain.CommentDTO;
import kr.co.dong.domain.FreeDTO;


public interface FreeService {
	// 전체목록을 가져오는 메소드
	public List<FreeDTO> freeAndlist();
	// 상세보기 처리를 위한 메소드(글읽기)
		public int freeAndcount(int free_board_num);  //조회수 증가
		public FreeDTO freeAndview(int free_board_num);  //getRead(), getView()
		// 글추가 insert
		public int freeAndregister(FreeDTO freeDTO);
		// 글수정
		public int freeAndupdateReadCnt(FreeDTO freeDTO);
		// 글삭제
		public int freeAnddelete(int bno);
		
		// 해당 글에 대한 댓글 조회(댓글리스트)
		public List<CommentDTO> Detail1(int free_board_num);

		// 댓글 쓰기
		public int reply(CommentDTO commentDTO);

		// 댓글 수정
		public int replyupdate(CommentDTO commentDTO);
		
		// 댓글 삭제
		public int replyDelete(int commentDTO);

		public int Delete(int bno);
		// 게시물 총 갯수
		public int freecount();
		// 게시물 목록 + 페이징
		public List<FreeDTO> freelistPage(int displayPost, int postNum);
		
		}
		
		

