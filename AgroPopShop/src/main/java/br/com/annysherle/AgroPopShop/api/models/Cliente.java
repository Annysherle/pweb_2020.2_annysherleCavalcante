package br.com.annysherle.agropopshop.api.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = " tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String endereço;
	private String telefone;
	private String gênero;
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Dependente> dependentes;

	public Cliente(Long id, String nome, String endereço, String telefone, String gênero, LocalDate dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereço = endereço;
		this.telefone = telefone;
		this.gênero = gênero;
		this.dataNascimento = dataNascimento;

	}

	public Cliente() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

}
