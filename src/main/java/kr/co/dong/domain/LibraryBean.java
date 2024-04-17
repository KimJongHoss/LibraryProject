//	도서관 관리 Bean
package kr.co.dong.domain;

public class LibraryBean {
	//library DB 
	private int library_code;
	private String name;
	private String address;
	
//	Default 생성자
	public LibraryBean() {
		super();
	}

//	싹다 생성자
public LibraryBean(int library_code, String name, String address) {
	super();
	this.library_code = library_code;
	this.name = name;
	this.address = address;
}

//	기본키 제외 생성자
public LibraryBean(String name, String address) {
	super();
	this.name = name;
	this.address = address;
}

//	getter/setter
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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

//	ToString
@Override
public String toString() {
	return "librararyBean [library_code=" + library_code + ", name=" + name + ", address=" + address + "]";
}
	
}
