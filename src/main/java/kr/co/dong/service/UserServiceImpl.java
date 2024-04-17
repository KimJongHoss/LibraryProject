package kr.co.dong.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dong.DAO.UserDAO;
import kr.co.dong.domain.LibrarianBean;
import kr.co.dong.domain.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO userDAO;

	@Override
	public UserDTO login(UserDTO userDTO) {
		return userDAO.login(userDTO);
	}

	@Override
	public int member(UserDTO userDTO) {
		return userDAO.member(userDTO);
	}

	@Override
	public Integer idCheck(String userid) {
		return userDAO.idCheck(userid);
	}

	@Override
	public int update(UserDTO userDTO) {
		return userDAO.update(userDTO);
	}

	@Override
	public int delete(String userid) {
		return userDAO.delete(userid);
	}

	@Override
	public String findId(UserDTO userDTO) {
		return userDAO.findId(userDTO);
	}

	@Override
	public String findPassword(UserDTO userDTO) {
		return userDAO.findPassword(userDTO);
	}

	@Override
	public String crypt(String userid) {
		return userDAO.crypt(userid);
	}

	@Override
	public int updatePassword(UserDTO userDTO) {
		return userDAO.updatePassword(userDTO);
	}

	@Override
	public UserDTO infolist(String userid) {
		return userDAO.infolist(userid);
	}

	@Override
	public int auth(String userid) {
		return userDAO.auth(userid);
	}
	
	@Override
	public LibrarianBean loginmanager(LibrarianBean librarianbean) {
		// TODO Auto-generated method stub
		return userDAO.loginmanager(librarianbean);
	}
	
}
