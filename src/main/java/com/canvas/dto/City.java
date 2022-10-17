package com.canvas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {
    private int id;
    private String name;
    private String country;
    private String zip;
}
