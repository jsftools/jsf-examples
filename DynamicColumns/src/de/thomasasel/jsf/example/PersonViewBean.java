package de.thomasasel.jsf.example;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class PersonViewBean {

	public List<Columns> getColumnModel1() {
		List<Columns> columnModel = new ArrayList<Columns>();

		columnModel.add(Columns.name);
		columnModel.add(Columns.address);
		columnModel.add(Columns.email);

		return columnModel;
	}

	public List<Columns> getColumnModel2() {
		List<Columns> columnModel = new ArrayList<Columns>();

		columnModel.add(Columns.address);
		columnModel.add(Columns.personSummary);

		return columnModel;
	}

	public List<Person> getPersonList() {

		List<Person> persons = new ArrayList<Person>();

		Address simponsAddress = new Address("Evergreen Terrace","742","Springfield",80085);
		Person homer = new Person("Homer","Simpson",simponsAddress,"chunkylover53@aol.com");
		persons.add(homer);

		Person marge = new Person("Marge","Simpson",simponsAddress,null);
		persons.add(marge);

		Person lisa = new Person("Lisa","Simpson",simponsAddress,"Smartgirl63@yahoo.com");
		persons.add(lisa);

		Person bart = new Person("Bart","Simpson",simponsAddress,"lilbasterd85@yahoo.com");
		persons.add(bart);

		Address flandersAddress = new Address("Evergreen Terrace","740","Springfield",80085);
		Person ned = new Person("Ned","Flanders",flandersAddress,"naddely-dadelli@aol.com");
		persons.add(ned);

		return persons;
	}


}
