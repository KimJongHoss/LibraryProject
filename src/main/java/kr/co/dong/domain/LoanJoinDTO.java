package kr.co.dong.domain;

import java.sql.Date;

public class LoanJoinDTO {
	
//	loan, loan_detail DB join
	private int loan_num; //대출 목록 번호
	private int loan_detail_num; //대출 상세 번호
	private String userid; //아이디
	private Date loan_date; //대출일
	private Date return_date; //반납예정일
	private Date actual_return_date; //실제반납일
	private boolean extend; //연장 여부
	private String isbncode; //isbn코드
	private int library_code; //도서관 코드
	private String name; //도서관 이름
	private int deliveryid; //책 배송
	
	public LoanJoinDTO() {
		super();
	}

	public LoanJoinDTO(int loan_num, int loan_detail_num, String userid, Date loan_date, Date return_date,
			Date actual_return_date, boolean extend, String isbncode, int library_code, String name, int deliveryid) {
		super();
		this.loan_num = loan_num;
		this.loan_detail_num = loan_detail_num;
		this.userid = userid;
		this.loan_date = loan_date;
		this.return_date = return_date;
		this.actual_return_date = actual_return_date;
		this.extend = extend;
		this.isbncode = isbncode;
		this.library_code = library_code;
		this.name = name;
		this.deliveryid = deliveryid;
	}

	public int getLoan_num() {
		return loan_num;
	}

	public void setLoan_num(int loan_num) {
		this.loan_num = loan_num;
	}

	public int getLoan_detail_num() {
		return loan_detail_num;
	}

	public void setLoan_detail_num(int loan_detail_num) {
		this.loan_detail_num = loan_detail_num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getLoan_date() {
		return loan_date;
	}

	public void setLoan_date(Date loan_date) {
		this.loan_date = loan_date;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	public Date getActual_return_date() {
		return actual_return_date;
	}

	public void setActual_return_date(Date actual_return_date) {
		this.actual_return_date = actual_return_date;
	}

	public boolean isExtend() {
		return extend;
	}

	public void setExtend(boolean extend) {
		this.extend = extend;
	}

	public String getIsbncode() {
		return isbncode;
	}

	public void setIsbncode(String isbncode) {
		this.isbncode = isbncode;
	}

	public int getLibrary_code() {
		return library_code;
	}

	public void setLibrary_code(int library_code) {
		this.library_code = library_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeliveryid() {
		return deliveryid;
	}

	public void setDeliveryid(int deliveryid) {
		this.deliveryid = deliveryid;
	}

	@Override
	public String toString() {
		return "LoanJoinDTO [loan_num=" + loan_num + ", loan_detail_num=" + loan_detail_num + ", userid=" + userid
				+ ", loan_date=" + loan_date + ", return_date=" + return_date + ", actual_return_date="
				+ actual_return_date + ", extend=" + extend + ", isbncode=" + isbncode + ", library_code="
				+ library_code + ", name=" + name + ", deliveryid=" + deliveryid + "]";
	}

		
}
