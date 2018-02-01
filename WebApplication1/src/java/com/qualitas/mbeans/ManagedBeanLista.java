/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualitas.mbeans;

import com.qualitas.entities.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class ManagedBeanLista {
 
    private List <Cliente> lista ;
    private int numeroElementos;
    
    public ManagedBeanLista() {
    }
    @PostConstruct 
    public void inicializar(){
        lista =new ArrayList<>();
        lista.add(new Cliente("Victor Flores","DSFSDF","FORD",2017));
        lista.add(new Cliente("Juan Perez","DSDIOJDFIO","NISSAN",2015));
        lista.add(new Cliente("Rocio Ramirez","ASDFSDFD","HONDA",2016));
        lista.add(new Cliente("Paola Solis","DSFSSDSADDF","CHEVROLET",2018));
        lista.add(new Cliente("Erick Juarez","DSFSSDSADDF","AUDI",2019));
        
    }
    public String navegar(){
        
        return"lista";
    }

    public List <Cliente> getLista() {
        return lista;
    }

    public void setLista(List <Cliente> lista) {
        this.lista = lista;
    }

    public int getNumeroElementos() {
        numeroElementos=lista.size();
        return numeroElementos;
    }

    public void setNumeroElementos(int numeroElementos) {
        this.numeroElementos = numeroElementos;
    }
    
}
