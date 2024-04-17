package kr.co.dong.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.dong.service.MarketService;

@Controller
public class MarketController {
	
	final Logger logger = LoggerFactory.getLogger(MarketController.class);
	
	@Inject
	private MarketService marketService;

	@GetMapping("market/list")
	public void list(HttpSession session
			, Model model) {
		model.addAttribute("list", marketService.list((String) session.getAttribute("userid")));
	}
	
	@RequestMapping("market/delete")
	@ResponseBody
	public int delete(@RequestParam Map<String, Object> map) {
		List<Object> list = new ArrayList<Object>();
		int cnt = (Integer.parseInt((String)map.get("CNT")));
		String getmarketid = (String)map.get("marketid");
		String arr[] = getmarketid.split(",");
		for(int i =0; i <cnt; i++) {
			String marketid = (String)arr[i];
			list.add(marketid);
		}
		
		return marketService.delete(list);
	}
	
	@RequestMapping("market/loan")
	public String loan(@RequestParam Map<String, Object> map) {
		int cnt = Integer.parseInt((String)map.get("cnt"));
		List<Object> idList = new ArrayList<Object>();
		List<String> bookList = new ArrayList<String>();
		List<Integer> loanCountList = new ArrayList<Integer>();
		int count = marketService.count() + 1;
		System.out.println(count + "count");
		String userid = (String)map.get("userid");
		String getMarketid = (String)map.get("marketid");
		String getIsbncode = (String)map.get("isbncode");
		String arrId[] = getMarketid.split(",");
		String arrBook[] = getIsbncode.split(",");
		for(int i =0; i < cnt; i++) {
			String marketid = arrId[i];
			String book = arrBook[i];
			idList.add(marketid);
			bookList.add(book);
			loanCountList.add(count + i);
		}
		marketService.loanadd(idList, bookList, cnt, userid, loanCountList);
		return "redirect:/market/list";
	}
	
}
