package com.example.tutoria03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tutoria03.models.Docente;

public interface IDocenteRepository extends JpaRepository<Docente, Long> {

    // Spring genera automáticamente la consulta:
    // SELECT COUNT(*) > 0 FROM docente WHERE tipo_documento=? AND numero_documento=?
    boolean existsByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);
}
