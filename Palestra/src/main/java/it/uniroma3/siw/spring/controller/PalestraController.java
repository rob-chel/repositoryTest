package it.uniroma3.siw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PalestraController {
	
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(Model model) {
			return "index";
	}
	
	@RequestMapping(value = {"/prova"}, method = RequestMethod.GET)
	public String prova(Model model) {
			return "prova.html";
	}
	
	@RequestMapping(value = {"/leggiInfo"}, method = RequestMethod.GET)
	public String informazioni(Model model) {
			return "info.html";
	}
	
	
	
	
	
	
	
	

}
