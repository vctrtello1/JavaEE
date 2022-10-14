package com.victortello.JDBCTransccional.models;

import java.util.Date;

public class Producto {
    private Long id_producto;
    public Long getId() {
        return id_producto;
    }

    public void setId(Long id_producto) {
        this.id_producto = id_producto;
    }

    private String cnombre_articulo;
    public String getCnombre_articulo() {
        return cnombre_articulo;
    }

    public void setCnombre_articulo(String cnombre_articulo) {
        this.cnombre_articulo = cnombre_articulo;
    }

    private Float fprecio;
    public Float getFprecio() {
        return fprecio;
    }
    public void setFprecio(Float fprecio) {
        this.fprecio = fprecio;
    }

    private Date dfecha_registro;
    public Date getDfecha_registro() {
        return dfecha_registro;
    } 
    public void setDfecha_registro(Date dfecha_registro) {
        this.dfecha_registro = dfecha_registro;
    }

    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }  

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Constructor
    public Producto() {
    }

    public Producto(Long id, String cnombre_articulo, Float fprecio, Date dfecha_registro, Categoria categoria) {
        this.id_producto = id;
        this.cnombre_articulo = cnombre_articulo;
        this.fprecio = fprecio;
        this.dfecha_registro = dfecha_registro;
    }

    @Override
    public String toString() {
        return "Producto [cnombre_articulo=" + cnombre_articulo + ", dfecha_registro=" + dfecha_registro + ", fprecio="
                + fprecio + ", id=" + id_producto +  ", categoria=" +  categoria.getCnombre_categoria() + "]";
    }
    
    
}
