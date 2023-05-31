package com.exam.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Membership {

	@Autowired
	private MemberShipAccess memberShipAccess;

	@RequestMapping("/main")
	public String mtdMember(Model model) {

		model.addAttribute("memberList", memberShipAccess.mtdList());
		return "/main";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchMember(@RequestParam("searchID") String searchID, Model model) {
		List<MemInfo> searchResults = memberShipAccess.searchByID(searchID); // MemberShipAccess에서 ID로 검색하는 메서드 호출
		
		   if (searchID.trim().isEmpty()) {
		        searchResults = memberShipAccess.mtdList(); // 전체 자료 조회
		    } else {
		        searchResults = memberShipAccess.searchByID(searchID); // ID로 검색
		    }
		
		model.addAttribute("memberList", searchResults);
		return "/main"; // 검색 결과를 표시하는 화면으로 이동
	}
	
	@RequestMapping(value= "/delete", method = RequestMethod.POST)
	public String deleteMember(@RequestParam("userID") String userID, Model model) {
		 memberShipAccess.deleteByID(userID);
		
		List<MemInfo> updatedList = memberShipAccess.mtdList(); // 업데이트된 회원 목록 조회
		model.addAttribute("memberList", updatedList);
		return "redirect:/main";
		
	}
	

}
