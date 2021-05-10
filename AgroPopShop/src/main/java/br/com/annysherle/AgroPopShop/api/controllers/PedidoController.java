package br.com.annysherle.AgroPopShop.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.annysherle.AgroPopShop.api.models.Pedido;
import br.com.annysherle.AgroPopShop.api.repository.PedidoRepository;
/*
@RestController
@RequestMapping("/")
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepo;

	@GetMapping
	public String index() {
		return "index.html";
	}

	@GetMapping("/listarPedido")
	public ModelAndView listarPedido() {
		List<Pedido> lista = pedidoRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("listarPedidos");
		modelAndView.addObject("pedidos", lista);
		return modelAndView;
	}

	@GetMapping("/adicionarPedido")
	public ModelAndView formAdicionarPedido() {
		ModelAndView modelAndView = new ModelAndView("adicionarPedido");
		modelAndView.addObject(new Pedido());
		return modelAndView;
	}

	@PostMapping("/adicionarPedido")
	public String AdicionarProduto(Pedido p) {
		this.pedidoRepo.save(p);
		return "redirect:/listarPedidos";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView formEditarPedido(@PathVariable("id") long id) {
		Pedido pedido = pedidoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
		ModelAndView modelAndView = new ModelAndView("editarPedido");
		modelAndView.addObject(pedido);
		return modelAndView;
	}

	@PostMapping("/editar/{id}")
	public ModelAndView editarPedido(@PathVariable("id") long id, Pedido pedido) {
		this.pedidoRepo.save(pedido);
		return new ModelAndView("redirect:/listarPedidos");
	}

	@GetMapping("/remover/{id}")
	public ModelAndView removerProduto(@PathVariable("id") long id) {
		Pedido aRemover = pedidoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
		pedidoRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarPedidos");
	}
}
*/