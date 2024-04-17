package kr.co.dong.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dong.domain.LibrarianBean;
import kr.co.dong.domain.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private final String namespaces = "kr.co.dong.mapper.user"; 

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public UserDTO login(UserDTO userDTO) {
		
		return sqlSession.selectOne(namespaces + ".login", userDTO);
	}

	@Override
	public int member(UserDTO userDTO) {
		return sqlSession.insert(namespaces + ".member", userDTO);
	}

	@Override
	public Integer idCheck(String userid) {
		return sqlSession.selectOne(namespaces + ".idCheck", userid);
	}

	@Override
	public String findId(UserDTO userDTO) {
		return sqlSession.selectOne(namespaces + ".findid", userDTO);
	}

	@Override
	public String findPassword(UserDTO userDTO) {
		return sqlSession.selectOne(namespaces + ".forgotpassword", userDTO);
	}

	@Override
	public String crypt(String userid) {
		return sqlSession.selectOne(namespaces + ".cryptcheck", userid);
	}

	@Override
	public int updatePassword(UserDTO userDTO) {
		return sqlSession.update(namespaces + ".updatepassword", userDTO);
	}
	
	@Override
	public int update(UserDTO userDTO) {
		return sqlSession.update(namespaces + ".infoupdate", userDTO);
	}

	@Override
	public int delete(String userid) {
		return sqlSession.delete(namespaces + ".infodelete", userid);
	}

	@Override
	public UserDTO infolist(String userid) {
		return sqlSession.selectOne(namespaces + ".infolist", userid);
	}

	@Override
	public int auth(String userid) {
		return sqlSession.selectOne(namespaces + ".infoauth", userid);
	}

//	사서 로그인
	@Override
	public LibrarianBean loginmanager(LibrarianBean librarianbean) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespaces +".loginmanager", librarianbean);
	}

	
}
