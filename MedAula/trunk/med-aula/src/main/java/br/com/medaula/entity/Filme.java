package br.com.medaula.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.medaula.entity.base.BaseEntityImpl;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="Title")
public class Filme extends BaseEntityImpl<Filme> {

	private static final long serialVersionUID = -90563202302656760L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="Name")
	private String nome;

	@Column(name="duration")
	private String duracao;
	
	@Column(name="language")
	private String lingua;
	
        @Column(name="director")
	private String diretor;

	@Column(name="actors")
	private String atores;
	
	@Column(name="minage")
	private String idademin;
	
        @Column(name="days")
	private String dias;

	@Column(name="hours")
	private String horario;
	
	@Column(name="lastday")
	private String ultimodia;

        @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="local")
	@JsonIgnore
        private Lugar lugar;

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

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getAtores() {
		return atores;
	}

	public void setAtores(String atores) {
		this.atores = atores;
	}
	
        public String getIdademin() {
		return idademin;
	}

	public void setIdademin(String idademin) {
		this.atores = idademin;
	}
        
        public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}
        
        public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
        
        public String getUltimodia() {
		return ultimodia;
	}

	public void setUltimodia(String ultimodia) {
		this.ultimodia = ultimodia;
	}
        
        public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
          
}
