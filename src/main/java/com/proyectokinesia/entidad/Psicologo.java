package com.proyectokinesia.entidad;

import javax.persistence.*;

@Entity
@Table(name = "psicologo")
public class Psicologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpsicologo", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_idEmpresas")
    private Empresa empresaIdempresas;

    public Empresa getEmpresaIdempresas() {
        return empresaIdempresas;
    }

    public void setEmpresaIdempresas(Empresa empresaIdempresas) {
        this.empresaIdempresas = empresaIdempresas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}