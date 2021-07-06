package kr.ac.kopo.kopo08.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello")//해당 url이 들어오면 아래에 있는 메서드를 이용함
	public String hellSpringBoot(Model model) {
		model.addAttribute("name", "김은비"); // key, value
		return "hello"; //해당 이름을 가진 페이지로 값을 반환
	}
}
