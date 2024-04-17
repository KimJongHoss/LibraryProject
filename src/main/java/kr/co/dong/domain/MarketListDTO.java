package kr.co.dong.domain;

public class MarketListDTO {
	private int marketid;
	private String userid;
	private int marketnum;
	private String isbncode;
	private String book_name;
	private String introduction;
	private int published_date;
	private String author;
	private String image;

	public MarketListDTO() {

	}

	public MarketListDTO(int marketid, String userid, int marketnum, String isbncode, String book_name,
			String introduction, int published_date, String author, String image) {
		super();
		this.marketid = marketid;
		this.userid = userid;
		this.marketnum = marketnum;
		this.isbncode = isbncode;
		this.book_name = book_name;
		this.introduction = introduction;
		this.published_date = published_date;
		this.author = author;
		this.image = image;
	}

	public int getMarketid() {
		return marketid;
	}

	public void setMarketid(int marketid) {
		this.marketid = marketid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getMarketnum() {
		return marketnum;
	}

	public void setMarketnum(int marketnum) {
		this.marketnum = marketnum;
	}

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

	@Override
	public String toString() {
		return "MarketListDTO [marketid=" + marketid + ", userid=" + userid + ", marketnum=" + marketnum + ", isbncode="
				+ isbncode + ", book_name=" + book_name + ", introduction=" + introduction + ", published_date="
				+ published_date + ", author=" + author + ", image=" + image + "]";
	}

}
