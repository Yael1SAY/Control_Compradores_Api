package com.truper.spring.controller;

import com.truper.spring.model.Comprador;
import com.truper.spring.service.CompradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("comprador")
public class ControllerComprador {

    private static final Logger LOG = Logger.getLogger(ControllerComprador.class.getName());

    @Autowired
    CompradorService compradorService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Comprador> obtenerCompradores(){
        List<Comprador> comprador = compradorService.obtenerCompradores();
        LOG.info("compradores; " + comprador);
        return comprador;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "usuario/{claveComprador}", method = RequestMethod.GET)
    Comprador obtenerUsuario(@PathVariable String claveComprador){
        Comprador comprador = compradorService.obtenerUsuario(claveComprador);
        LOG.info("compradores; " + comprador);
        return comprador;
    }

    @Secured({"ROLE_ADMIN", })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Comprador obtenerCompradorId(@PathVariable long id){
        return compradorService.obtenerCompradorId(id);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Comprador registrarComprador(@RequestBody Comprador comprador){
        return compradorService.registrarComprador(comprador);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Comprador actualizarComprador(@RequestBody Comprador comprador){
        return compradorService.actualizarComprador(comprador);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
    void eliminarComprador(@PathVariable long id){
        compradorService.eliminarComprador(id);
    }

}
