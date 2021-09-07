package com.truper.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "servicio_comprador")
public @Data class ServicioComprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private long idServicio;

    @Column(nullable = false)
    private String mes;

    @Column(nullable = false)
    private String anio;

    @Column(name = "solicitud_pedido", nullable = false)
    private int solicituPedido;

    @Column(name = "orden_compra", nullable = false)
    private int ordenCompra;

    @Column(name = "dias_sp", nullable = false)
    private int diasSP;

    @Column(name = "dias_oc", nullable = false)
    private int diasOC;

    @Column(nullable = false)
    private int criterio;

    @Column(nullable = false)
    private int discrecional;

    @Column(nullable = false)
    private boolean ahorro;

    @Column(name = "captura_en_tiempo", nullable = false)
    private boolean capturaEnTiempo;

    @Column(nullable = false)
    private int total;

    private boolean estatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comprador", updatable = false, nullable = false) //La union se realiza mediate el campo id_cliente
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Comprador Comprador;

}
