package com.proyectokinesia.dao;

import com.proyectokinesia.entidad.Persona;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class PersonaDaoImpl implements PersonaDAO{
    @Override
    public List<Persona> findAll() {
        return null;
    }

    @Override
    public List<Persona> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Persona> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Persona> findAllById(Iterable<String> strings) {
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
    public void delete(Persona entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Persona> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Persona> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Persona> findById(String s) {
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
    public <S extends Persona> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Persona> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Persona> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Persona getOne(String s) {
        return null;
    }

    @Override
    public Persona getById(String s) {
        return null;
    }

    @Override
    public Persona getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends Persona> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Persona> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Persona> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Persona> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Persona> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Persona> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Persona, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Persona> findByCedula(String cedula) {
        return null;
    }

    @Override
    public <S extends Persona> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Persona> S findById(Integer id) {
        return null;
    }
}
