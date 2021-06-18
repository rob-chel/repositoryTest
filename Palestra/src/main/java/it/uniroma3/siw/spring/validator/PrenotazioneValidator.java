package it.uniroma3.siw.spring.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.service.PrenotazioneService;

@Component
public class PrenotazioneValidator implements Validator{
	
	@Autowired
	private PrenotazioneService prenService;

	@Override
	public boolean supports(Class<?> aClass) {
		
		return Prenotazione.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeCliente", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognomeCliente", "required");

		if (!errors.hasErrors()) {
			
			if (this.prenService.alreadyExists((Prenotazione)o)) {
				
				errors.reject("duplicato");
			}
		}
		
	}

}
