package com.truper.spring.service;

import com.truper.spring.dao.IServicioCompradorDao;
import com.truper.spring.model.ServicioComprador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ServicioCompradorService {

    private static final Logger LOG = Logger.getLogger(ServicioCompradorService.class.getName());

    @Autowired
    IServicioCompradorDao servicioCompradorDao;

    public List<ServicioComprador> obtenerServiciosComprador(String clave){
        return servicioCompradorDao.obtenerServiciosComprador(clave);
    }

    public List<ServicioComprador> obtenerServicios(){
        return servicioCompradorDao.obtenerServicios();
    }

    public List<ServicioComprador> obtenerServiciosCompradorAño(String clave, String anio){
        return servicioCompradorDao.obtenerServiciosCompradorAño(clave, anio);
    }

    public ServicioComprador obtenerServicioId(long id){
        return servicioCompradorDao.obtenerServicioId(id);
    }

    public ServicioComprador registrarServicio(ServicioComprador servicio){
        return servicioCompradorDao.registrarServicio(servicio);
    }

    public void eliminarServicio(long id){
        servicioCompradorDao.eliminarServicio(id);
    }

    public boolean validarAnioServicio(long id, String anio, String mes){
        return servicioCompradorDao.validarAnioServicio(id, anio, mes);
    }
}
