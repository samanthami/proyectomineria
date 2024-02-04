package com.proyectokinesia.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.Serializable;

@Repository
public class EntrevistaJdbcDao implements Serializable {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String E_Entrevista ="select p.idpersona, p.nombre, p.apellido, e.nombreentrevistador, e.fechaentrevista, e.gestos, em.nombreempresa\n" +
            " from entrevista as e, persona as p, empresa as em\n" +
            " where e.persona_idpersona = ? and e.persona_idpersona = p.idpersona and em.idempresas = p.empresa_idempresas ";

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
}
