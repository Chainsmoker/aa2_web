package com.pe.certus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pe.certus.entity.Cliente;
import com.pe.certus.service.ClienteService;

@Controller
@RequestMapping("/")
public class ClienteController {

	private final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping({"/views/cliente", "/views/cliente/"})
	public String listar(Model model) {
		model.addAttribute("clientes", clienteService.listarCliente());
		log.info("Objeto lista Clientes"+ clienteService.listarCliente());
		return "views/cliente/listar";
	}
	
	@GetMapping({"/views/cliente/create", "/views/cliente/create/"})
	public String create() {
		return "views/cliente/create";
	}
	
	@PostMapping("views/cliente/save")
	public String guardar(Cliente cliente, RedirectAttributes attributes) {
		log.info("Create {}", cliente);
		clienteService.crearModificarCliente(cliente);
		return "redirect:/views/cliente";
	}
	
	@GetMapping({"/views/cliente/edit/{id}", "/views/cliente/edit/{id}/"})
	public String editar(@PathVariable Long id, Model model) {
		Cliente cliente = clienteService.clienteId(id);
		log.info("Objeto recuperado: {}", cliente);
		model.addAttribute("cliente", cliente);
		return "views/cliente/edit";
	}
	
	@GetMapping({"/views/cliente/delete/{id}", "/views/cliente/delete/{id}/"})
	public String eliminar(@PathVariable Long id, RedirectAttributes attribute) {
		Cliente cliente = clienteService.clienteId(id);
		log.info("Objeto eliminado: {}", cliente);
		clienteService.eliminarCliente(id);
		return "redirect:/views/cliente";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
