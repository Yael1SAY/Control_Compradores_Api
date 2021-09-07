package com.truper.spring.controller;

import com.truper.spring.model.ServicioComprador;
import com.truper.spring.service.ServicioCompradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("servicio")
public class ControllerServicioComprador {

    private static final Logger LOG = Logger.getLogger(ControllerServicioComprador.class.getName());

    @Autowired
    ServicioCompradorService servicioComprador;


    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/{clave}", method = RequestMethod.GET)
    List<ServicioComprador> obtenerServiciosComprador(@PathVariable String clave){
        return servicioComprador.obtenerServiciosComprador(clave);
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<ServicioComprador> obtenerServicios(){
        return servicioComprador.obtenerServicios();
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/{clave}/{anio}", method = RequestMethod.GET)
    List<ServicioComprador> obtenerServiciosCompradorAño(@PathVariable String clave, @PathVariable String anio){
        return servicioComprador.obtenerServiciosCompradorAño(clave, anio);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> registrarServicio(@RequestBody ServicioComprador servicio){
        Map<String,Object> response = new HashMap<>();
        boolean valido = servicioComprador.validarAnioServicio(servicio.getComprador().getIdComprador(), servicio.getAnio(), servicio.getMes());
        if (valido) {
            servicioComprador.registrarServicio(servicio);
            response.put("mensaje", "El servicio se insetro con exito");
            return new ResponseEntity<Map>(response, HttpStatus.OK);
        }
        response.put("error", "Ya se encuentra registrado el mes de " + servicio.getMes() + " del año " + servicio.getAnio());
        return new ResponseEntity<Map>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<?> eliminarServicio(@PathVariable long id){
        Map<String,Object> response = new HashMap<>();
        ServicioComprador servicio = servicioComprador.obtenerServicioId(id);
        if (servicio != null){
            if (servicio.isEstatus()) {
                servicioComprador.eliminarServicio(id);
                response.put("mensaje", "El servicio con id: " + id + " se elimino con exito");
                return new ResponseEntity<Map>(response, HttpStatus.OK);
            } else {
                response.put("error", "El servicio con id: " + id + " ya se encuentra en estado eliminado");
                return new ResponseEntity<Map>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else {
            response.put("error", "El servicio con id: " + id + " no existe en la base de datos");
            return new ResponseEntity<Map>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
