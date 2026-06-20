package com.example.tutoria03.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tutoria03.models.Docente;
import com.example.tutoria03.services.DocenteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/docentes")
@Tag(name = "Docente Controller", description = "CRUD de docentes")
public class DocenteController {

    private final DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los docentes")
    @ApiResponse(responseCode = "200", description = "Lista de docentes")
    public ResponseEntity<List<Docente>> obtenerTodos() {
        return ResponseEntity.ok(docenteService.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un docente por ID")
    @ApiResponse(responseCode = "200", description = "Docente encontrado")
    @ApiResponse(responseCode = "404", description = "Docente no encontrado")
    public ResponseEntity<Docente> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(docenteService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear un docente")
    @ApiResponse(responseCode = "201", description = "Docente creado")
    @ApiResponse(responseCode = "409", description = "Ya existe docente con ese documento")
    public ResponseEntity<Docente> crear(@RequestBody Docente docente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(docenteService.crear(docente));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un docente por ID")
    @ApiResponse(responseCode = "200", description = "Docente actualizado")
    @ApiResponse(responseCode = "404", description = "Docente no encontrado")
    public ResponseEntity<Docente> actualizar(@PathVariable Long id, @RequestBody Docente docente) {
        return ResponseEntity.ok(docenteService.actualizar(id, docente));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un docente por ID")
    @ApiResponse(responseCode = "204", description = "Docente eliminado")
    @ApiResponse(responseCode = "404", description = "Docente no encontrado")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        docenteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
