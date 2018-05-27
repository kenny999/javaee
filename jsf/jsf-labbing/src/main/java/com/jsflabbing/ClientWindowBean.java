package com.jsflabbing;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.lifecycle.ClientWindow;
import javax.inject.Named;

@RequestScoped
@Named
public class ClientWindowBean {

    public void getWindowID(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        ClientWindow clientWindow = externalContext.getClientWindow();

        if (clientWindow != null){
            System.out.println("client window id: " + clientWindow.getId());
        } else {
            System.out.println("client window cannot be determined!");
        }
    }

    public String enableClientWindow(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        ClientWindow clientWindow = externalContext.getClientWindow();
        clientWindow.enableClientWindowRenderMode(facesContext);
        return "clientwindow?faces-redirect=true";
    }

    public String disableClientWindow(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        ClientWindow clientWindow = externalContext.getClientWindow();
        clientWindow.disableClientWindowRenderMode(facesContext);
        return "clientwindow?faces-redirect=true";
    }

}