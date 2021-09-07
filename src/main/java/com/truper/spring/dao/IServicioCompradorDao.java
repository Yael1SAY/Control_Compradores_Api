package com.truper.spring.dao;

import com.truper.spring.model.ServicioComprador;

import java.util.List;

public interface IServicioCompradorDao {

    List<ServicioComprador> obtenerServiciosComprador(String clave);

    List<ServicioComprador> obtenerServiciosCompradorAño(String clave, String anio);

    List<ServicioComprador> obtenerServicios();

    ServicioComprador obtenerServicioId(long id);

    ServicioComprador registrarServicio(ServicioComprador servicio);

    ServicioComprador actualizarServicio(ServicioComprador servicio);

    void eliminarServicio(long id);

    boolean validarAnioServicio(long id, String anio, String mes);
}
