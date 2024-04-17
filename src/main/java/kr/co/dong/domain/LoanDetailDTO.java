package kr.co.dong.domain;

import java.sql.Date;

public class LoanDetailDTO {
	private int loan_detail_num;
	private String userid;
	private Date loan_date;
	private Date return_date;
	private Date actual_return_date;
	private boolean extend;
	private String isbncode;
	private String library_code;
	private String Key;

	public LoanDetailDTO() {

	}

	public LoanDetailDTO(int loan_detail_num, String userid, Date loan_date, Date return_date, Date actual_return_date,
			boolean extend, String isbncode, String library_code, String key) {
		super();
		this.loan_detail_num = loan_detail_num;
		this.userid = userid;
		this.loan_date = loan_date;
		this.return_date = return_date;
		this.actual_return_date = actual_return_date;
		this.extend = extend;
		this.isbncode = isbncode;
		this.library_code = library_code;
		Key = key;
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

	public String getLibrary_code() {
		return library_code;
	}

	public void setLibrary_code(String library_code) {
		this.library_code = library_code;
	}

	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	@Override
	public String toString() {
		return "LoanDetailDTO [loan_detail_num=" + loan_detail_num + ", userid=" + userid + ", loan_date=" + loan_date
				+ ", return_date=" + return_date + ", actual_return_date=" + actual_return_date + ", extend=" + extend
				+ ", isbncode=" + isbncode + ", library_code=" + library_code + ", Key=" + Key + "]";
	}

}
