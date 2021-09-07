package com.truper.spring.dao.impl;

import com.truper.spring.dao.ICompradorDao;
import com.truper.spring.model.Comprador;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Transactional
@Repository
public class CompradorDaoImpl implements ICompradorDao {

    private static final Logger LOG = Logger.getLogger(CompradorDaoImpl.class.getName());

    @PersistenceContext //Se encarga de administrar las entidades y las transacciones
    EntityManager entityManager;

    @Transactional
    @Override
    public List<Comprador> obtenerCompradores() {
        final String LISTAR_COMPRADORES = "From Comprador c where c.estatus = true";
        return entityManager.createQuery(LISTAR_COMPRADORES,Comprador.class).getResultList();
    }

    @Override
    public Comprador obtenerCompradorId(long id) {
        return entityManager.find(Comprador.class, id);
    }

    @Override
    public Comprador registrarComprador(Comprador comprador) {
        comprador.setEstatus(true);
        entityManager.merge(comprador);
        return comprador;
    }

    @Override
    public Comprador actualizarComprador(Comprador comprador) {
        entityManager.merge(comprador);
        return comprador;
    }

    @Override
    public void eliminarComprador(long id) {
        final String DELETE_COMPRADOR = "UPDATE Comprador c SET c.estatus = false where c.idComprador = :id";
        entityManager.createQuery(DELETE_COMPRADOR).setParameter("id", id).executeUpdate();
    }
}
