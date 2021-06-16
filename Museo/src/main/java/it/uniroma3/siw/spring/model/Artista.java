package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Artista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	private String biografia;
	private LocalDate dataNascita;
	private String luogoNascita;
	private LocalDate dataMorte;
	private String luogoMorte;
	private String nazionalita;
	@OneToMany(mappedBy = "artista")
	private List<Opera> listaOpere;
	
	public Artista(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		
	}
	
	public Artista() {
		this.listaOpere = new ArrayList<>();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public LocalDate getDataMorte() {
		return dataMorte;
	}
	public void setDataMorte(LocalDate dataMorte) {
		this.dataMorte = dataMorte;
	}
	public String getLuogoMorte() {
		return luogoMorte;
	}
	public void setLuogoMorte(String luogoMorte) {
		this.luogoMorte = luogoMorte;
	}
	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	public List<Opera> getListaOpere() {
		return listaOpere;
	}
	public void setListaOpere(List<Opera> listaOpere) {
		this.listaOpere = listaOpere;
	}
	
	public String getBiografia() {
		return biografia;
	}
	
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	@Override
	public String toString() {
		return "Artista [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", luogoNascita=" + luogoNascita + ", dataMorte=" + dataMorte + ", luogoMorte=" + luogoMorte
				+ ", nazionalita=" + nazionalita + ", listaOpere=" + listaOpere + "]";
	}
}