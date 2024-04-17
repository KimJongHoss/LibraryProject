package kr.co.dong.DAO;

import java.util.List;

import kr.co.dong.domain.QuestionDTO;


public interface QuestionDAO {
	//전체목록을 가져오는 메소드
	public List<QuestionDTO> questionAndlist();
	
	// 글추가 insert
	public int questionAndregister(QuestionDTO questionDTO);
	
	// 상세보기 처리를 위한 메소드(글읽기)
	public int questionAndcount(int question_num);  //조회수 증가
	public QuestionDTO questionAndview(int question_num);  //getRead(), getView()
	
	// 글수정
	public int questionAndupdateReadCnt(QuestionDTO questionDTO);
	
	// 글삭제
	public int questionAnddelete(int question_num);
	// 게시물 총 갯수
	public int questioncount();
	// 게시물 목록 + 페이징
	public List<QuestionDTO> questionlistPage(int displayPost, int postNum);
	
}
