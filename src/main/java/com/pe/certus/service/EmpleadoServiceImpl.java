package com.pe.certus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.certus.entity.Empleado;
import com.pe.certus.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listarEmpleado() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado empleadoId(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public void crearModificarEmpleado(Empleado empleado) {
        Empleado emp = new Empleado();
        emp.setId(empleado.getId());
        emp.setPaterno(empleado.getPaterno());
        emp.setMaterno(empleado.getMaterno());
        emp.setNombre(empleado.getNombre());
        emp.setCorreo(empleado.getCorreo());
        emp.setUsuario(empleado.getUsuario());
        emp.setCiudad(empleado.getCiudad());
        emp.setEspecialidad(empleado.getEspecialidad());

        empleadoRepository.save(emp);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }

}