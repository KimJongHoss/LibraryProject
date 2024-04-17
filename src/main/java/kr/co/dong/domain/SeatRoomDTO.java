package kr.co.dong.domain;
//	좌석관리DTO
public class SeatRoomDTO {
//	좌석 번호
	private int seat_no;
//	사용자 아이디
	private String userid;
//	좌석 이용상태
	private int seat_status;
//	좌석 상세정보
	private String seat_info;
	
	private String etc;
	
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getSeat_status() {
		return seat_status;
	}
	public void setSeat_status(int seat_status) {
		this.seat_status = seat_status;
	}
	public String getSeat_info() {
		return seat_info;
	}
	public void setSeat_info(String seat_info) {
		this.seat_info = seat_info;
	}
	public SeatRoomDTO(int seat_no, String userid, int seat_status, String seat_info, String etc) {
		super();
		this.seat_no = seat_no;
		this.userid = userid;
		this.seat_status = seat_status;
		this.seat_info = seat_info;
		this.etc = etc;
	}
	
	public SeatRoomDTO() {}
	@Override
	public String toString() {
		return "SeatChartDTO [seat_no=" + seat_no + ", userid=" + userid + ", seat_status=" + seat_status
				+ ", seat_info=" + seat_info + ", etc=" + etc + "]";
	}
	
	
	
	
}
