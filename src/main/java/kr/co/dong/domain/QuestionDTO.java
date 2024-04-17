package kr.co.dong.domain;

public class QuestionDTO {

	private Integer question_num;
	private String writer;
	private String title;
	private String content;
	private String regdate;
	private Integer count;
	private String etc;
	public QuestionDTO(Integer question_num, String writer, String title, String content, String regdate, Integer count,
			String etc) {
		super();
		this.question_num = question_num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.count = count;
		this.etc = etc;
	}
	public Integer getQuestion_num() {
		return question_num;
	}
	public void setQuestion_num(Integer question_num) {
		this.question_num = question_num;
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	@Override
	public String toString() {
		return "QuestionDTO [question_num=" + question_num + ", writer=" + writer + ", title=" + title + ", content="
				+ content + ", regdate=" + regdate + ", count=" + count + ", etc=" + etc + "]";
	}
	
}