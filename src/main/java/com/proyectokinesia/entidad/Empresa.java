package com.proyectokinesia.entidad;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpresas", nullable = false)
    private Integer id;

    @Column(name = "nombreEmpresa", nullable = false, length = 45)
    private String nombreEmpresa;

    @Column(name = "telefono", length = 45)
    private String telefono;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "psicologo_idpsicologo", nullable = false, length = 45)
    private String psicologoIdpsicologo;

    @OneToMany(mappedBy = "empresaIdempresas")
    private Set<Psicologo> psicologos = new LinkedHashSet<>();

    public Set<Psicologo> getPsicologos() {
        return psicologos;
    }

    public void setPsicologos(Set<Psicologo> psicologos) {
        this.psicologos = psicologos;
    }

    public String getPsicologoIdpsicologo() {
        return psicologoIdpsicologo;
    }

    public void setPsicologoIdpsicologo(String psicologoIdpsicologo) {
        this.psicologoIdpsicologo = psicologoIdpsicologo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}