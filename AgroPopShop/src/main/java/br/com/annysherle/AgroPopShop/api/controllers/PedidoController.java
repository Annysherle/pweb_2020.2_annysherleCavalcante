package br.com.annysherle.AgroPopShop.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.annysherle.AgroPopShop.api.models.Pedido;
import br.com.annysherle.AgroPopShop.api.repository.PedidoRepository;

@RestController
@RequestMapping(value = "/ pedido")
public class PedidoController {

	PedidoRepository pedidoRepository;

	public PedidoController(PedidoRepository pedidoRepository) {
		super();
		this.pedidoRepository = pedidoRepository;
	}

	@PostMapping
	public Pedido save(@RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@GetMapping
	public List<Pedido> listaTodos() {
		return pedidoRepository.findAll();
	}

	@PutMapping
	public void update(@RequestBody Pedido pedido) {
		pedidoRepository.save(pedido);
	}

	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		pedidoRepository.deleteById(id);
	}
}