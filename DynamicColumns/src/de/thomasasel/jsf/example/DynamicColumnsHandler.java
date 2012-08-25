package de.thomasasel.jsf.example;

import java.io.IOException;
import java.util.List;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlColumn;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;

public class DynamicColumnsHandler extends TagHandler {

	public DynamicColumnsHandler(final TagConfig config) {
		super(config);
	}

	@Override
	public void apply(final FaceletContext ctx, final UIComponent parent) throws IOException {

		if (parent instanceof HtmlDataTable) {

			TagAttribute modelAttribute = getRequiredAttribute("model");
			Object modelObject = modelAttribute.getValueExpression(ctx, Object.class).getValue(ctx.getFacesContext().getELContext());

			if (null != modelObject) {

				@SuppressWarnings("unchecked")
				List<Columns> model = (List<Columns>) modelObject;

				for (Columns c : model) {

					HtmlColumn column = createColumn(ctx.getFacesContext(), c);

					if (null != column) {
						parent.getChildren().add(column);
					}
				}
			}
		}
	}

	private HtmlColumn createColumn(final FacesContext facesContext, final Columns c) {

		Application application = facesContext.getApplication();
		ELContext elContext = facesContext.getELContext();

		HtmlColumn column = (HtmlColumn) application.createComponent(HtmlColumn.COMPONENT_TYPE);

		switch(c) {

		case address:
			column = populateAddressColumn(facesContext, column);
			break;
		case email:
			column = populateEmailColumn(facesContext, column);
			break;
		case name:
			column = populateNameColumn(facesContext, column);
			break;
		case personSummary:
			column = populatePersonColumn(facesContext, column);
			break;
		default: column = null;

		}

		return column;
	}

	private HtmlOutputText createCaptionComponent(final String caption, final Application application) {
		HtmlOutputText captionComponent = (HtmlOutputText) application.createComponent(HtmlOutputText.COMPONENT_TYPE);
		captionComponent.setValue(caption);
		captionComponent.setEscape(false);

		return captionComponent;
	}

	private HtmlColumn populateAddressColumn(final FacesContext facesContext, final HtmlColumn column) {

		Application application = facesContext.getApplication();
		ELContext elContext = facesContext.getELContext();

		// Create column header
		column.getFacets().put("header", createCaptionComponent("Address", application));

		// Crate column content
		ValueExpression ve = application.getExpressionFactory().createValueExpression(elContext, "#{person.address.number} #{person.address.street} <br /> #{person.address.zipCode} #{person.address.city} ", String.class);

		HtmlOutputText address = (HtmlOutputText) application.createComponent(HtmlOutputText.COMPONENT_TYPE);
		address.setValueExpression("value", ve);
		address.setEscape(false);
		column.getChildren().add(address);

		return column;
	}

	private HtmlColumn populateEmailColumn(final FacesContext facesContext, final HtmlColumn column) {

		Application application = facesContext.getApplication();
		ELContext elContext = facesContext.getELContext();

		// Create column header
		column.getFacets().put("header", createCaptionComponent("Email", application));

		// Crate column content
		ValueExpression linkVe = application.getExpressionFactory().createValueExpression(elContext, "mailto: #{person.email}", String.class);
		ValueExpression textVe = application.getExpressionFactory().createValueExpression(elContext, "#{person.email}", String.class);
		ValueExpression renderedVe = application.getExpressionFactory().createValueExpression(elContext, "#{! empty person.email}", Boolean.class);

		HtmlOutputLink link = (HtmlOutputLink) application.createComponent(HtmlOutputLink.COMPONENT_TYPE);
		link.setValueExpression("value", linkVe);
		link.setValueExpression("rendered", renderedVe);

		HtmlOutputText linkText = (HtmlOutputText) application.createComponent(HtmlOutputText.COMPONENT_TYPE);
		linkText.setValueExpression("value", textVe);
		link.getChildren().add(linkText);

		column.getChildren().add(link);

		return column;
	}

	private HtmlColumn populateNameColumn(final FacesContext facesContext, final HtmlColumn column) {

		Application application = facesContext.getApplication();
		ELContext elContext = facesContext.getELContext();

		// Create column header

		column.getFacets().put("header", createCaptionComponent("Name", application));

		// Crate column content
		ValueExpression textVe = application.getExpressionFactory().createValueExpression(elContext, "#{person.firstname} #{person.lastname}", String.class);

		HtmlOutputText text = (HtmlOutputText) application.createComponent(HtmlOutputText.COMPONENT_TYPE);
		text.setValueExpression("value", textVe);

		column.getChildren().add(text);

		return column;
	}

	private HtmlColumn populatePersonColumn(final FacesContext facesContext, final HtmlColumn column) {

		Application application = facesContext.getApplication();
		ELContext elContext = facesContext.getELContext();

		// Create column header

		column.getFacets().put("header", createCaptionComponent("Person", application));

		// Crate column content
		ValueExpression textVe = application.getExpressionFactory().createValueExpression(elContext, "#{person.firstname} #{person.lastname}", String.class);
		ValueExpression linkVe = application.getExpressionFactory().createValueExpression(elContext, "mailto: #{person.email}", String.class);
		ValueExpression disabledVe = application.getExpressionFactory().createValueExpression(elContext, "#{empty person.email}", Boolean.class);


		HtmlOutputText text = (HtmlOutputText) application.createComponent(HtmlOutputText.COMPONENT_TYPE);
		text.setValueExpression("value", textVe);

		HtmlOutputLink link = (HtmlOutputLink) application.createComponent(HtmlOutputLink.COMPONENT_TYPE);
		link.setValueExpression("value", linkVe);
		link.setValueExpression("disabled", disabledVe);
		link.getChildren().add(text);

		column.getChildren().add(link);

		return column;
	}

}
