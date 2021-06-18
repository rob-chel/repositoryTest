package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.model.Corso;
import it.uniroma3.siw.spring.service.CorsoService;
import it.uniroma3.siw.spring.validator.CorsoValidator;



@Controller
public class CorsoController {
	
	@Autowired
	private CorsoService corsoService;
	
	@Autowired
    private CorsoValidator corsoValidator;
	
	@RequestMapping(value="/listaCorsi",method = RequestMethod.GET)
	public String informazioni(Model model) {
		model.addAttribute("corsi",this.corsoService.tutti());
		return "corsi.html";
	}
	
	@RequestMapping(value = "/corso/{id}", method = RequestMethod.GET)
    public String getArtista(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("corso", this.corsoService.corsoPerId(id));
    	return "corso.html";
    }
	
	//Operazione per l'aggiunta e la rimozione di un corso tramite form
	
	@RequestMapping(value = "/admin/addCorso", method = RequestMethod.GET)
    public String addOpera(Model model) {
    		model.addAttribute("corso", new Corso());
    		/* Se viene premuto il bottone della sezione, viene restituita la pagina */
    		return "admin/addCorso1";
    }
    
    @RequestMapping(value = "/admin/addCorso", method = RequestMethod.POST)
    public String addCorso(@ModelAttribute("corso") Corso corso, 
    									Model model, BindingResult bindingResult) {
    	this.corsoValidator.validate(corso, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.corsoService.inserisci(corso);
    		/* Se l'inserimento dei dati nella form è corretto, viene mostrata la pagina di successo dell'operazione */
            return "successfulOperation";
        }
		/* Se l'inserimento dei dati non è corretto, viene effettuato un refresh */
        return "admin/addCorso1";
    }
    
//    @RequestMapping(value = "/admin/removeOpera", method = RequestMethod.GET)
//    public String removeOpera(Model model) {
//    		model.addAttribute("opera", new Opera());
//    		/* Se viene premuto il bottone della sezione, viene restituita la pagina */
//    		return "admin/removeOpera";
//    }
//    
//    @RequestMapping(value = "/admin/removeOpera", method = RequestMethod.POST)
//    public String removeOpera(@ModelAttribute("opera") Opera opera,
//    											@RequestParam("opera_id") Long id,
//    									Model model, BindingResult bindingResult) {
//    	opera = operaService.operaPerId(id);
//    	if(operaCanBeRemoved(opera)) {
//    		if (!bindingResult.hasErrors()) {
//            	this.operaService.cancellaPerId(opera);
//        		/* Se l'inserimento dei dati nella form è corretto, viene mostrata la pagina di successo dell'operazione */
//                return "successfulOperation";
//            }
//    	}
//    	
//		/* Se l'inserimento dei dati non è corretto, viene effettuato un refresh */
//        return "admin/removeOpera";
//    }
	

}
