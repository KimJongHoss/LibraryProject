//	관리자 권한 기능 DAO
package kr.co.dong.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dong.controller.AdminController;
import kr.co.dong.domain.LibrarianBean;
import kr.co.dong.domain.LibraryBean;

@Repository
public class AdminDAOImpl implements AdminDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	SqlSession sqlSession;
	
	private final static String namespaces = "kr.co.dong.adminmapper.";
	
//	도서관 DAO
	@Override
	public List<LibraryBean> librarylist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespaces+"librarylist");
	}

	@Override
	public LibraryBean librarySelectOne(int library_code) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespaces+"librarySelectOne", library_code);
	}

	@Override
	public int libraryInsert(LibraryBean lb) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespaces+"libraryInsert", lb);
	}

	@Override
	public int libraryUpdate(LibraryBean lb) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"libraryUpdate", lb);
	}

	@Override
	public int libraryDelete(int library_code) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespaces+"libraryDelete", library_code);
		
	}

//	사서 DAO
	@Override
	public List<LibrarianBean> librarianlist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespaces+"librarianlist");
	}

	@Override
	public LibrarianBean librarianSelectOne(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespaces+"librarianSelectOne", id);
	}

	@Override
	public int librarianInsert(LibrarianBean lbb) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespaces+"librarianInsert", lbb);
	}

	@Override
	public int librarianUpdate(LibrarianBean lbb) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespaces+"librarianUpdate", lbb);
	}

	@Override
	public int librarianDelete(String id) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespaces + "librarianDelete", id);
	}

//	사서 추가 시 아이디 체크
	@Override
	public Integer idCheck(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespaces + "idCheck", id);
	}


}
