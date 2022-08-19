package com.proyectokinesia.dao;

import com.proyectokinesia.entidad.Entrevista;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class EntrevistaDaoImpl implements EntrevistaDao{
    @Override
    public List<Entrevista> findAll() {
        return null;
    }

    @Override
    public List<Entrevista> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Entrevista> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Entrevista> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Entrevista entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Entrevista> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Entrevista> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Entrevista> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Entrevista> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Entrevista> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Entrevista> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Entrevista getOne(String s) {
        return null;
    }

    @Override
    public Entrevista getById(String s) {
        return null;
    }

    @Override
    public Entrevista getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends Entrevista> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Entrevista> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Entrevista> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Entrevista> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Entrevista> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Entrevista> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Entrevista, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Entrevista> S save(S entity) {
        return null;
    }

    @Override
    public Entrevista findById(Integer id) {
        return null;
    }

    @Override
    public List<Entrevista> findByNombreEntrevistador(String nombre) {
        return null;
    }

    @Override
    public List<Entrevista> findByFechaentrevista(Date fecha) {
        return null;
    }
}
