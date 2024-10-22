package com.pe.certus.service;

import java.util.List;
import com.pe.certus.entity.Empleado;

public interface EmpleadoService {

	public List<Empleado> listarEmpleado();
	public Empleado empleadoId(Long id);
	public void crearModificarEmpleado(Empleado empleado);
	public void eliminarEmpleado(Long id);
}
