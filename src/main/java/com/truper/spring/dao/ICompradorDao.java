package com.truper.spring.dao;

import com.truper.spring.model.Comprador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICompradorDao {

    List<Comprador> obtenerCompradores();

    Comprador obtenerUsuario(String claveComprador);

    Comprador obtenerCompradorId(long id);

    Comprador registrarComprador(Comprador comprador);

    Comprador actualizarComprador(Comprador comprador);

    void eliminarComprador(long id);


}
