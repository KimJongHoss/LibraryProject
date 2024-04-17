package kr.co.dong.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.dong.domain.SeatRoomDTO;

public interface SeatRoomService {

//	좌석 리스트 가져오기
	List<SeatRoomDTO> list();
	
//	좌석 예약하기
	public void reservation(SeatRoomDTO sr);
	
//	좌석 수정하기
	public void modify(SeatRoomDTO sr);
	
//	좌석 취소하기
	public void cancel(int seat_no);
}
