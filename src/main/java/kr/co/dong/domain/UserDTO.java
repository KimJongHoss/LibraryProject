
package kr.co.dong.domain;

import java.sql.Date;

public class UserDTO {
	private String userid;
	private String useremail;
	private int rankid;
	private String userpassword;
	private String username;
	private String usergender;
	private String useraddress;
	private String userphonenum;
	private Date userbirth;
	private Date userjoinday;
	private String useretc;

	public UserDTO() {

	}

	public UserDTO(String userid, String useremail, int rankid, String userpassword, String username, String usergender,
			String useraddress, String userphonenum, Date userbirth, Date userjoinday, String useretc) {
		super();
		this.userid = userid;
		this.useremail = useremail;
		this.rankid = rankid;
		this.userpassword = userpassword;
		this.username = username;
		this.usergender = usergender;
		this.useraddress = useraddress;
		this.userphonenum = userphonenum;
		this.userbirth = userbirth;
		this.userjoinday = userjoinday;
		this.useretc = useretc;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getUserjoinday() {
		return userjoinday;
	}

	public void setUserjoinday(Date userjoinday) {
		this.userjoinday = userjoinday;
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

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUsergender() {
		return usergender;
	}

	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getUserphonenum() {
		return userphonenum;
	}

	public void setUserphonenum(String userphonenum) {
		this.userphonenum = userphonenum;
	}

	public Date getUserbirth() {
		return userbirth;
	}

	public void setUserbirth(Date userbirth) {
		this.userbirth = userbirth;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUseretc() {
		return useretc;
	}

	public void setUseretc(String useretc) {
		this.useretc = useretc;
	}

	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", useremail=" + useremail + ", rankid=" + rankid + ", userpassword="
				+ userpassword + ", username=" + username + ", usergender=" + usergender + ", useraddress="
				+ useraddress + ", userphonenum=" + userphonenum + ", userbirth=" + userbirth + ", userjoinday="
				+ userjoinday + ", useretc=" + useretc + "]";
	}

}
