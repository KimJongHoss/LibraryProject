package kr.co.dong.DAO;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dong.controller.ServiceController;
import kr.co.dong.domain.InterBean;

@Repository
public class InterDAOImpl implements InterDAO{
	
    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	SqlSession sqlSession;
	
	private final static String namespaces = "kr.co.dong.serviceMapper";

	@Override
	public int interinsert(InterBean ib) {
		return sqlSession.insert(namespaces + ".interinsert", ib);
	}
	
}
