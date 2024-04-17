package kr.co.dong.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dong.DAO.QuestionDAO;
import kr.co.dong.domain.QuestionDTO;


@Service
public class QuestionServiceImpl implements QuestionService {
	@Inject
	private QuestionDAO questionDAO;
	
	@Override
	public List<QuestionDTO> questionAndlist() {
		return questionDAO.questionAndlist();
	}
//조회수
	@Override
	public int questionAndcount(int question_num) {
		return questionDAO.questionAndcount(question_num);
	}
//상세 
	public QuestionDTO questionAndview(int question_num) {
		return questionDAO.questionAndview(question_num);
	}
//	삭제 
	@Override
	public int questionAnddelete(int question_num) {
		return questionDAO.questionAnddelete(question_num);
	}
//	쓰기 
	@Override
	public int questionAndregister(QuestionDTO questionDTO) {
		return questionDAO.questionAndregister(questionDTO);
	}
//	수정
	@Override
	public int questionAndupdateReadCnt(QuestionDTO questionDTO) {
		return questionDAO.questionAndupdateReadCnt(questionDTO);
	}	
	// 게시물 총 갯수
		@Override
		public int questioncount() {
		 return questionDAO.questioncount();
		}
		// 게시물 목록 + 페이징
		@Override
		public List<QuestionDTO> questionlistPage(int displayPost, int postNum) {
		 return questionDAO.questionlistPage(displayPost, postNum);
		}
}
