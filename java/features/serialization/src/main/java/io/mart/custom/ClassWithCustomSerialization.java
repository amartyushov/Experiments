package io.mart.custom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ClassWithCustomSerialization implements Serializable {

	private static final long serialVersionUID = 1L;
	private transient Address address;
	private Person person;
	
	/*Method is required to provide a custom serialization*/
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeObject(address.getHouseNumber());
		oos.writeObject(address.getStreet());
	}
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
		
	}
	
	
	public Person getPerson() {
		return person;
	}
	
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	public Address getAddress() {
		return address;
	}
	
	
	public void setAddress(Address address) {
		this.address = address;
	}
}
