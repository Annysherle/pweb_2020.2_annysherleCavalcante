package br.com.annysherle.agropopshop.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.annysherle.agropopshop.api.models.Produto;
import br.com.annysherle.agropopshop.api.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

	ProdutoRepository produtoRepository;

	public ProdutoController(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}

	@PostMapping
	public Produto save(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@GetMapping
	public List<Produto> listaTodos() {
		return produtoRepository.findAll();
	}

	@PutMapping
	public Produto update(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}
}
