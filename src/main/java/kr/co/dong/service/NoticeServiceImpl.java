package kr.co.dong.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dong.DAO.NoticeDAO;
import kr.co.dong.domain.NoticeDTO;


@Service
public class NoticeServiceImpl implements NoticeService {
	@Inject
	private NoticeDAO noticeDAO;
	
	@Override
	public List<NoticeDTO> noticeAndlist() {
		return noticeDAO.noticeAndlist();
	}
//조회수
	@Override
	public int noticeAndcount(int notice_num) {
		return noticeDAO.noticeAndcount(notice_num);
	}
//상세 
	public NoticeDTO noticeAndview(int notice_num) {
		return noticeDAO.noticeAndview(notice_num);
	}
	// 게시물 총 갯수
		@Override
		public int noticecount() {
		 return noticeDAO.noticecount();
		}
		// 게시물 목록 + 페이징
		@Override
		public List<NoticeDTO> noticelistPage(int displayPost, int postNum) {
		 return noticeDAO.noticelistPage(displayPost, postNum);
		}
}
