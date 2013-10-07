package de.thomasasel.viewaction;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author Thomas Asel
 */

@ManagedBean
@RequestScoped
public class ViewActionBean {
    
    public String viewAction() {
        System.out.println("ViewAction of '" + getCurrentcomponentId() + "' invoked");
        return "next.xhtml";
    }

    public void onViewActionInvoke(ActionEvent event) {
        System.out.println("ActionListenerMethod of '" + getCurrentcomponentId() + "' invoked");
    }
    
    public ActionListener getActionListener() {
        
        return new ActionListener() {

            @Override
            public void processAction(ActionEvent ae) throws AbortProcessingException {
                System.out.println("ActionListener of '" + getCurrentcomponentId() + "' invoked");
            }
        };
    }
    
    private String getCurrentcomponentId() {
        UIComponent component = UIComponent.getCurrentComponent(FacesContext.getCurrentInstance());
        return component.getId();
    }
}
