package io.mart.xstream.simpleExample;

import com.thoughtworks.xstream.XStream;

public class TestDrive {
    public static void main(String[] args) {

        PhoneNumber phoneNumber1 = new PhoneNumber(911, "123456789");
        PhoneNumber phoneNumber2 = new PhoneNumber(911, "1234");

        Person person = new Person("Alex", "Mart");
        person.setFax(phoneNumber1);
        person.setPhone(phoneNumber2);

        XStream xStream = new XStream();

        xStream.alias("person", Person.class);

        String xml = xStream.toXML(person);
        System.out.println(xml);
    }
}
