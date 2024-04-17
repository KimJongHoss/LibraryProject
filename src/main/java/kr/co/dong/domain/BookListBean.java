package kr.co.dong.domain;

public class BookListBean {

	private int book_list_num; //목록번호
	private String isbncode; //isbncode
	private int library_code; //도서관 코드
	private int loan_status; //대출권수
	private int loan_available; //보유권수  
	private String etc; //비고
	
	
	public BookListBean() {
		super();
	}


	public BookListBean(int book_list_num, String isbncode, int library_code, int loan_status, int loan_available,
			String etc) {
		super();
		this.book_list_num = book_list_num;
		this.isbncode = isbncode;
		this.library_code = library_code;
		this.loan_status = loan_status;
		this.loan_available = loan_available;
		this.etc = etc;
	}


	public int getBook_list_num() {
		return book_list_num;
	}


	public void setBook_list_num(int book_list_num) {
		this.book_list_num = book_list_num;
	}


	public String getIsbncode() {
		return isbncode;
	}


	public void setIsbncode(String isbncode) {
		this.isbncode = isbncode;
	}


	public int getLibrary_code() {
		return library_code;
	}


	public void setLibrary_code(int library_code) {
		this.library_code = library_code;
	}


	public int getLoan_status() {
		return loan_status;
	}


	public void setLoan_status(int loan_status) {
		this.loan_status = loan_status;
	}


	public int getLoan_available() {
		return loan_available;
	}


	public void setLoan_available(int loan_available) {
		this.loan_available = loan_available;
	}


	public String getEtc() {
		return etc;
	}


	public void setEtc(String etc) {
		this.etc = etc;
	}


	@Override
	public String toString() {
		return "BookListBean [book_list_num=" + book_list_num + ", isbncode=" + isbncode + ", library_code="
				+ library_code + ", loan_status=" + loan_status + ", loan_available=" + loan_available + ", etc=" + etc
				+ "]";
	}

	
	
}
