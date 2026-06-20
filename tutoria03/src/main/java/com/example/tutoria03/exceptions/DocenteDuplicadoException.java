package com.example.tutoria03.exceptions;

public class DocenteDuplicadoException extends RuntimeException {
    public DocenteDuplicadoException(String tipoDocumento, String numeroDocumento) {
        super("Ya existe un docente con " + tipoDocumento + " " + numeroDocumento + ".");
    }
}
