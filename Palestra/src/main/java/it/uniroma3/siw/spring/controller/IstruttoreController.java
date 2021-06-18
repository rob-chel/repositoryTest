package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.service.IstruttoreService;



@Controller
public class IstruttoreController {
	
	@Autowired
	private IstruttoreService istruttoreService;
	
	@RequestMapping(value="/listaIstruttori",method = RequestMethod.GET)
	public String informazioni(Model model) {
		model.addAttribute("istruttori",this.istruttoreService.tutti());
		return "istruttori.html";
	}
	
	@RequestMapping(value = "/istruttore/{id}", method = RequestMethod.GET)
    public String getArtista(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("istruttore", this.istruttoreService.collezionePerId(id));
    	return "istruttore.html";
    }
	

}
