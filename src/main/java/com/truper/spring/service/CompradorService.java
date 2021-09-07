package com.truper.spring.service;

import com.truper.spring.dao.ICompradorDao;
import com.truper.spring.model.Comprador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CompradorService {

    private static final Logger LOG = Logger.getLogger(CompradorService.class.getName());

    @Autowired
    ICompradorDao direccionDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Comprador> obtenerCompradores(){
        List<Comprador> list = direccionDao.obtenerCompradores();
        return list;
    }

    public Comprador obtenerCompradorId(long id){
        Comprador comprador = direccionDao.obtenerCompradorId(id);
        if (comprador.isEstatus()){
            return null;
        }
        return comprador;
    }

    public Comprador registrarComprador(Comprador comprador){
        comprador.setPassword(passwordEncoder.encode(comprador.getPassword()));
        Comprador compradorNew = direccionDao.registrarComprador(comprador);
        return compradorNew;
    }

    public Comprador actualizarComprador(Comprador comprador){
        Comprador compradorNew = direccionDao.actualizarComprador(comprador);
        return compradorNew;
    }

    public void eliminarComprador(long id){
        direccionDao.eliminarComprador(id);
    }

}
