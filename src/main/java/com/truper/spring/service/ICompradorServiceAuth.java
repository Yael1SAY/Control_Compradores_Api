package com.truper.spring.service;

import com.truper.spring.model.Comprador;
import org.springframework.data.jpa.repository.Query;

public interface ICompradorServiceAuth {

    @Query("select c from Comprador2 c where c.clave = ?1")
    public Comprador findByUsername2(String clave);

}
