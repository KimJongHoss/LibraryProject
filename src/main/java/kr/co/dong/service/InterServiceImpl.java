package kr.co.dong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dong.DAO.InterDAO;
import kr.co.dong.domain.InterBean;


@Service
public class InterServiceImpl implements InterService{
	@Autowired
	InterDAO interDao;
	
	@Override
	public int interinsert(InterBean ib) {
		return interDao.interinsert(ib);
	}
}
