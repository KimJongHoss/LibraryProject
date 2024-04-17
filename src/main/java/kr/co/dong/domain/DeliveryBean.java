package kr.co.dong.domain;

import java.sql.Date;

public class DeliveryBean {
/*
 *  deliveryid int PK 
	userid varchar(45) PK 
	receiver varchar(45) 
	number varchar(45) 
	youraddress varchar(45) 
	day date 
	status varchar(45) 
	etc varchar(45) 
	library_code int PK 
	username varchar(45) PK 
	useraddress varchar(45) PK 
	usernumber varchar(45) PK
 */
	
	private int deliveryid;
	private String username;
	private String usernumber;
	private String useraddress;
	private Date day;
	private String status;
	private String etc;
	private int library_code;
	private String messages;
	private String isbncode;
	
	public DeliveryBean() {}

	public DeliveryBean(int deliveryid, String username, String usernumber, String useraddress, Date day, String status,
			String etc, int library_code, String messages, String isbncode) {
		super();
		this.deliveryid = deliveryid;
		this.username = username;
		this.usernumber = usernumber;
		this.useraddress = useraddress;
		this.day = day;
		this.status = status;
		this.etc = etc;
		this.library_code = library_code;
		this.messages = messages;
		this.isbncode = isbncode;
	}



	public int getDeliveryid() {
		return deliveryid;
	}



	public void setDeliveryid(int deliveryid) {
		this.deliveryid = deliveryid;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getUsernumber() {
		return usernumber;
	}



	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}



	public String getUseraddress() {
		return useraddress;
	}



	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}



	public Date getDay() {
		return day;
	}



	public void setDay(Date day) {
		this.day = day;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getEtc() {
		return etc;
	}



	public void setEtc(String etc) {
		this.etc = etc;
	}



	public int getLibrary_code() {
		return library_code;
	}



	public void setLibrary_code(int library_code) {
		this.library_code = library_code;
	}



	public String getMessages() {
		return messages;
	}



	public void setMessages(String messages) {
		this.messages = messages;
	}



	public String getIsbncode() {
		return isbncode;
	}



	public void setIsbncode(String isbncode) {
		this.isbncode = isbncode;
	}



	@Override
	public String toString() {
		return "DeliveryBean [deliveryid=" + deliveryid + ", username=" + username + ", usernumber=" + usernumber
				+ ", useraddress=" + useraddress + ", day=" + day + ", status=" + status + ", etc=" + etc
				+ ", library_code=" + library_code + ", messages=" + messages + ", isbncode=" + isbncode + "]";
	}
	
	
}
