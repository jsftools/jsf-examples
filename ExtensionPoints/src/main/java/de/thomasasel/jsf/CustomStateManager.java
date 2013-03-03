package de.thomasasel.jsf;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.StateManager;
import javax.faces.application.StateManager.SerializedView;
import javax.faces.application.StateManagerWrapper;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

public class CustomStateManager extends StateManagerWrapper {
	
	private static Logger LOG = Logger.getLogger(CustomStateManager.class.getSimpleName());

	private StateManager wrapped;
	
	public CustomStateManager(StateManager wrapped) {
		LOG.info("StateManager constructed");
		
		this.wrapped = wrapped;
	}
	
	@Override
	public SerializedView saveSerializedView(FacesContext context) {
		LOG.info("StateManager.saveSerializedView");
		return super.saveSerializedView(context);
	}

	@Override
	public Object saveView(FacesContext context) {
				LOG.info("StateManager.saveView");
		return super.saveView(context);
	}

	@Override
	protected Object getTreeStructureToSave(FacesContext context) {
				LOG.info("StateManager.getTreeStructureToSave");
		return super.getTreeStructureToSave(context);
	}

	@Override
	protected Object getComponentStateToSave(FacesContext context) {
				LOG.info("StateManager.getComponentStateToSave");
		return super.getComponentStateToSave(context);
	}

	@Override
	public void writeState(FacesContext context, Object state)
			throws IOException {
				LOG.info("StateManager.writeState");
		super.writeState(context, state);
	}

	@Override
	public void writeState(FacesContext context, SerializedView state)
			throws IOException {
				LOG.info("StateManager.writeState");
		super.writeState(context, state);
	}

	@Override
	public UIViewRoot restoreView(FacesContext context, String viewId,
			String renderKitId) {
				LOG.info("StateManager.restoreView");
		return super.restoreView(context, viewId, renderKitId);
	}

	@Override
	protected UIViewRoot restoreTreeStructure(FacesContext context,
			String viewId, String renderKitId) {
				LOG.info("StateManager.restoreTreeStructure");
		return super.restoreTreeStructure(context, viewId, renderKitId);
	}

	@Override
	protected void restoreComponentState(FacesContext context,
			UIViewRoot viewRoot, String renderKitId) {
				LOG.info("StateManager.restoreComponentState");
		super.restoreComponentState(context, viewRoot, renderKitId);
	}

	@Override
	public boolean isSavingStateInClient(FacesContext context) {
				LOG.info("StateManager.isSavingStateInClient");
		return super.isSavingStateInClient(context);
	}

	@Override
	public String getViewState(FacesContext context) {
				LOG.info("StateManager.getViewState");
		return super.getViewState(context);
	}

	@Override
	public StateManager getWrapped() {
		return wrapped;
	}

}
