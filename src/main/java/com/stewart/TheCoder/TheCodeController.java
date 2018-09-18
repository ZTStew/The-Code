package com.stewart.TheCoder;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCodeController {
	
	@GetMapping("")
	public String lock(HttpSession session) {
		session.setAttribute("pass", "fail");
		return "lock.jsp";
	}
	
	@GetMapping("/pass")
	public String pass(HttpSession session, RedirectAttributes redirectAttributes) {
		if(session.getAttribute("pass") == null || session.getAttribute("pass") == "fail") {
			redirectAttributes.addFlashAttribute("error", "You are not worthy.");
			return "redirect:";
		}
		return "pass.jsp";
	}
	
	@PostMapping("/check")
	public String check(HttpSession session, RedirectAttributes redirectAttributes, @RequestParam(value="answer") String answer) {
		if(answer.equals("password")) {
			session.setAttribute("pass", "pass");
			return "redirect:/pass";
		}
		redirectAttributes.addFlashAttribute("error", "You are not worthy.");
		return "redirect:";
	}
}
