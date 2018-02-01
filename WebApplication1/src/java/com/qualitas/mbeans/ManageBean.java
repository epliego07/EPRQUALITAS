/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualitas.mbeans;

import com.qualitas.entities.Cliente;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author ccapacitacion10
 */
@Named(value = "manageBean")
@Dependent
public class ManageBean {

    private String cadena = "Hola desde el MB";
    
    private Cliente cliente;       
    
    public ManageBean(){    
    }    

    @PostConstruct
    private void inicializar(){
        setCliente(new Cliente("Papatzul","folio001","Chevrolet",2005));
    }
    
    public String getCadena() {
        return cadena;
    }

    /**
     * @param cadena the cadena to set
     */
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
