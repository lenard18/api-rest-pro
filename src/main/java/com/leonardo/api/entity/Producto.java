package com.leonardo.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
public class Producto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    @Column(nullable = false)
    private BigDecimal precio;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Column(nullable = false)
    private Integer stock;

    @NotBlank(message = "La categoría es obligatoria")
    private String categoria;

    public Producto() {}

    public Producto(Long id, String nombre, String descripcion, BigDecimal precio, Integer stock, String categoria) {
        this.id = id; this.nombre = nombre; this.descripcion = descripcion;
        this.precio = precio; this.stock = stock; this.categoria = categoria;
    }

    public Long getId()                    { return id; }
    public void setId(Long id)             { this.id = id; }
    public String getNombre()              { return nombre; }
    public void setNombre(String n)        { this.nombre = n; }
    public String getDescripcion()         { return descripcion; }
    public void setDescripcion(String d)   { this.descripcion = d; }
    public BigDecimal getPrecio()          { return precio; }
    public void setPrecio(BigDecimal p)    { this.precio = p; }
    public Integer getStock()              { return stock; }
    public void setStock(Integer s)        { this.stock = s; }
    public String getCategoria()           { return categoria; }
    public void setCategoria(String c)     { this.categoria = c; }
}
