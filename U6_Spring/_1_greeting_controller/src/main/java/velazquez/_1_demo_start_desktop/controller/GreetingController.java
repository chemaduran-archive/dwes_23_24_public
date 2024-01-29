package velazquez._1_demo_start_desktop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user/")
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name",required=false,defaultValue="World") String name,
			Model model) {
		model.addAttribute("name",name);
		return "greeting";
	}
	
	@GetMapping("/bye")
	public String bye(@RequestParam(name="name",required=false,defaultValue="World") String name,
			Model model) {
		model.addAttribute("name",name);
		return "bye";
	}
}
