package kr.co.dong.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dong.domain.SeatRoomDTO;
@Repository
public class SeatRoomDAOImlp implements SeatRoomDAO{
	
	@Autowired
	SqlSession sql;
	
	private static String namespace = "kr.co.dong.mappers.seatRoomMapper.";

//	좌석 리스트 가져오기
	@Override
	public List<SeatRoomDTO> list() {
		return sql.selectList(namespace + "list");
	}

//	좌석 예약하기
	@Override
	public void reservation(SeatRoomDTO sr) {
		sql.update(namespace + "reservation", sr);
	}

//	좌석 수정하기
	@Override
	public void modify(SeatRoomDTO sr) {
		sql.selectOne(namespace + "modify", sr);
	}

//	좌석 수정하기
	@Override
	public void cancel(int seat_no) {
		sql.update(namespace + "cancel", seat_no);
	}

}
