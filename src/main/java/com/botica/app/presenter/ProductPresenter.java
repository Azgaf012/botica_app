package com.botica.app.presenter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductPresenter {
    private Long id;
    private String name;
    private String cant;
    private String unitMeasurement;
    private double price;
    private int stock;
    private String laboratory;
}
