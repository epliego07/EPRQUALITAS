package com.qualitas.FacturaPF;

import com.qualitas.VendedoresDao.dao.VendedoresDao;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import static org.primefaces.behavior.confirm.ConfirmBehavior.PropertyKeys.message;

@ManagedBean
@ViewScoped
public class AuthMBean {

    private Vendedores vendedor;
    private String usuario;
    private String contrasenia;

    public String login() {
        String mensaje =null;
        try {
            vendedor = VendedoresDao.find(usuario, contrasenia);
            if (vendedor != null) {
                return "/welcome";
            }
            mensaje="Usuario y/o Contraseña no validos ";
        } catch (Exception e) {
            mensaje = e.getMessage();
            e.printStackTrace();           
        }
        FacesContext context = FacesContext.getCurrentInstance();    
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,  "Error: " , mensaje) );
        return "/index";
    }

    public Vendedores getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedores vendedor) {
        this.vendedor = vendedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
