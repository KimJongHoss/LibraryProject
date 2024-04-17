package kr.co.dong.service;

import kr.co.dong.domain.LibrarianBean;
import kr.co.dong.domain.UserDTO;

public interface UserService {
	// 로그인
	UserDTO login(UserDTO userDTO);

	// 회원가입
	int member(UserDTO userDTO);

	// 회원가입 시 아이디 체크
	Integer idCheck(String userid);

	// 회원 정보 수정
	int update(UserDTO userDTO);

	//회원 탈퇴
	int delete(String userid);

	// 아이디 찾기
	String findId(UserDTO userDTO);

	// 비밀번호 찾기
	String findPassword(UserDTO userDTO);
	
	//crypt
	String crypt(String userid);
	
	// 비밀번호 변경
	int updatePassword(UserDTO userDTO);
	
	// 회원 리스트
	UserDTO infolist(String userid);
	
	// 내 정보 인증
	int auth(String userid);

	//사서 로그인
	LibrarianBean loginmanager(LibrarianBean librarianbean);

}
