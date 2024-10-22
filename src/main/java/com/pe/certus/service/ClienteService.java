package com.pe.certus.service;

import java.util.List;
import com.pe.certus.entity.Cliente;

public interface ClienteService {

	public List<Cliente> listarCliente();
	public Cliente clienteId(Long id);
	public void crearModificarCliente(Cliente cliente);
	public void eliminarCliente(Long id);
}
