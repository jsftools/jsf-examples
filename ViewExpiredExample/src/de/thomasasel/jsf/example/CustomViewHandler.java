package de.thomasasel.jsf.example;

import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

public class CustomViewHandler extends ViewHandlerWrapper {

	private ViewHandler wrapped;

	public CustomViewHandler(final ViewHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public UIViewRoot restoreView(final FacesContext context, final String viewId) {

		UIViewRoot root = wrapped.restoreView(context, viewId);

		if (root == null) {

			root = createView(context, viewId);

			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Please avoid using browser back-button","The application was not able to serve the last request. Please make sure that you are using the designated navigaton-links only.");
			context.addMessage(null, fm);
		}

		return root;
	}

	@Override
	public ViewHandler getWrapped() {
		return wrapped;
	}


}
