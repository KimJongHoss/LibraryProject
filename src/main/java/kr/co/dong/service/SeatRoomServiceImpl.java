package kr.co.dong.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dong.DAO.*;
import kr.co.dong.domain.SeatRoomDTO;
@Service
public class SeatRoomServiceImpl implements SeatRoomService {

	@Autowired
	SeatRoomDAO dao;
	
	@Override
	public List<SeatRoomDTO> list() {
		return dao.list();
	}

	@Override
	public void reservation(SeatRoomDTO sr) {
		dao.reservation(sr);
	}

	@Override
	public void modify(SeatRoomDTO sr) {
		dao.modify(sr);
	}

	@Override
	public void cancel(int seat_no) {
		dao.cancel(seat_no);
	}

}
