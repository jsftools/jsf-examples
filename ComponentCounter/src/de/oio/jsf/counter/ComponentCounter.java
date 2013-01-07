package de.oio.jsf.counter;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.component.visit.VisitContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * PhaseListener that logs number of components in the JSF component tree and basic component information.
 * 
 * @author Thomas Asel
 *
 */
public class ComponentCounter implements PhaseListener {
	
	private static final long serialVersionUID = 8573925562596090327L;
	private final static Logger LOG = Logger.getLogger(ComponentCounter.class.getName());
	
	@Override
	public void beforePhase(PhaseEvent event) {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		VisitContext visitContext = VisitContext.createVisitContext(facesContext);
		
		CountingVisitCallback callback = new CountingVisitCallback();
		facesContext.getViewRoot().visitTree(visitContext, callback);
		
		LOG.log(Level.INFO, ("Number of Components: " + callback.getCount()));
		
		for (String info : callback.getComponentInfo()) {
			LOG.log(Level.INFO, "Component found: " + info);
		}
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		// do nothing
	}
}
