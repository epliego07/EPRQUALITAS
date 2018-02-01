package com.qualitas.FacturaPF;

import com.qualitas.VendedoresDao.dao.ArticulosDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
@ViewScoped
public class ArticuloConverter implements Converter {

    @ManagedProperty(value = "#{ facturaMBean }")
    private FacturaMBean facturaMBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String clave) {
        Articulo articulo = new Articulo();

        try {
            for (Articulo a : ArticulosDao.findAll()) {
                if (a.getId()==Integer.parseInt(clave)) {
                    articulo = a;
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArticuloConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloConverter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return articulo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
        if(o == null){
            return "";
        }
        
        Articulo articulo = (Articulo) o;
        return String.valueOf(articulo.getId());
    }

    public FacturaMBean getFacturaMBean() {
        return facturaMBean;
    }

    public void setFacturaMBean(FacturaMBean facturaMBean) {
        this.facturaMBean = facturaMBean;
    }
}
