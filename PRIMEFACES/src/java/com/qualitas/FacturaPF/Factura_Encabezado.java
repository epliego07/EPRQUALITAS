package com.qualitas.FacturaPF;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Factura_Encabezado implements Serializable {

    private int id;
    private float total;
    private Date fecha;
    private Cliente cliente;
    List<Factura_detalle> detalle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
