package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(uniqueConstraints=@UniqueConstraint (columnNames={"matricola"}))
public class Curatore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long matricola;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String luogoNascita;
	private String email;
	private String telefono;
	@OneToMany(mappedBy = "curatore", cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	private List<Collezione> collezione;
	
	public Curatore(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		
	}
	
	public Curatore() {
		this.collezione = new ArrayList<>();
	}
    
	public Long getMatricola() {
		return matricola;
	}

	public void setMatricola(Long matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Collezione> getCollezione() {
		return collezione;
	}

	public void setCollezione(List<Collezione> collezione) {
		this.collezione = collezione;
	}

	@Override
	public String toString() {
		return "Curatore [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + ", luogoNascita=" + luogoNascita + ", email=" + email + ", telefono=" + telefono
				+ ", collezione=" + collezione + "]";
	}
	
	
	

}

