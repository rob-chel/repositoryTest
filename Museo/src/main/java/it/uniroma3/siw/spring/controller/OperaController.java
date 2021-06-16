package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	private OperaService operaService;
	
	@RequestMapping(value = "/opera/{id}", method = RequestMethod.GET)
    public String getArtista(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("opera", this.operaService.operaPerId(id));
    	return "opera.html";
    }

}
