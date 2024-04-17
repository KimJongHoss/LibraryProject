package kr.co.dong.domain;

public class BookBean {
	//book DB 
	private String isbncode;
	private String book_name;
	private String introduction;
	private int published_date;
	private String author;
	private String image;
	private String etc;
	
//	Default 생성자
	public BookBean() {
		super();
	}

//	전체 book DB 생성자
public BookBean(String isbncode, String book_name, String introduction, int published_date, String author, String image,
		String etc) {
	super();
	this.isbncode = isbncode;
	this.book_name = book_name;
	this.introduction = introduction;
	this.published_date = published_date;
	this.author = author;
	this.image = image;
	this.etc = etc;
}
	
//	기본키 제외 book DB 생성자
public BookBean(String book_name, String introduction, int published_date, String author, String image,
		String etc) {
	super();
	this.book_name = book_name;
	this.introduction = introduction;
	this.published_date = published_date;
	this.author = author;
	this.image = image;
	this.etc = etc;
}

//	getter/setter
public String getIsbncode() {
	return isbncode;
}

public void setIsbncode(String isbncode) {
	this.isbncode = isbncode;
}

public String getBook_name() {
	return book_name;
}

public void setBook_name(String book_name) {
	this.book_name = book_name;
}

public String getIntroduction() {
	return introduction;
}

public void setIntroduction(String introduction) {
	this.introduction = introduction;
}

public int getPublished_date() {
	return published_date;
}

public void setPublished_date(int published_date) {
	this.published_date = published_date;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public String getEtc() {
	return etc;
}

public void setEtc(String etc) {
	this.etc = etc;
}

//	toString(기본키 제외)
@Override
public String toString() {
	return "BookBean [book_name=" + book_name + ", introduction=" + introduction
			+ ", published_date=" + published_date + ", author=" + author + ", image=" + image + ", etc=" + etc + "]";
}
	
	


	
}
