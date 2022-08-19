package com.proyectokinesia.dao;

import com.proyectokinesia.entidad.Empresa;
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
public class EmpresaDaoImpl implements EmpresaDao{
    @Override
    public List<Empresa> findAll() {
        return null;
    }

    @Override
    public List<Empresa> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Empresa> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Empresa> findAllById(Iterable<String> strings) {
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
    public void delete(Empresa entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Empresa> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Empresa> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Empresa> findById(String s) {
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
    public <S extends Empresa> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Empresa> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Empresa> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Empresa getOne(String s) {
        return null;
    }

    @Override
    public Empresa getById(String s) {
        return null;
    }

    @Override
    public Empresa getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends Empresa> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Empresa> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Empresa> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Empresa> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Empresa> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Empresa> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Empresa, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public Empresa findByNombreempresa(String nombreEmpresa) {
        return null;
    }

    @Override
    public <S extends Empresa> S save(S entity) {
        return null;
    }

    @Override
    public Empresa findById(Integer id) {
        return null;
    }
}
