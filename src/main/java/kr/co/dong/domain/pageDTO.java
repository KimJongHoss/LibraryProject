package kr.co.dong.domain;

public class pageDTO {

	private int page; //현재페이지
	private int count; //도서 총 개수
	private int postNum; //한 페이지에 출력할 게시물 개수
	private int pageNum; //하단 페이지 번호 (도서 총 개수 / 한 페이지에 출력할 개수)의 올림
	private int displayPost; //출력할 게시물
	private int pageCnt; //한번에 표시할 페이지 번호 개수
	private int endNum; //표시되는 마지막 번호
	private int startNum; //표시되는 첫 번호
	private boolean prev; //이전버튼
	private boolean next; //다음버튼
	
	public pageDTO() {
		super();
	}

	public pageDTO(int page, int count, int postNum, int pageNum, int displayPost, int pageCnt, int endNum,
			int startNum, boolean prev, boolean next) {
		super();
		this.page = page;
		this.count = count;
		this.postNum = postNum;
		this.pageNum = pageNum;
		this.displayPost = displayPost;
		this.pageCnt = pageCnt;
		this.endNum = endNum;
		this.startNum = startNum;
		this.prev = prev;
		this.next = next;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCount() {
		return count;		
	}

	public void setCount(int count) {
		this.count = count;
		
		Page();
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getDisplayPost() {
		return displayPost;
	}

	public void setDisplayPost(int displayPost) {
		this.displayPost = displayPost;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public boolean getPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean getNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	private void Page() {
		
		
//		출력할 게시물
		displayPost = (page - 1) * postNum;
//		하단 페이지 번호 (도서 총 개수 / 한 페이지에 출력할 개수)의 올림
		pageNum = (int)Math.ceil((double)count/postNum);
		
//		페이지번호 이전 다음 만들기
//		한번에 표시할 페이지 번호 개수
		pageCnt = 5;
//		표시되는 마지막 번호
		endNum = (int)(Math.ceil((double)page/(double)pageCnt)* pageCnt);
//		표시되는 첫 번호
		startNum = endNum - (pageCnt -1);
//		마지막번호 요류잡기용
		int lastNum = (int)Math.ceil((double)count/(double)postNum);
		
		if(endNum > lastNum) {
			endNum = lastNum;
		}
		
		prev = startNum == 1 ? false : true;
		next = endNum * postNum >= count ? false : true;


	}
	
}
