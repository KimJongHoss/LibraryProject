//	블랙리스트 구제 신청 Bean
package kr.co.dong.domain;

public class saveBlacklistBean {
/*
 * save_code int AI PK 
reason varchar(200) 
write_date datetime 
process tinyint(1) 
etc varchar(45) 
userid varchar(45) 
useremail varchar(45) 
rankid int
 * 
 */
	private int save_code;
	private String reason;
	private String write_date;
	private int process;
	private String etc;
	private String userid;
	private String useremail;
	private int rankid;
	
//	Default 생성자
	public saveBlacklistBean() {
		super();
	}

//	싹다 생성자
public saveBlacklistBean(int save_code, String reason, String write_date, int process, String etc, String userid,
		String useremail, int rankid) {
	super();
	this.save_code = save_code;
	this.reason = reason;
	this.write_date = write_date;
	this.process = process;
	this.etc = etc;
	this.userid = userid;
	this.useremail = useremail;
	this.rankid = rankid;
}

//	목록 출력용 생성자
public saveBlacklistBean(int save_code, String reason, String write_date, String etc, String userid, String useremail) {
	super();
	this.save_code = save_code;
	this.reason = reason;
	this.write_date = write_date;
	this.etc = etc;
	this.userid = userid;
	this.useremail = useremail;
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

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public String getUseremail() {
	return useremail;
}

public void setUseremail(String useremail) {
	this.useremail = useremail;
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
	return "saveBlacklistBean [save_code=" + save_code + ", reason=" + reason + ", write_date=" + write_date
			+ ", process=" + process + ", etc=" + etc + ", userid=" + userid + ", useremail=" + useremail + ", rankid="
			+ rankid + "]";
}

}
