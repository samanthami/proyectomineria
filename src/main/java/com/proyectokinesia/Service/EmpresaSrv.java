package com.proyectokinesia.Service;

import com.proyectokinesia.Dao.EmpresaDao;
import com.proyectokinesia.Entity.Empresa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaSrv implements EmpresaImpl {

        private final EmpresaDao empresaDao;

        public EmpresaSrv(EmpresaDao empresaDao) {
            this.empresaDao = empresaDao;
        }


        @Override
        public List<Empresa> findAll() {
            return empresaDao.findAll();
        }


        @Override
        public Empresa findById(Integer id) {
            return empresaDao.findById(id);
        }

        @Override
        public Empresa findByNombreEmpresa(String nombre) {
            return empresaDao.findByNombreEmpresa(nombre);
        }

        @Override
        public Empresa save(Empresa empresa) throws Exception {
            if(empresa.getNombreEmpresa().isEmpty()){
                throw new Exception("Se debe ingresar el nombre");
            }
            return empresaDao.save(empresa);
        }

        @Override
        public void update(Empresa empresa) {
            empresaDao.save(empresa);
        }

        public Empresa estado(Integer id) {
            Empresa em = empresaDao.findById(id);
            em.setEstado(!em.getEstado());
            return empresaDao.save(em);
        }
    }
