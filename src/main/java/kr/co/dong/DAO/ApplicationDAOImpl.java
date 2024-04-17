//	관리자 권한 기능 DAO
package kr.co.dong.DAO;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dong.controller.ApplicationController;
import kr.co.dong.domain.saveBlacklistBean;
import kr.co.dong.domain.saveOverdueBean;
import kr.co.dong.domain.toRegularBean;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

	@Autowired
	SqlSession sqlSession;
	
	private final static String namespaces = "kr.co.dong.applicationmapper.";
	
//	정회원 전환 신청
	@Override
	public int toRegularInsert(toRegularBean trb) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespaces+"toRegular", trb);
	}

//	연체 구제 신청
	@Override
	public int overdueHelpInsert(saveOverdueBean sob) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespaces+"overdueHelp", sob);
	}

//	블랙리스트 구제 신청
	@Override
	public int blacklistHelpInsert(saveBlacklistBean sbb) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespaces+"blacklistHelp", sbb);
	}

}
