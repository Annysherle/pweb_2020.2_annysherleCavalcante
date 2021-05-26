package br.com.annysherle.AgroPopShop.api.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.annysherle.AgroPopShop.api.models.Produto;
import br.com.annysherle.AgroPopShop.api.repository.ProdutoRepository;

@Controller
@RequestMapping("/")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepo;
	
	@GetMapping("/listarProdutos")
	public ModelAndView listarProdutos() {
		List<Produto> lista = produtoRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("listarProdutos");
		modelAndView.addObject("produtos",lista);
		return modelAndView;
	}
	
	@GetMapping("/adicionarProdutos")
	public ModelAndView formAdicionarProduto(){
		ModelAndView modelAndView = new ModelAndView("adicionarProdutos");
		modelAndView .addObject(new Produto());
		return modelAndView ;
	}
	
	@PostMapping("/adicionarProdutos")
	public String AdicionarProduto(Produto p) {
		this.produtoRepo.save(p);
		return "redirect:/listarProdutos";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView formEditarCliente(@PathVariable("id") long id) {
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


