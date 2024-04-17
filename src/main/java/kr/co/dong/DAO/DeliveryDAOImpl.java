package kr.co.dong.DAO;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dong.controller.ServiceController;
import kr.co.dong.domain.DeliveryBean;

@Repository
public class DeliveryDAOImpl implements DeliveryDAO {
	
    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	SqlSession sqlSession;

	private final static String namespaces = "kr.co.dong.serviceMapper";

	@Override
	public int deliveryinsert(DeliveryBean db) {
		return sqlSession.insert(namespaces + ".deliveryinsert", db);
	}

}
