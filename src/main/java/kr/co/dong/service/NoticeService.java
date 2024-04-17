package kr.co.dong.service;

import java.util.List;

import kr.co.dong.domain.NoticeDTO;


public interface NoticeService {
	// 전체목록을 가져오는 메소드
	public List<NoticeDTO> noticeAndlist();
	
	// 상세보기 처리를 위한 메소드(글읽기)
		public int noticeAndcount(int notice_num);  //조회수 증가
		public NoticeDTO noticeAndview(int notice_num);  //getRead(), getView()
		// 게시물 총 갯수
				public int noticecount();
				// 게시물 목록 + 페이징
				public List<NoticeDTO> noticelistPage(int displayPost, int postNum);
				
}
