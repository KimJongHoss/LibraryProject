package kr.co.dong.service;
//관리자 권한 기능 Service
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dong.DAO.AdminDAO;
import kr.co.dong.DAO.ApplicationDAO;
import kr.co.dong.controller.AdminController;
import kr.co.dong.controller.ApplicationController;
import kr.co.dong.domain.LibrarianBean;
import kr.co.dong.domain.LibraryBean;
import kr.co.dong.domain.saveBlacklistBean;
import kr.co.dong.domain.saveOverdueBean;
import kr.co.dong.domain.toRegularBean;

@Service
public class ApplicationServiceImpl implements ApplicationService{
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	
	@Autowired
	ApplicationDAO applicationDao;

//	정회원 전환 신청 Service
	@Override
	public int toRegularInsert(toRegularBean trb) {
		// TODO Auto-generated method stub
		return applicationDao.toRegularInsert(trb);
	}

//	연체 구제 신청 Service
	@Override
	public int overdueHelpInsert(saveOverdueBean sob) {
		// TODO Auto-generated method stub
		return applicationDao.overdueHelpInsert(sob);
	}

//	블랙리스트 구제 신청 Service
	@Override
	public int blacklistHelpInsert(saveBlacklistBean sbb) {
		// TODO Auto-generated method stub
		return applicationDao.blacklistHelpInsert(sbb);
	}

}
