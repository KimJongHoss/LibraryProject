//	사서 관리 Bean
package kr.co.dong.domain;

/*
 * id varchar(15) PK 
password varchar(15) 
name varchar(15) 
gender varchar(15) 
address varchar(45) 
birth date 
email varchar(45) 
phone varchar(45) 
etc varchar(45)
 */

public class LibrarianBean {
	//librarian DB 
	private String id;
	private String password;
	private String name;
	private String gender;
	private String address;
	private String birth;
	private String email;
	private String phone;
	private String etc;
	
	
//	Default 생성자
	public LibrarianBean() {
		super();
	}

//	싹다 생성자
	public LibrarianBean(String id, String password, String name, String gender, String address, String birth,
			String email, String phone, String etc) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.etc = etc;
	}
	
//	비밀번호를 제외한 생성자
	public LibrarianBean(String id, String name, String gender, String address, String birth,
			String email, String phone, String etc) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.etc = etc;
	}
	
//	아이디와 비밀번호를 제외한 생성자
	public LibrarianBean(String name, String gender, String address, String birth,
			String email, String phone, String etc) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.etc = etc;
	}

//	getter/setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

//	ToString
	@Override
	public String toString() {
		return "LibrarianBean [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", address=" + address + ", birth=" + birth + ", email=" + email + ", phone=" + phone + ", etc=" + etc
				+ "]";
	}
	
	

	
}
