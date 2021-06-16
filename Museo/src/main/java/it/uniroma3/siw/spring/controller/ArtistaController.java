package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.service.ListaAutoriService;

@Controller
public class ArtistaController {
	
	@Autowired
	private ListaAutoriService ListaAutoriService;
	
	@RequestMapping(value="/autori",method = RequestMethod.GET)
	public String listaAutori(Model model) {
		model.addAttribute("artisti",this.ListaAutoriService.tutti());
		return "autori.html";
	}
	
	@RequestMapping(value = "/artista/{id}", method = RequestMethod.GET)
    public String getArtista(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("artista", this.ListaAutoriService.personaPerId(id));
    	return "artista.html";
    }

}
