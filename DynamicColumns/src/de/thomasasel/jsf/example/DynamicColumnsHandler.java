package de.thomasasel.jsf.example;

import java.io.IOException;
import java.util.List;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlColumn;
import javax.faces.component.html.HtmlDataTable;
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
			HtmlOutputText address = (HtmlOutputText) application.createComponent(HtmlOutputText.COMPONENT_TYPE);
			ValueExpression ve = application.getExpressionFactory().createValueExpression(elContext, "#{person.address.number} #{person.address.street} #{person.address.zipCode} #{person.address.city} ", String.class);
			address.setValueExpression("value", ve);
			column.getChildren().add(address);
			break;
		case email:
			column = null;
			break;
		case name:
			column = null;
			break;
		case personSummary:
			column = null;
			break;
		default: column = null;

		}

		return column;
	}

}
