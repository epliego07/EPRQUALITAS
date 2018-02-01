package com.qualitas.FacturaPF;

import java.io.Serializable;
import java.util.Date;

public class Factura_detalle implements Serializable {
    private Factura_Encabezado encabezado;
    private int numPartida;
    private Articulo articulo;
    private int cantidad;

    public Factura_Encabezado getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Factura_Encabezado encabezado) {
        this.encabezado = encabezado;
    }

    public int getNumPartida() {
        return numPartida;
    }

    public void setNumPartida(int numPartida) {
        this.numPartida = numPartida;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

     
}
