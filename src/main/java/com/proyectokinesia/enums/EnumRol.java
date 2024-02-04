package com.proyectokinesia.enums;


public enum EnumRol {

    ADMIN("Administrador", 1),
    USER("Usuario", 2);

    private final String nombreRol;
    private final Integer numRol;

    EnumRol(String nombreRol, Integer numRol) {
        this.nombreRol = nombreRol;
        this.numRol = numRol;}
}
