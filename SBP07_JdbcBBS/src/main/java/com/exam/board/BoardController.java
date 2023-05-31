package com.exam.board;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.exam.board.dao.BoardDao;

@Controller
public class BoardController {
	@Autowired
	private BoardDao boardDao;

// 루트 패턴
	@RequestMapping("/")
	public String root() throws Exception {
		return "redirect:list";
// 루트 패턴이 입력되면 /list 패턴으로 이동하여 실행됨
	}

// 글목록 패턴
	@RequestMapping("/list")
	public String listPage(Model model) {
		model.addAttribute("boardList", boardDao.listDao());
		return "list";
	}

//글내용 패턴
	@RequestMapping("/view")
	public String view(HttpServletRequest req, Model model) {
		String num = req.getParameter("num");
		model.addAttribute("boardDto", boardDao.viewDao(num));
		return "view";
	}

//글쓰기 입력양식 패턴
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}

//글쓰기 패턴
	@RequestMapping("/write")
	public String write(HttpServletRequest req, Model model) {
		String writer = req.getParameter("writer");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		boardDao.writeDao(writer, title, content);
		return "redirect:list";
	}

//글삭제 패턴
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req, Model model) {
		boardDao.deleteDao(req.getParameter("num"));
		return "redirect:list";
	}
}
