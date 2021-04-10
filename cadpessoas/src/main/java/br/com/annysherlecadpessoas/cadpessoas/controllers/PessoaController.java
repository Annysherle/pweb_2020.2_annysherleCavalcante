package br.com.annysherlecadpessoas.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.annysherlecadpessoas.cadpessoas.model.Pessoa;
import br.com.annysherlecadpessoas.cadpessoas.repository.PessoaRepository;

@Controller
@RequestMapping("/")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRep;

	@GetMapping
	public String index() {
		return "index.html";
	}

	@GetMapping("listarPessoas")
	public ModelAndView listarPessoa() {
		List<Pessoa> lista = pessoaRep.findAll();
		ModelAndView mav = new ModelAndView("listarPessoas");
		mav.addObject("pessoas", lista);
		return mav;
	}
}
