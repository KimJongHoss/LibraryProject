//	관리자 권한 기능 DAO
package kr.co.dong.DAO;

import kr.co.dong.domain.saveBlacklistBean;
import kr.co.dong.domain.saveOverdueBean;
import kr.co.dong.domain.toRegularBean;


public interface ApplicationDAO {

//	정회원 전환 신청
	public int toRegularInsert(toRegularBean trb);
	
//	연체 구제 신청
	public int overdueHelpInsert(saveOverdueBean sob);
	
//	블랙리스트 구제 신청
	public int blacklistHelpInsert(saveBlacklistBean sbb);
	
}