package de.thomasasel.jsf.example;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class ViewExpiredExcpetionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;

	public ViewExpiredExcpetionHandler(final ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {

		Iterator<ExceptionQueuedEvent> iterator = getUnhandledExceptionQueuedEvents().iterator();

		while (iterator.hasNext()) {

			ExceptionQueuedEvent event = iterator.next();
			ExceptionQueuedEventContext context = event.getContext();
			Throwable throwable = context.getException();

			if (throwable instanceof ViewExpiredException) {
				ViewExpiredException exception = (ViewExpiredException) throwable;

				FacesContext facesContext = context.getContext();
				ViewHandler viewHandler = facesContext.getApplication().getViewHandler();

				UIViewRoot viewRoot = viewHandler.createView(facesContext, exception.getViewId());
				facesContext.setViewRoot(viewRoot);
				viewRoot.processDecodes(facesContext);

			}

			iterator.remove();

		}

		//		getWrapped().handle();

	}


}
