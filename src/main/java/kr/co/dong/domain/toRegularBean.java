//	정회원 전환 Bean
package kr.co.dong.domain;

public class toRegularBean {

	private int apply_code;
	private String apply_reason;
	private String write_date;
	private int process;
	private String etc;
	private String userid;
	private String useremail;
	private int rankid;
	
//	Default 생성자
	public toRegularBean() {
		super();
	}

//	싹대 생성자
	public toRegularBean(int apply_code, String apply_reason, String write_date, int process, String etc,
			String userid, String useremail, int rankid) {
		super();
		this.apply_code = apply_code;
		this.apply_reason = apply_reason;
		this.write_date = write_date;
		this.process = process;
		this.etc = etc;
		this.userid = userid;
		this.useremail = useremail;
		this.rankid = rankid;
	}

//	정회원 전환 리스트용 생성자
	public toRegularBean(int apply_code, String apply_reason, String write_date, int process, String etc, String userid,
			String useremail) {
		super();
		this.apply_code = apply_code;
		this.apply_reason = apply_reason;
		this.write_date = write_date;
		this.process = process;
		this.etc = etc;
		this.userid = userid;
		this.useremail = useremail;
	}

//	getter/setter
	public int getApply_code() {
		return apply_code;
	}

	public void setApply_code(int apply_code) {
		this.apply_code = apply_code;
	}

	public String getApply_reason() {
		return apply_reason;
	}

	public void setApply_reason(String apply_reason) {
		this.apply_reason = apply_reason;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public int isProcess() {
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
		return "toRegularBean [apply_code=" + apply_code + ", apply_reason=" + apply_reason + ", write_date="
				+ write_date + ", process=" + process + ", etc=" + etc + ", userid=" + userid + ", useremail="
				+ useremail + ", rankid=" + rankid + "]";
	}
	
}
