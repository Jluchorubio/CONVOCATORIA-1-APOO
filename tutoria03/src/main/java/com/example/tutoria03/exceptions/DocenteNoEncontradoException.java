package com.example.tutoria03.exceptions;

public class DocenteNoEncontradoException extends RuntimeException {
    public DocenteNoEncontradoException(Long id) {
        super("Docente con ID " + id + " no existe.");
    }
}
