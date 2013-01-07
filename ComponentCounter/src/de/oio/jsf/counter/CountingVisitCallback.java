package de.oio.jsf.counter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;

/**
 * VisitCallback that is used to gather information about the component tree.
 * Keeps track of the total number of components and maintains a list 
 * of basic component information.
 * 
 * @author Thomas Asel
 *
 */
public class CountingVisitCallback implements VisitCallback {
	
	private int count = 0;
	private List<String> componentInfo = new ArrayList<String>();
	
	/**
	 * This method will be invoked on every node of the component tree.
	 */
	@Override
	public VisitResult visit(VisitContext context, UIComponent target) {

		count++;
		getComponentInfo().add(target.getClientId() + " ["+target.getClass().getSimpleName()+"]");
		
		// descend into current subtree, if applicable
		return VisitResult.ACCEPT;
	}

	public int getCount() {
		return count;
	}

	public List<String> getComponentInfo() {
		return componentInfo;
	}

}