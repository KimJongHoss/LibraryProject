package kr.co.dong.domain;

public class AnswerBean {

	private int answer_num;
	private int question_num;
	private String writer;
	private String content;
	private String regdate;
	private int etc;
	
	public AnswerBean() {
		super();
	}

//	싹다 생성자
	public AnswerBean(int answer_num, int question_num, String writer, String content, String regdate, int etc) {
		super();
		this.answer_num = answer_num;
		this.question_num = question_num;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.etc = etc;
	}

//	getter/setter
	public int getAnswer_num() {
		return answer_num;
	}

	public void setAnswer_num(int answer_num) {
		this.answer_num = answer_num;
	}

	public int getQuestion_num() {
		return question_num;
	}

	public void setQuestion_num(int question_num) {
		this.question_num = question_num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public int getEtc() {
		return etc;
	}

	public void setEtc(int etc) {
		this.etc = etc;
	}

//	toString
	@Override
	public String toString() {
		return "AnswerBean [answer_num=" + answer_num + ", question_num=" + question_num + ", writer=" + writer
				+ ", content=" + content + ", regdate=" + regdate + ", etc=" + etc + "]";
	}
	
}