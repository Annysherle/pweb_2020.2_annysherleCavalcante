package br.com.annysherle.agropopshop.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.annysherle.agropopshop.api.models.Dependente;
import br.com.annysherle.agropopshop.api.repository.DependentesRepository;

@RestController
@RequestMapping(value = "/dependentes")
public class DependentesController {

	@Autowired
	DependentesRepository dependenteRepo;

	@GetMapping
	public String index() {
		return "index.html";
	}

	@GetMapping("/listarDependentes")
	public ModelAndView listarDependente() {
		List<Dependente> lista = dependenteRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("listarDependentes");
		modelAndView.addObject("dependentes", lista);
		return modelAndView;
	}

	@GetMapping("/adicionarDependente")
	public ModelAndView formAdicionarDependente() {
		ModelAndView modelAndView = new ModelAndView("adicionarDependente");
		modelAndView.addObject(new Dependente(null, null, null, null, null, null));
		return modelAndView;
	}

	@PostMapping("/adicionarDependente")
	public String AdicionarDependentes(Dependente d) {
		this.dependenteRepo.save(d);
		return "redirect:/listarDependentes";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView formEditarDependentes(@PathVariable("id") long id) {
		Dependente dependente = dependenteRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
		ModelAndView modelAndView = new ModelAndView("editarDependentes");
		modelAndView.addObject(dependente);
		return modelAndView;
	}

	@PostMapping("/editar/{id}")
	public ModelAndView editarDependentes(@PathVariable("id") long id, Dependente dependente) {
		this.dependenteRepo.save(dependente);
		return new ModelAndView("redirect:/listarDependentes");
	}

	@GetMapping("/remover/{id}")
	public ModelAndView removerDependentes(@PathVariable("id") long id) {
		Dependente aRemover = dependenteRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
		dependenteRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarDependentes");
	}
}
