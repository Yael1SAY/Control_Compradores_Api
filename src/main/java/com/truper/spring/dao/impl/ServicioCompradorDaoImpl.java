package com.truper.spring.dao.impl;

import com.truper.spring.dao.IServicioCompradorDao;
import com.truper.spring.model.ServicioComprador;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Transactional
@Repository
public class ServicioCompradorDaoImpl implements IServicioCompradorDao {

    private static final Logger LOG = Logger.getLogger(CompradorDaoImpl.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ServicioComprador> obtenerServiciosComprador(String clave){
        final String LISTAR_SERVICIO_COMPRADOR = "SELECT s From ServicioComprador s INNER JOIN s.Comprador c where c.clave = :clave AND s.estatus = true";
        return entityManager.createQuery(LISTAR_SERVICIO_COMPRADOR, ServicioComprador.class).setParameter("clave", clave).getResultList();
    }

    /*
    * Obtiene los registros de servicio de un comprador por año.
    * se requiere la clave del comprador y el año que se desea mostrar los registros
    */
    @Override
    public List<ServicioComprador> obtenerServiciosCompradorAño(String clave, String anio) {
        final String LISTAR_SERVICIO_COMPRADOR = "SELECT s From ServicioComprador s INNER JOIN s.Comprador c where c.clave = :clave AND s.anio = :anio AND s.estatus = true";
        return entityManager.createQuery(LISTAR_SERVICIO_COMPRADOR, ServicioComprador.class)
                .setParameter("clave", clave)
                .setParameter("anio", anio)
                .getResultList();
    }

    @Override
    public List<ServicioComprador> obtenerServicios(){
        final String LISTAR_SERVICIOS = "FROM ServicioComprador s";
        return entityManager.createQuery(LISTAR_SERVICIOS, ServicioComprador.class).getResultList();
    }

    @Override
    public ServicioComprador obtenerServicioId(long id){
        ServicioComprador servicio = entityManager.find(ServicioComprador.class, id);
        return servicio;
    }

    @Override
    public ServicioComprador registrarServicio(ServicioComprador servicio){
        servicio.setEstatus(true);
        entityManager.merge(servicio);
        return servicio;
    }

    @Override
    public ServicioComprador actualizarServicio(ServicioComprador servicio){
        entityManager.merge(servicio);
        return servicio;
    }

    @Override
    public void eliminarServicio(long id){
        final String DELETE_SERVICIO = "UPDATE ServicioComprador s SET s.estatus = false where s.idServicio = :id";
        entityManager.createQuery(DELETE_SERVICIO).setParameter("id", id).executeUpdate();
    }

    /*
    * Valida si un periodo (mes año) de un comprador  ya se encuentra registrado en la base de datos
    * Si la consulta retorna un valor significa que ya se encuentra en la base de datos y retorna un false
    * de lo contrario retorna un true
    * */
    @Override
    public boolean validarAnioServicio(long id, String anio, String mes){
        boolean insertar;
        LOG.info("id: " + id +" anio: " + anio + " mes " + mes);
        final String VALIDA_ANIO = "SELECT s From ServicioComprador s INNER JOIN s.Comprador c where c.idComprador = :id AND s.anio = :anio AND s.mes = :mes AND s.estatus = true";
            List<ServicioComprador> servicio = entityManager.createQuery(VALIDA_ANIO, ServicioComprador.class)
                    .setParameter("id", id)
                    .setParameter("anio", anio)
                    .setParameter("mes", mes)
                    .getResultList();
        LOG.info("servicio resultado: " + servicio);
            if (servicio.isEmpty()) {
                LOG.info("no existe servicio es posible insertar ");
                insertar = true;
            }else {
                LOG.info("ya existe servicio no es posible insertar");
                insertar = false;
            }
            return insertar;
        }
}
