package it.uniroma3.siw.spring.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Collezione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	private String descrizione;
	@ManyToOne
	private Curatore curatore;
	@OneToMany(mappedBy = "collezione")
	private List<Opera> opere;
	
	public Collezione(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
		
	}
	public Collezione() {
		this.opere = new ArrayList<>();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Curatore getCuratore() {
		return curatore;
	}
	public void setCuratore(Curatore curatore) {
		this.curatore = curatore;
	}
	public List<Opera> getOpere() {
		return opere;
	}
	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Collezione [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", curatore=" + curatore
				+ ", opere=" + opere + "]";
	}
	
	
	
	

}