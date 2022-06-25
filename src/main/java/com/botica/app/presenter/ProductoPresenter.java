package com.botica.app.presenter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductoPresenter {
    private Long id;
    private String nombre;
    private String cantidad;
    private String unidadMedida;
    private double precio;
    private int stock;
    private String laboratorio;
}
