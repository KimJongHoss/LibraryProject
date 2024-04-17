//	연체 구제 신청 Bean
package kr.co.dong.domain;

public class saveOverdueBean {

	private int save_code;
	private String reason;
	private String write_date;
	private int process;
	private String etc;
	private int overdueid;
	private int loan_detail_num;
	private String userid;
	private int rankid;
	
//	Default 생성자
	public saveOverdueBean() {
		super();
	}

//	싹다 생성자
public saveOverdueBean(int save_code, String reason, String write_date, int process, String etc, int overdueid,
		int loan_detail_num, String userid, int rankid) {
	super();
	this.save_code = save_code;
	this.reason = reason;
	this.write_date = write_date;
	this.process = process;
	this.etc = etc;
	this.overdueid = overdueid;
	this.loan_detail_num = loan_detail_num;
	this.userid = userid;
	this.rankid = rankid;
}

//	목록 표기용 생성자
public saveOverdueBean(int save_code, String reason, String write_date, String etc, int overdueid, int loan_detail_num,
		String userid) {
	super();
	this.save_code = save_code;
	this.reason = reason;
	this.write_date = write_date;
	this.etc = etc;
	this.overdueid = overdueid;
	this.loan_detail_num = loan_detail_num;
	this.userid = userid;
}

//	getter/setter
public int getSave_code() {
	return save_code;
}

public void setSave_code(int save_code) {
	this.save_code = save_code;
}

public String getReason() {
	return reason;
}

public void setReason(String reason) {
	this.reason = reason;
}

public String getWrite_date() {
	return write_date;
}

public void setWrite_date(String write_date) {
	this.write_date = write_date;
}

public int getProcess() {
	return process;
}

public void setProcess(int process) {
	this.process = process;
}

public String getEtc() {
	return etc;
}

public void setEtc(String etc) {
	this.etc = etc;
}

public int getOverdueid() {
	return overdueid;
}

public void setOverdueid(int overdueid) {
	this.overdueid = overdueid;
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

public int getRankid() {
	return rankid;
}

public void setRankid(int rankid) {
	this.rankid = rankid;
}

//	toString
@Override
public String toString() {
	return "overdueBean [save_code=" + save_code + ", reason=" + reason + ", write_date=" + write_date + ", process="
			+ process + ", etc=" + etc + ", overdueid=" + overdueid + ", loan_detail_num=" + loan_detail_num
			+ ", userid=" + userid + ", rankid=" + rankid + "]";
}

}
