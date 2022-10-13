package com.victortello.poolDeConexiones.models;

public class Categoria {
    private Long id_categoria;
    private String cnombre_categoria;
    public Long getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }
    public String getCnombre_categoria() {
        return cnombre_categoria;
    }
    public void setCnombre_categoria(String cnombre_categoria) {
        this.cnombre_categoria = cnombre_categoria;
    }
    public Categoria() {
    }
    public Categoria(Long id_categoria, String cnombre_categoria) {
        this.id_categoria = id_categoria;
        this.cnombre_categoria = cnombre_categoria;
    }
    @Override
    public String toString() {
        return "Categoria [cnombre_categoria=" + cnombre_categoria + "]";
    }
    
    
    
}
