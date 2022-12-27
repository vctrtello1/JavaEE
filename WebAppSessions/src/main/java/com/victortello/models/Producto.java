package com.victortello.models;

import java.util.Date;

public class Producto {
    private Long id_producto;
    private String cnombre_articulo;
    private Float fprecio;
    private Date dfecha_registro;
    private Categoria categoria;
    private String sku;

    public Long getId() {
        return id_producto;
    }

    public void setId(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getCnombre_articulo() {
        return cnombre_articulo;
    }

    public void setCnombre_articulo(String cnombre_articulo) {
        this.cnombre_articulo = cnombre_articulo;
    }

    public Float getFprecio() {
        return fprecio;
    }

    public void setFprecio(Float fprecio) {
        this.fprecio = fprecio;
    }

    public Date getDfecha_registro() {
        return dfecha_registro;
    }

    public void setDfecha_registro(Date dfecha_registro) {
        this.dfecha_registro = dfecha_registro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Constructor
    public Producto() {
    }

    public Producto(Long id, String cnombre_articulo, Float fprecio, Date dfecha_registro, Categoria categoria,
            String sku) {
        this.id_producto = id;
        this.cnombre_articulo = cnombre_articulo;
        this.fprecio = fprecio;
        this.dfecha_registro = dfecha_registro;
        this.sku = sku;
    }

    public Producto(long l, String string, String string2, int i) {
    }

    @Override
    public String toString() {
        return "Producto [cnombre_articulo=" + cnombre_articulo + ", dfecha_registro=" + dfecha_registro + ", fprecio="
                + fprecio + ", id=" + id_producto + ", categoria=" + categoria.getCnombre_categoria() + "]";
    }
}
