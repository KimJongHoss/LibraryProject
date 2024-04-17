package kr.co.dong.domain;

public class FreeDTO {

	private int free_board_num;
	private String writer;
	private String title;
	private String content;
	private String regdate;
	private int count;
	
	public FreeDTO() {
		super();
	}

	public FreeDTO(int free_board_num, String writer, String title, String content, String regdate, int count) {
		super();
		this.free_board_num = free_board_num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.count = count;
	}

	public int getFree_board_num() {
		return free_board_num;
	}

	public void setFree_board_num(int free_board_num) {
		this.free_board_num = free_board_num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "FreeDTO [free_board_num=" + free_board_num + ", writer=" + writer + ", title=" + title + ", content="
				+ content + ", regdate=" + regdate + ", count=" + count + "]";
	}

}
