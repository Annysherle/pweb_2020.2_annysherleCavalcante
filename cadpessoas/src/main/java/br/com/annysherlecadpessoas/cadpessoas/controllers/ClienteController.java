package br.com.annysherlecadpessoas.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.annysherlecadpessoas.cadpessoas.model.Cliente;
import br.com.annysherlecadpessoas.cadpessoas.repository.ClienteRepository;

@Controller
@RequestMapping("/")
public class ClienteController {

	@Autowired
	ClienteRepository pessoaRepo;
	
	@GetMapping
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/listarPessoas")
	public ModelAndView listarPessoas() {
		List<Cliente> lista = pessoaRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("listarPessoas");
		modelAndView.addObject("pessoas",lista);
		return modelAndView;
	}
	
	@GetMapping("/adicionarPessoa")
	public ModelAndView formAdicionarPessoa(){
		ModelAndView modelAndView = new ModelAndView("adicionarPessoa");
		modelAndView .addObject(new Cliente());
		return modelAndView ;
	}
	
	@PostMapping("/adicionarPessoa")
	public String AdicionarPessoa(Cliente p) {
		this.pessoaRepo.save(p);
		return "redirect:/listarPessoas";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView formEditarPessoa(@PathVariable("id") long id) {
		Cliente pessoa = pessoaRepo.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
		ModelAndView modelAndView = new ModelAndView("editarPessoa");
		modelAndView.addObject(pessoa);
		return modelAndView;
	}
	
	@PostMapping("/editar/{id}")
	public ModelAndView editarPessoa(@PathVariable("id") long id, Cliente pessoa) {
		this.pessoaRepo.save(pessoa);
		return new ModelAndView("redirect:/listarPessoas");
	}
	
	@GetMapping("/remover/{id}")
	public ModelAndView removerPessoa(@PathVariable("id") long id) {
		Cliente aRemover = pessoaRepo.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
		pessoaRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarPessoas");
	}
}

