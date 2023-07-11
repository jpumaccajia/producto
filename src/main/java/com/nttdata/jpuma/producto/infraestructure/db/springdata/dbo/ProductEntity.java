package com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "producto")
public class ProductEntity {

    @Id
    private String id;
    private String tipoProducto;
    private String nombreProducto;
    private String comision;
    private String nromovimientos;
    private String condicion;
    private String tipoDisponibilidad;
    private String disponibilidad;

    @CreatedDate
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    private LocalDateTime fechaModificacion;
}
