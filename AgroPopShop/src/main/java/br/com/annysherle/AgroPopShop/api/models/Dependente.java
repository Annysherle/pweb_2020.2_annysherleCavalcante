package br.com.annysherle.agropopshop.api.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = " tb_dependentes")
public class Dependente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomedependentes;
	private String endereço;
	private String telefone;
	private String gênero;
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	public Dependente(Long id, String nomedependentes, String endereço, String telefone, String gênero,
			LocalDate dataNascimento) {
		super();
		this.id = id;
		this.nomedependentes = nomedependentes;
		this.endereço = endereço;
		this.telefone = telefone;
		this.gênero = gênero;
		this.dataNascimento = dataNascimento;

	}

	public Dependente() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeDependentes() {
		return getNomeDependentes();
	}

	public void setNomeDependentes(String nomedependentes) {
		this.setNomedependentes(nomedependentes);
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String gettelefone() {
		return telefone;
	}

	public void setGenero(String telefone) {
		this.telefone = telefone;
	}

	public String getGênero() {
		return gênero;
	}

	public void setGênero(String gênero) {
		this.gênero = gênero;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomedependentes() {
		return nomedependentes;
	}

	public void setNomedependentes(String nomedependentes) {
		this.nomedependentes = nomedependentes;
	}

}
