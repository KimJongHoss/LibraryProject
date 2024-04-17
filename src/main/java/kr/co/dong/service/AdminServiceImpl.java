package kr.co.dong.service;
//관리자 권한 기능 Service
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dong.DAO.AdminDAO;
import kr.co.dong.controller.AdminController;
import kr.co.dong.domain.LibrarianBean;
import kr.co.dong.domain.LibraryBean;

@Service
public class AdminServiceImpl implements AdminService{
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminDAO adminDao;

//	도서관 Service
	@Override
	public List<LibraryBean> librarylist() {
		// TODO Auto-generated method stub
		return adminDao.librarylist();
	}

	@Override
	public LibraryBean librarySelectOne(int library_code) {
		// TODO Auto-generated method stub
		return adminDao.librarySelectOne(library_code);
	}

	@Override
	public int libraryInsert(LibraryBean lb) {
		// TODO Auto-generated method stub
		return adminDao.libraryInsert(lb);
	}

	@Override
	public int libraryUpdate(LibraryBean lb) {
		// TODO Auto-generated method stub
		return adminDao.libraryUpdate(lb);
	}

	@Override
	public int libraryDelete(int library_code) {
		// TODO Auto-generated method stub
		return adminDao.libraryDelete(library_code);
	}

//	사서 Service
	@Override
	public List<LibrarianBean> librarianlist() {
		// TODO Auto-generated method stub
		return adminDao.librarianlist();
	}

	@Override
	public LibrarianBean librarianSelectOne(String id) {
		// TODO Auto-generated method stub
		return adminDao.librarianSelectOne(id);
	}

	@Override
	public int librarianInsert(LibrarianBean lbb) {
		// TODO Auto-generated method stub
		return adminDao.librarianInsert(lbb);
	}

	@Override
	public int librarianUpdate(LibrarianBean lbb) {
		// TODO Auto-generated method stub
		return adminDao.librarianUpdate(lbb);
	}

	@Override
	public int librarianDelete(String id) {
		// TODO Auto-generated method stub
		return adminDao.librarianDelete(id);
	}

//	 회원가입 시 아이디 체크
	@Override
	public Integer idCheck(String id) {
		// TODO Auto-generated method stub
		return adminDao.idCheck(id);
	}


}
