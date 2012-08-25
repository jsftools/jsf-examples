package de.thomasasel.jsf.example;

import java.io.Serializable;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@CustomScoped("#{CUSTOM_SCOPE}")
public class ExampleBean implements Serializable {

	private static final long serialVersionUID = -4537235405220326050L;

	private String text1 = "Default Text1";

	private String text2 = "Default Text2";

	private String text3 = "Default Text3";

	public ExampleBean() {
		super();
	}

	public String getText1() {
		return text1;
	}

	public void setText1(final String text1) {
		this.text1 = text1;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(final String text2) {
		this.text2 = text2;
	}

	public String getText3() {
		return text3;
	}

	public void setText3(final String text3) {
		this.text3 = text3;
	}


}
