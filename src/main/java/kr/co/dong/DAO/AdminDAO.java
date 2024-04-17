//	관리자 권한 기능 DAO
package kr.co.dong.DAO;

import java.util.List;

import kr.co.dong.domain.LibrarianBean;
import kr.co.dong.domain.LibraryBean;


public interface AdminDAO {

//	도서관 관리
	public List<LibraryBean> librarylist();
	public LibraryBean librarySelectOne(int library_code);
	public int libraryInsert(LibraryBean lb);
	public int libraryUpdate(LibraryBean lb);
	public int libraryDelete(int library_code);
	
//	사서 관리
	public List<LibrarianBean> librarianlist();
	public LibrarianBean librarianSelectOne(String id);
	public int librarianInsert(LibrarianBean lbb);
	public int librarianUpdate(LibrarianBean lbb);
	public int librarianDelete(String id);
	// 사서 추가 시 아이디 체크
	public Integer idCheck(String id);
}