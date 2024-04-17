package kr.co.dong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dong.DAO.DeliveryDAO;
import kr.co.dong.domain.DeliveryBean;

@Service
public class DeliveryServiceImpl implements DeliveryService{
	@Autowired
	DeliveryDAO deliveryDao;

	@Override
	public int deliveryinsert(DeliveryBean db) {
		return deliveryDao.deliveryinsert(db);
	}
	
}
