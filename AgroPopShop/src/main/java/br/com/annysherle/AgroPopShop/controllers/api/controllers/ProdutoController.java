package br.com.annysherle.agropopshop.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.annysherle.agropopshop.api.models.Produto;
import br.com.annysherle.agropopshop.api.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepo;
	
	@GetMapping
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/listarProdutos")
	public ModelAndView listarCliente() {
		List<Produto> lista = produtoRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("listarProdutos");
		modelAndView.addObject("produtos",lista);
		return modelAndView;
	}
	
	@GetMapping("/adicionarProduto")
	public ModelAndView formAdicionarProduto(){
		ModelAndView modelAndView = new ModelAndView("adicionarProduto");
		modelAndView .addObject(new Produto());
		return modelAndView ;
	}
	
	@PostMapping("/adicionarProduto")
	public String AdicionarProduto(Produto p) {
		this.produtoRepo.save(p);
		return "redirect:/listarProdutos";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView formEditarProduto(@PathVariable("id") long id) {
		Produto produto = produtoRepo.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
		ModelAndView modelAndView = new ModelAndView("editarProduto");
		modelAndView.addObject(produto);
		return modelAndView;
	}
	
	@PostMapping("/editar/{id}")
	public ModelAndView editarProduto(@PathVariable("id") long id, Produto produto) {
		this.produtoRepo.save(produto);
		return new ModelAndView("redirect:/listarProdutos");
	}
	
	@GetMapping("/remover/{id}")
	public ModelAndView removerProduto(@PathVariable("id") long id) {
		Produto aRemover = produtoRepo.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
		produtoRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarProdutos");
	}
}


