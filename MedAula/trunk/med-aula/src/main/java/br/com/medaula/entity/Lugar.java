package br.com.medaula.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.medaula.entity.base.BaseEntityImpl;
import java.util.List;
import javax.persistence.OneToMany;

@Entity
@Table(name="Theatre")
public class Lugar extends BaseEntityImpl<Lugar> {

	private static final long serialVersionUID = -90563202302656760L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="city")
	private String cidade;

	@Column(name="adress")
	private String endereco;
	
        @OneToMany(mappedBy = "lugar")
        private List<Filme> filmes;
        
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
        public List<Filme> getFilme(){
		return filmes;
	}

	public void setFilme(List<Filme> filmes) {
		this.filmes = filmes;
	}
}
