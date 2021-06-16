package it.uniroma3.siw.spring.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.model.Opera;

import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.service.ArtistaService;
import it.uniroma3.siw.spring.service.CollezioneService;
import it.uniroma3.siw.spring.service.OperaService;
import it.uniroma3.siw.spring.service.PrenotazioneService;
import it.uniroma3.siw.spring.validator.OperaValidator;

@Controller
public class AdminController {
	
	@Autowired
	private OperaValidator operaValidator;

	@Autowired
	private OperaService operaService;

	@Autowired
	private PrenotazioneService prenService;

	@Autowired
	private CollezioneService collezioneService;
	
	@Autowired
	private ArtistaService artistaService;

	//metodi per inserire un'opera in una collezione
	@RequestMapping(value="/aggiungiOperaCollezione",method = RequestMethod.GET)
	public String addOperaScegliCollezione(Model model) {
		model.addAttribute("collezioni",this.collezioneService.tutti());
		return "admin/collezioniAdminAggiungi.html";
	}

	@RequestMapping(value="/collezioneAdminAggiungi/{id}",method = RequestMethod.GET)
	public String aggiungiOpera(@PathVariable("id") Long id, Model model) {
		Collezione collezione = this.collezioneService.collezionePerId(id);
		Opera opera = new Opera();
		opera.setCollezione(collezione);
		model.addAttribute("opera", opera);
		model.addAttribute("collezione",collezione);
        return "admin/aggiungiOperaInCollezioneForm.html";
	}

	@RequestMapping(value = "/operaXXX", method = RequestMethod.POST)
	public String aggiungiOperaAllaForm(@ModelAttribute("collezione") Collezione collezione, @ModelAttribute("opera") Opera opera, 
			Model model) {
		if(this.artistaService.alreadyExists(opera.getArtista())) {
			opera.setArtista(opera.getArtista());
		}else {
			Artista artista = new Artista(opera.getArtista().getNome(),opera.getArtista().getCognome());
			this.artistaService.inserisci(artista);
			opera.setArtista(artista);
	    }
		this.operaService.inserisci(opera);
		model.addAttribute("collezioni", this.collezioneService.tutti());
		return "admin/collezioniAdminAggiungi.html";
	}



	//Metodo per la rimozione di un'opera
	@RequestMapping(value="/rimuoviOperaCollezione",method = RequestMethod.GET)
	public String scegliCollezione(Model model) {
		model.addAttribute("collezioni",this.collezioneService.tutti());
		return "admin/collezioniAdmin.html";
	}

	@RequestMapping(value = "/collezioneAdmin/{id}", method = RequestMethod.GET)
	public String getCollezione(@PathVariable("id") Long id, Model model) {
		model.addAttribute("collezione", this.collezioneService.collezionePerId(id));
		return "admin/collezioneAdmin.html";
	}

	@RequestMapping(value = "/rimuovi/{id}", method = RequestMethod.GET)
	public String rimuoviOpera(@PathVariable("id") Long id, Model model) {
		Opera opera = this.operaService.operaPerId(id);
		this.operaService.cancella(opera);
		model.addAttribute("collezione", this.collezioneService.collezionePerId(id));
		return "admin/collezioneAdmin.html";
	}

	//metodo che riporta l'elenco delle prenotazioni
	@RequestMapping(value="/elencoPrenotazioni",method = RequestMethod.GET)
	public String elencoPrenotazioni(Model model) {
		model.addAttribute("prenotazioni",prenService.tutti());
		return "prenotazioni.html";
	}





}
