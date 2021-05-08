package br.com.annysherle.agropopshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public Cliente(Long id, String nome, String endereço, String telefone, String gênero) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereço = endereço;
		this.telefone = telefone;
		this.gênero = gênero;

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

	
}
