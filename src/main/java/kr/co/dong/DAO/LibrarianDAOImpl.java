//	사서 권한 기능 DAO
package kr.co.dong.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

@Repository
public class LibrarianDAOImpl implements LibrarianDAO{

	@Autowired
	SqlSession sqlSession;
	
	private final static String namespaces = "kr.co.dong.librarianmapper.";
	
//	도서 관리
	@Override
	public List<BookBean> booklist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespaces+"booklist");
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
		return sqlSession.selectList(namespaces+"toRegularlist");
	}
	
	@Override
	public toRegularBean toRegularSelectOne(int apply_code) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespaces+"toRegularSelectOne", apply_code);
	}

	@Override
	public int toRegularOk(toRegularBean tb) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"toRegularOk", tb);
	}
	
	@Override
	public int toRegularLevelUp(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"toRegularLevelUp",userid);
	}

	@Override
	public int toRegularNo(toRegularBean tb) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"toRegularNo", tb);
	}

//	연체 구제 신청
	@Override
	public List<saveOverdueBean> saveOverduelist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespaces+"saveOverduelist");
	}

	@Override
	public saveOverdueBean saveOverdueSelectOne(int save_code) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespaces+"saveOverdueSelectOne", save_code);
	}

	@Override
	public int saveOverdueOk(saveOverdueBean sob) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"saveOverdueOk", sob);
	}

	@Override
	public int saveOverdueLevelUp(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"saveOverdueLevelUp",userid);
	}

	@Override
	public int howManyOverdue(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"howManyOverdue",userid);
	}

	@Override
	public int saveOverdueNo(saveOverdueBean sob) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"saveOverdueNo", sob);
	}

//	블랙리스트 구제 신청
	@Override
	public List<saveBlacklistBean> saveBlacklistlist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespaces+"saveBlacklistlist");
	}

	@Override
	public saveBlacklistBean saveBlacklistSelectOne(int save_code) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespaces+"saveBlacklistSelectOne", save_code);
	}

	@Override
	public int saveBlacklistOk(saveBlacklistBean sbb) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"saveBlacklistOk", sbb);
	}

	@Override
	public int saveBlacklistLevelUp(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"saveBlacklistLevelUp",userid);
	}

	@Override
	public int saveBlacklistNo(saveBlacklistBean sbb) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"saveBlacklistNo", sbb);
	}

	@Override
	public List<QuestionDTO> answerListAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespaces+"answerListAll");
	}
	
	@Override
	public int answerInsert(AnswerBean ab) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespaces+"answerInsert",ab);
	}

	@Override
	public int answerClear(String question_num) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"answerClear", question_num);
	}
	
	@Override
	public AnswerBean answerListOne(int question_num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespaces+"answerListOne",question_num);
	}

	@Override
	public int noticeAdd(NoticeDTO nd) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespaces+"noticeAdd",nd);
	}

	@Override
	public int noticeUpdate(NoticeDTO nd) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"noticeUpdate",nd);
	}

	@Override
	public int noticeDelete(int notice_num) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespaces+"noticeDelete",notice_num);
	}

	@Override
	public List<InterBean> interliblist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespaces+"interlibListAll");
	}

	@Override
	public InterBean interlibSelectOne(int interid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespaces+"interlibListOne", interid);
	}

	@Override
	public int interlibOk(InterBean ib) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"interlibOk",ib);
	}

	@Override
	public int interlibNo(InterBean ib) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"interlibNo",ib);
	}

	@Override
	public List<DeliveryBean> deliverylist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespaces+"deliverylist");
	}

	@Override
	public DeliveryBean deliverySelectOne(int deliveryid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespaces+"deliverySelectOne", deliveryid);
	}

	@Override
	public int deliveryOk(DeliveryBean db) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"deliveryOk", db);
	}

	@Override
	public int deliveryNo(DeliveryBean db) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"deliveryNo", db);
	}

	

	
}
