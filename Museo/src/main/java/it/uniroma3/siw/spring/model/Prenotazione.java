package it.uniroma3.siw.spring.model;



import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String orario;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate data;
	private String nomeVisitatore;
	private String cognomeVisitatore;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public String getNomeVisitatore() {
		return nomeVisitatore;
	}
	
	public void setNomeVisitatore(String nomeVisitatore) {
		this.nomeVisitatore = nomeVisitatore;
	}
	public String getCognomeVisitatore() {
		return cognomeVisitatore;
	}
	
	public void setCognomeVisitatore(String cognomeVisitatore) {
		this.cognomeVisitatore = cognomeVisitatore;
	}
	
	

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Prenotazione [orario=" + orario + ", data=" + data + ", nomeVisitatore=" + nomeVisitatore
				+ ", cognomeVisitatore=" + cognomeVisitatore + "]";
	}

	
	
	
	
	
	

}
