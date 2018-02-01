package com.qualitas.FacturaPF;

import com.qualitas.VendedoresDao.dao.ArticulosDao;
import com.qualitas.VendedoresDao.dao.ClientesDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class FacturaMBean {

    private Cliente cliente;

    public List<Cliente> completarCliente(String query) {
        List<Cliente> clientesfiltrados = new ArrayList<Cliente>();
        String mensaje = null;
        try {
            List<Cliente> clientes = ClientesDao.findAll();

            for (Cliente c : clientes) {
                if (c.getNombre().toLowerCase().startsWith(query.toLowerCase())) {
                    clientesfiltrados.add(c);
                }
            }

        } catch (Exception e) {
            mensaje = e.getMessage();
            e.printStackTrace();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", mensaje));
            return clientesfiltrados;
        }
        return clientesfiltrados;
    }

    public void onItemSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Seleccionado", "El cliente ha sido seleccionado"));
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    private List<Partida> partidas;

    {
        setPartidas(new ArrayList<Partida>());

        Partida p = new Partida();
        getPartidas().add(p);

        Articulo a = new Articulo();
        p.setArticulo(a);
    }

    public void calcularImporte(Partida p) {
        Articulo a = p.getArticulo();

        int cantidad = p.getCantidad();
        if (cantidad == 0) {
            p.setCantidad(1);
        }

        float importe = a.getPrecio() * p.getCantidad();
        p.setImporte(importe);
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    public List<Articulo> getArticulos() {
        try {
            return ArticulosDao.findAll();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FacturaMBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FacturaMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
