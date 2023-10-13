package io.mart.family;

public class TestCode {
	
	public static void main(String[] args) {
		GrandPa grandPa = new GrandPa();
		System.out.println("Real gradPa name is :" + grandPa.getPublicName());
		
		GrandPa grandPaFatherActually = new Father();
		System.out.println("gradPa type, but father instance:  " + grandPaFatherActually.getPublicName());
		
		GrandPa grandPaSonActually = new Son();
		System.out.println("gradPa type, but son instance:  " + grandPaSonActually.getPublicName());
	}
	
}

class GrandPa {
	private String publicName = "GrandPaName";
	
	public String getPublicName() {
		return publicName;
	}
}

class Father extends GrandPa {
	private String publicName = "FatherName";
	
	public String getPublicName() {
		return publicName;
	}
}

class Son extends Father{
	private String publicName = "SonName";
	
	public String getPublicName() {
		return publicName;
	}
}
