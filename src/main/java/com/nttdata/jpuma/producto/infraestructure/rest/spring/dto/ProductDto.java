package com.nttdata.jpuma.producto.infraestructure.rest.spring.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String id;
    private String tipoProducto;
    private String nombreProducto;
    private Double comision;
    private String nromovimientos;
    private String condicion;
    private String tipoDisponibilidad;
    private String disponibilidad;
}
