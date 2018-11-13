package io.mart.attach.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

public class FileClient {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// instead of using Client from JAX-RS, if you want to use attachments => use this client from apache cxf
		WebClient client = WebClient.create("http://localhost:8080/attach/services/fileservice/upload");
		client.type("multipart/form-data");
		
		ContentDisposition cd = new ContentDisposition("attachement;filename=rsz_aleks_1_.jpg");
		
		Attachment attachment = new Attachment("root", new FileInputStream(new File("/Users/aleksandr.m/Downloads/rsz_aleks_1_.jpg")), cd);
		
		client.post(attachment);
	}
	
}
