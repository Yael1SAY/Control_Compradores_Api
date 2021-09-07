package com.truper.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "compradores")
@Data
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprador")
    private long idComprador;

    @Column(nullable = false, unique = true)
    private String clave;

    @Column(nullable = true)
    private String password;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    private boolean estatus;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "compradores_roles", joinColumns = @JoinColumn(name="id_comprador"),
            inverseJoinColumns = @JoinColumn(name = "id_rol"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"id_comprador", "id_rol"})})
    private List<Rol> roles;

}
