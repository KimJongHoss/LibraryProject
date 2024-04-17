package kr.co.dong.domain;

public class NoticeDTO {
	private int notice_num;
	private String writer;
	private String title;
	private String content;
	private String regdate;
	private int count;
	private String etc;
	
//	default 생성자
	public NoticeDTO() {
		super();
		
	}
	
//	싹다 생성자
	public NoticeDTO(int notice_num, String writer, String title, String content, String regdate, int count,
			String etc) {
		super();
		this.notice_num = notice_num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.count = count;
		this.etc = etc;
	}
	
//	추가 시 필요한 생성자
	public NoticeDTO(String writer, String title, String content, String regdate, int count
			) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.count = count;
	}

//	getter/setter
	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
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

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

//	toString
	@Override
	public String toString() {
		return "NoticeDTO [notice_num=" + notice_num + ", writer=" + writer + ", title=" + title + ", content="
				+ content + ", regdate=" + regdate + ", count=" + count + ", etc=" + etc + "]";
	}
	
}