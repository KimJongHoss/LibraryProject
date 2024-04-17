package kr.co.dong.domain;

public class CommentDTO {
	private int comment_num;
	private String writer;
	private String content;
	private String regdate;
	private int free_board_num;//게시글 외래키 
	
	
	public int getFree_board_num() {
		return free_board_num;
	}
	public void setFree_board_num(int free_board_num) {
		this.free_board_num = free_board_num;
	}
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
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
	@Override
	public String toString() {
		return "CommentDTO [free_board_num=" + free_board_num + ", comment_num=" + comment_num + ", writer=" + writer
				+ ", content=" + content + ", regdate=" + regdate + "]";
	}
	
}
