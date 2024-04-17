//	사서 권한 기능 DAO
package kr.co.dong.DAO;

import java.util.List;

import kr.co.dong.domain.AnswerBean;
import kr.co.dong.domain.BookBean;
import kr.co.dong.domain.DeliveryBean;
import kr.co.dong.domain.InterBean;
import kr.co.dong.domain.LibraryBean;
import kr.co.dong.domain.NoticeDTO;
import kr.co.dong.domain.QuestionDTO;
import kr.co.dong.domain.saveBlacklistBean;
import kr.co.dong.domain.saveOverdueBean;
import kr.co.dong.domain.toRegularBean;


public interface LibrarianDAO {
//	도서 관리
	public List<BookBean> booklist();
	public BookBean bookSelectOne(String isbncode);
	public int bookInsert(BookBean bb);
	public int bookUpdate(BookBean bb);
	public int bookDelete(String isbncode);
	
//	정회원 전환 신청
	public List<toRegularBean> toRegularlist();
	public toRegularBean toRegularSelectOne(int apply_code);
	public int toRegularOk(toRegularBean tb);
	public int toRegularLevelUp(String userid);
	public int toRegularNo(toRegularBean tb);
	
//	연체 구제 신청
	public List<saveOverdueBean> saveOverduelist();
	public saveOverdueBean saveOverdueSelectOne(int save_code);
	public int saveOverdueOk(saveOverdueBean sob);
	public int saveOverdueLevelUp(String userid);
	public int howManyOverdue(String userid);
	public int saveOverdueNo(saveOverdueBean sob);
	
//	블랙리스트 구제 신청
	public List<saveBlacklistBean> saveBlacklistlist();
	public saveBlacklistBean saveBlacklistSelectOne(int save_code);
	public int saveBlacklistOk(saveBlacklistBean sbb);
	public int saveBlacklistLevelUp(String userid);
	public int saveBlacklistNo(saveBlacklistBean sbb);
	
//	Q&A 답변하기
	public List<QuestionDTO> answerListAll();
	public int answerClear(String question_num);
	public int answerInsert(AnswerBean ab);
	public AnswerBean answerListOne(int question_num);
	
//	공지사항 관리
	public int noticeAdd(NoticeDTO nd);
	public int noticeUpdate(NoticeDTO nd);
	public int noticeDelete(int notice_num);
	
//	상호대차 관리
	public List<InterBean> interliblist();
	public InterBean interlibSelectOne(int interid);
	public int interlibOk(InterBean ib);
	public int interlibNo(InterBean ib);
	
//	배송 관리
	public List<DeliveryBean> deliverylist();
	public DeliveryBean deliverySelectOne(int deliveryid);
	public int deliveryOk(DeliveryBean db);
	public int deliveryNo(DeliveryBean db);
}

