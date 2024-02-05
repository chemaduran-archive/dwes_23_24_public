package velazquez._0_ejemplo_session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class EjemploController {

	@GetMapping("/")
	public String home(HttpSession session,@ModelAttribute("error") String error) {

		// Hay que cambiar el rol a admin para poder acceder a la página de productos
		session.setAttribute("role", "admin");
		return "home";
		
	}
	
	@GetMapping("/products")
	public ModelAndView products(ModelMap model, HttpSession session) {
		
		if (session.isNew() || !session.getAttribute("role").equals("admin")) {
			session.invalidate();
			model.addAttribute("error", "EXISTE UN ERROR");			
			return new ModelAndView("redirect:/",model);
		}
		
		model.addAttribute("contenido", "menu.products");
		return new ModelAndView("products");
	}
	
	@GetMapping("/services")
	public String services(Model model, HttpSession session) {
		
		if (session.isNew() || !session.getAttribute("role").equals("usuario")) {
			session.invalidate();
			return "redirect:/";
		}
		model.addAttribute("contenido", "menu.services");
		return "services";
	}
	
	
	@GetMapping("/about")
	public String about(Model model, HttpSession session) {
		
		if (session.isNew() || !session.getAttribute("role").equals("usuario")) {
			session.invalidate();
			return "redirect:/";
		}
		
		model.addAttribute("contenido", "menu.about");
		return "about";
	}
}
