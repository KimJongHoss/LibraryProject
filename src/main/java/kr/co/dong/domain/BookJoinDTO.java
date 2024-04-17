package kr.co.dong.domain;

public class BookJoinDTO {
	
	//book DB 
		private String book_name;//도서명
		private String introduction;//소개글
		private int published_date;//발행일
		private String author;//작가
		private String image;//이미지
		private String etc;//비고
		
//		Book_List DB
		private int book_list_num;//책목록번호
		private int loan_status;//대출상태
		private int loan_available;//보유권수

//		library DB
		private String name;//도서관이름
		
//		외래키
		private int library_code;//도서관코드
		private String isbncode;//isbncode

		public BookJoinDTO() {
			super();
		}

		public BookJoinDTO(String book_name, String introduction, int published_date, String author, String image,
				String etc, int book_list_num, int loan_status, int loan_available, String name, int library_code,
				String isbncode) {
			super();
			this.book_name = book_name;
			this.introduction = introduction;
			this.published_date = published_date;
			this.author = author;
			this.image = image;
			this.etc = etc;
			this.book_list_num = book_list_num;
			this.loan_status = loan_status;
			this.loan_available = loan_available;
			this.name = name;
			this.library_code = library_code;
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

		public int getBook_list_num() {
			return book_list_num;
		}

		public void setBook_list_num(int book_list_num) {
			this.book_list_num = book_list_num;
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getLibrary_code() {
			return library_code;
		}

		public void setLibrary_code(int library_code) {
			this.library_code = library_code;
		}

		public String getIsbncode() {
			return isbncode;
		}

		public void setIsbncode(String isbncode) {
			this.isbncode = isbncode;
		}

		@Override
		public String toString() {
			return "BookJoinDTO [book_name=" + book_name + ", introduction=" + introduction + ", published_date="
					+ published_date + ", author=" + author + ", image=" + image + ", etc=" + etc + ", book_list_num="
					+ book_list_num + ", loan_status=" + loan_status + ", loan_available=" + loan_available + ", name="
					+ name + ", library_code=" + library_code + ", isbncode=" + isbncode + "]";
		}

		
}
