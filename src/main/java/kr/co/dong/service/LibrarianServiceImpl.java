package kr.co.dong.service;
//사서 권한 기능 Service
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dong.DAO.LibrarianDAO;
import kr.co.dong.domain.AnswerBean;
import kr.co.dong.domain.BookBean;
import kr.co.dong.domain.DeliveryBean;
import kr.co.dong.domain.InterBean;
import kr.co.dong.domain.NoticeDTO;
import kr.co.dong.domain.QuestionDTO;
import kr.co.dong.domain.saveBlacklistBean;
import kr.co.dong.domain.saveOverdueBean;
import kr.co.dong.domain.toRegularBean;

@Service
public class LibrarianServiceImpl implements LibrarianService{
	@Autowired
	LibrarianDAO librarianDao;

	@Override
	public List<BookBean> Booklist() {
		// TODO Auto-generated method stub
		return librarianDao.booklist();
	}

	@Override
	public BookBean bookSelectOne(String isbncode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int bookInsert(BookBean bb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bookUpdate(BookBean bb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bookDelete(String isbncode) {
		// TODO Auto-generated method stub
		return 0;
	}

//	정회원 전환 신청
	@Override
	public List<toRegularBean> toRegularlist() {
		// TODO Auto-generated method stub
		return librarianDao.toRegularlist();
	}

	@Override
	public toRegularBean toRegularSelectOne(int apply_code) {
		// TODO Auto-generated method stub
		return librarianDao.toRegularSelectOne(apply_code);
	}

	@Override
	public int toRegularOk(toRegularBean tb) {
		// TODO Auto-generated method stub
		return librarianDao.toRegularOk(tb);
	}

	@Override
	public int toRegularLevelUp(String userid) {
		// TODO Auto-generated method stub
		return librarianDao.toRegularLevelUp(userid);
	}
	
	@Override
	public int toRegularNo(toRegularBean tb) {
		// TODO Auto-generated method stub
		return librarianDao.toRegularNo(tb);
	}

//	연체구제신청 Service
	@Override
	public List<saveOverdueBean> saveOverduelist() {
		// TODO Auto-generated method stub
		return librarianDao.saveOverduelist();
	}

	@Override
	public saveOverdueBean saveOverdueSelectOne(int save_code) {
		// TODO Auto-generated method stub
		return librarianDao.saveOverdueSelectOne(save_code);
	}

	@Override
	public int saveOverdueOk(saveOverdueBean sob) {
		// TODO Auto-generated method stub
		return librarianDao.saveOverdueOk(sob);
	}

	@Override
	public int saveOverdueLevelUp(String userid) {
		// TODO Auto-generated method stub
		return librarianDao.saveOverdueLevelUp(userid);
	}

	@Override
	public int howManyOverdue(String userid) {
		// TODO Auto-generated method stub
		return librarianDao.howManyOverdue(userid);
	}

	@Override
	public int saveOverdueNo(saveOverdueBean sob) {
		// TODO Auto-generated method stub
		return librarianDao.saveOverdueNo(sob);
	}

	@Override
	public List<saveBlacklistBean> saveBlacklistlist() {
		// TODO Auto-generated method stub
		return librarianDao.saveBlacklistlist();
	}

	@Override
	public saveBlacklistBean saveBlacklistSelectOne(int save_code) {
		// TODO Auto-generated method stub
		return librarianDao.saveBlacklistSelectOne(save_code);
	}

	@Override
	public int saveBlacklistOk(saveBlacklistBean sbb) {
		// TODO Auto-generated method stub
		return librarianDao.saveBlacklistOk(sbb);
	}

	@Override
	public int saveBlacklistLevelUp(String userid) {
		// TODO Auto-generated method stub
		return librarianDao.saveBlacklistLevelUp(userid);
	}

	@Override
	public int saveBlacklistNo(saveBlacklistBean sbb) {
		// TODO Auto-generated method stub
		return librarianDao.saveBlacklistNo(sbb);
	}

	@Override
	public List<QuestionDTO> answerListAll() {
		// TODO Auto-generated method stub
		return librarianDao.answerListAll();
	}
	
	@Override
	public AnswerBean answerListOne(int question_num) {
		// TODO Auto-generated method stub
		return librarianDao.answerListOne(question_num);
	}
	
	@Override
	public int answerClear(int question_num_int) {
		// TODO Auto-generated method stub
		String question_num = String.valueOf(question_num_int);
		return librarianDao.answerClear(question_num);
	}
	
	@Override
	public int answerInsert(AnswerBean ab) {
		// TODO Auto-generated method stub
		return librarianDao.answerInsert(ab);
	}

	@Override
	public int noticeAdd(NoticeDTO nd) {
		// TODO Auto-generated method stub
		return librarianDao.noticeAdd(nd);
	}

	@Override
	public int noticeUpdate(NoticeDTO nd) {
		// TODO Auto-generated method stub
		return librarianDao.noticeUpdate(nd);
	}

	@Override
	public int noticeDelete(int notice_num) {
		// TODO Auto-generated method stub
		return librarianDao.noticeDelete(notice_num);
	}

	@Override
	public List<InterBean> interliblist() {
		// TODO Auto-generated method stub
		return librarianDao.interliblist();
	}

	@Override
	public InterBean interlibSelectOne(int interid) {
		// TODO Auto-generated method stub
		return librarianDao.interlibSelectOne(interid);
	}

	@Override
	public int interlibOk(InterBean ib) {
		// TODO Auto-generated method stub
		return librarianDao.interlibOk(ib);
	}

	@Override
	public int interlibNo(InterBean ib) {
		// TODO Auto-generated method stub
		return librarianDao.interlibNo(ib);
	}

	@Override
	public List<DeliveryBean> deliverylist() {
		// TODO Auto-generated method stub
		return librarianDao.deliverylist();
	}

	@Override
	public DeliveryBean deliverySelectOne(int deliveryid) {
		// TODO Auto-generated method stub
		return librarianDao.deliverySelectOne(deliveryid);
	}

	@Override
	public int deliveryOk(DeliveryBean db) {
		// TODO Auto-generated method stub
		return librarianDao.deliveryOk(db);
	}

	@Override
	public int deliveryNo(DeliveryBean db) {
		// TODO Auto-generated method stub
		return librarianDao.deliveryNo(db);
	}

	


}
