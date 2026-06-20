package com.example.tutoria03.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "docente")
@Schema(description = "Entidad que representa un docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID autogenerado", example = "1")
    private Long id;

    @Schema(description = "Número de documento", example = "123456789")
    private String numeroDocumento;

    @Schema(description = "Tipo de documento: CC, TI, CE, Pasaporte", example = "CC")
    private String tipoDocumento;

    @Schema(description = "Nombres completos", example = "Juan Carlos")
    private String nombres;

    @Schema(description = "Apellidos", example = "García López")
    private String apellidos;

    @Schema(description = "Correo institucional", example = "jgarcia@universidad.edu.co")
    private String correo;

    @Schema(description = "Especialidad o área de enseñanza", example = "Programación Orientada a Objetos")
    private String especialidad;

    @Schema(description = "Estado activo del docente", example = "true")
    private boolean activo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}
