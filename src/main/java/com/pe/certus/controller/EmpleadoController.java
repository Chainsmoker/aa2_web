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

import com.pe.certus.entity.Empleado;
import com.pe.certus.service.EmpleadoService;

@Controller
@RequestMapping("/")
public class EmpleadoController {

	private final Logger log = LoggerFactory.getLogger(ClienteController.class);

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping({"/views/empleados", "/views/empleados/"})
	public String listar(Model model) {
		model.addAttribute("empleados", empleadoService.listarEmpleado());
		log.info("Objeto lista Empleados"+ empleadoService.listarEmpleado());
		return "views/empleado/listar";
	}

	@GetMapping({"/views/empleados/create", "/views/empleados/create/"})
	public String create() {
		return "views/empleado/create";
	}

	@PostMapping("views/empleados/save")
	public String guardar(Empleado empleado, RedirectAttributes attributes) {
		log.info("Create {}", empleado);
		empleadoService.crearModificarEmpleado(empleado);
		return "redirect:/views/empleados";
	}

	@GetMapping({"/views/empleados/edit/{id}", "/views/empleados/edit/{id}/"})
	public String editar(@PathVariable Long id, Model model) {
		Empleado empleado = empleadoService.empleadoId(id);
		log.info("Objeto recuperado: {}", empleado);
		model.addAttribute("empleado", empleado);
		return "views/empleado/edit";
	}

	@GetMapping({"/views/empleados/delete/{id}", "/views/empleados/delete/{id}/"})
	public String eliminar(@PathVariable Long id, RedirectAttributes attribute) {
		Empleado empleado = empleadoService.empleadoId(id);
		log.info("Objeto eliminado: {}", empleado);
		empleadoService.eliminarEmpleado(id);
		return "redirect:/views/empleados";
	}
















}
