package com.nttdata.jpuma.producto.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String id;
    private String tipoProducto;
    private String nombreProducto;
    private String comision;
    private String nromovimientos;
    private String condicion;
    private String tipoDisponibilidad;
    private String disponibilidad;
}
