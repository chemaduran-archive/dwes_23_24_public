package velazquez._2_includes_and_forms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import velazquez._2_includes_and_forms.dto.ProductDTO;
import velazquez._2_includes_and_forms.dto.UserDTO;


@Controller
@RequestMapping("/forms")
public class FormExampleControler {
	
	
	@GetMapping("/simpleform")
	public String simpleForm(Model model) {
		
		ProductDTO product = new ProductDTO();
		model.addAttribute("product", product);
		
		return "forms/simpleform";
		
	}
	
	@PostMapping("/simpleform")
	public String simpleFormPost(@ModelAttribute ProductDTO product, Model model) {
		model.addAttribute("product", product);
		return "forms/simpleform";
		
	}
	
	@GetMapping("/complexform")
	public String complexForm(Model model) {
		Map<Integer, String> paises = new HashMap<>();
		paises.put(1, "fields.country.spain");
		paises.put(2, "fields.country.uk");
		paises.put(3, "fields.country.france");
		paises.put(4, "fields.country.italy");
		paises.put(5,  "fields.country.germany");
		
		model.addAttribute("paises", paises);
		model.addAttribute("user",new UserDTO());
		
		return "forms/complexform";
	}
	
	@PostMapping("/complexform")
	public String complexFormPost(@ModelAttribute UserDTO user, Model model) {
		
		model.addAttribute("user", user);
		return "forms/complexform";
		
	}

}
