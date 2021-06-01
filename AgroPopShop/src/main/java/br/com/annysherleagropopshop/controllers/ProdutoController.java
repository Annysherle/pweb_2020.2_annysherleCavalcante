package br.com.annysherleagropopshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.annysherleagropopshop.model.Produto;
import br.com.annysherleagropopshop.repository.ProdutoRepository;



@Controller
@RequestMapping
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
		ModelAndView mav = new ModelAndView("adicionarProdutos");
		mav.addObject(new Produto());
		return mav ;
	}
	
	@PostMapping("/adicionarProdutos")
	public String AdicionarProduto(Produto p) {
		 this.produtoRepo.save(p);
		return "redirect:/listarProdutos";
	}
	
	@GetMapping("/editarProduto/{id}")
	public ModelAndView formEditarproduto(@PathVariable("id") long id) {
		
		Produto produto =  produtoRepo.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("ID invalido" + id));
		ModelAndView modelAndView = new ModelAndView("editarProduto");
		modelAndView.addObject(produto);
		return modelAndView;
	}
	
	@PostMapping("/editarProduto/{id}")
	public ModelAndView editarProduto(@PathVariable("id") long id, Produto produto) {
		this.produtoRepo.save(produto);
		return new ModelAndView("redirect:/listarProdutos");
	}
	
    
	@GetMapping("/removerProduto/{id}")
	public ModelAndView removerProduto(@PathVariable("id") long id) {
		Produto aRemover =  produtoRepo.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("ID invalido" + id));
		produtoRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarProdutos");
	}
	
}