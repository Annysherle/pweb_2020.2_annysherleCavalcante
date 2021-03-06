package br.com.annysherleagropopshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.annysherleagropopshop.model.Cliente;
import br.com.annysherleagropopshop.repository.ClienteRepository;

@Controller
@RequestMapping("/")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepo;
	
	@GetMapping
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/listarClientes")
	public ModelAndView listarClientes() {
		List<Cliente> lista = clienteRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("listarClientes");
		modelAndView.addObject("clientes",lista);
		return modelAndView;
	}
	
	@GetMapping("/adicionarClientes")
	public ModelAndView formAdicionarCliente(){
		ModelAndView modelAndView = new ModelAndView("adicionarClientes");
		modelAndView .addObject(new Cliente());
		return modelAndView ;
	}
	
	@PostMapping("/adicionarClientes")
	public String AdicionarCliente(Cliente c) {
		this.clienteRepo.save(c);
		return "redirect:/listarClientes";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView formEditarCliente(@PathVariable("id") long id) {
		Cliente cliente = clienteRepo.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
		ModelAndView modelAndView = new ModelAndView("editarCliente");
		modelAndView.addObject(cliente);
		return modelAndView;
	}
	
	@PostMapping("/editar/{id}")
	public ModelAndView editarCliente(@PathVariable("id") long id, Cliente cliente) {
		this.clienteRepo.save(cliente);
		return new ModelAndView("redirect:/listarClientes");
	}
	
	@GetMapping("/remover/{id}")
	public ModelAndView removerCliente(@PathVariable("id") long id) {
		Cliente aRemover = clienteRepo.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
		clienteRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarClientes");
	}
}


