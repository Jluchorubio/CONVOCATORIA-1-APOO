package com.example.tutoria03.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tutoria03.exceptions.DocenteDuplicadoException;
import com.example.tutoria03.exceptions.DocenteNoEncontradoException;
import com.example.tutoria03.models.Docente;
import com.example.tutoria03.repositories.IDocenteRepository;

@Service
public class DocenteService {

    private final IDocenteRepository docenteRepository;

    public DocenteService(IDocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    public List<Docente> obtenerTodos() {
        return docenteRepository.findAll();
    }

    public Docente obtenerPorId(Long id) {
        return docenteRepository.findById(id)
                .orElseThrow(() -> new DocenteNoEncontradoException(id));
    }

    // Regla: no duplicar tipoDocumento + numeroDocumento
    public Docente crear(Docente docente) {
        if (docenteRepository.existsByTipoDocumentoAndNumeroDocumento(
                docente.getTipoDocumento(), docente.getNumeroDocumento())) {
            throw new DocenteDuplicadoException(docente.getTipoDocumento(), docente.getNumeroDocumento());
        }
        return docenteRepository.save(docente);
    }

    // Regla: verificar que exista por ID antes de actualizar
    public Docente actualizar(Long id, Docente docente) {
        if (!docenteRepository.existsById(id)) {
            throw new DocenteNoEncontradoException(id);
        }
        docente.setId(id);
        return docenteRepository.save(docente);
    }

    // Regla: verificar que exista por ID antes de eliminar
    public void eliminar(Long id) {
        if (!docenteRepository.existsById(id)) {
            throw new DocenteNoEncontradoException(id);
        }
        docenteRepository.deleteById(id);
    }
}
