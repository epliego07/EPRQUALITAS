package com.qualitas.FacturaPF;

import com.qualitas.VendedoresDao.dao.ClientesDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter {

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
                try {
                    for (Cliente c : ClientesDao.findAll()) {
                        if (c.getId() == Integer.valueOf(value)) {
                            return c;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return String.valueOf(((Cliente) object).getId());
        }
        return null;
    }
}
