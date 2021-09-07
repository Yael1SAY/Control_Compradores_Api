package com.truper.spring.dao;

import com.truper.spring.model.Comprador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompradorAuthDao extends CrudRepository<Comprador, Long> {

    @Query("select c from Comprador c where c.clave = ?1")
    public Comprador findByUsername2(String clave);

}
