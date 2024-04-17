package kr.co.dong.domain;

public class LoanDTO {

	private int loan_num; //대출목록번호
	private String userid; //유저아이디
	private String isbncode; //isbn코드
	private int library_code; //도서관코드
	private int loan_detail_num; //대출상세번호
	
//	library DB
	private String name; //도서관이름
	
	
		public LoanDTO() {
		super();
	}


		public LoanDTO(int loan_num, String userid, String isbncode, int library_code, int loan_detail_num,
				String name) {
			super();
			this.loan_num = loan_num;
			this.userid = userid;
			this.isbncode = isbncode;
			this.library_code = library_code;
			this.loan_detail_num = loan_detail_num;
			this.name = name;
		}


		public int getLoan_num() {
			return loan_num;
		}


		public void setLoan_num(int loan_num) {
			this.loan_num = loan_num;
		}


		public String getUserid() {
			return userid;
		}


		public void setUserid(String userid) {
			this.userid = userid;
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


		public int getLoan_detail_num() {
			return loan_detail_num;
		}


		public void setLoan_detail_num(int loan_detail_num) {
			this.loan_detail_num = loan_detail_num;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		@Override
		public String toString() {
			return "LoanDTO [loan_num=" + loan_num + ", userid=" + userid + ", isbncode=" + isbncode + ", library_code="
					+ library_code + ", loan_detail_num=" + loan_detail_num + ", name=" + name + "]";
		}

		
		
}
