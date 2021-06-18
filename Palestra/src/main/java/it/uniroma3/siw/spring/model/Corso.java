package it.uniroma3.siw.spring.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Corso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@OneToOne(mappedBy = "corso")
	private Istruttore istruttore;
	private String orario;
	private String foto;
	private String descrizione;
	@OneToOne
	private Sala sala;
	
	
	
	public Corso(String nome) {
		this.nome = nome;
		
	}
	
	public Corso() {}
	
	
	
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Istruttore getIstruttore() {
		return istruttore;
	}
	public void setIstruttore(Istruttore istruttore) {
		this.istruttore = istruttore;
	}
	public String getOrario() {
		return orario;
	}
	public void setOrario(String orario) {
		this.orario = orario;
	}
	
	
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}


}
