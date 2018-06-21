package com.kenneth;

import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.json.JsonValue.ValueType;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import javax.naming.spi.ObjectFactoryBuilder;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.faces.view.ViewScoped;

@Named
@ViewScoped
public class TestController implements Serializable {

	private static final long serialVersionUID = 1L;

	public void objectbuilder() {

		Map<String, Boolean> config = new HashMap<>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		JsonBuilderFactory factory = Json.createBuilderFactory(config);
		JsonObject value = factory.createObjectBuilder().add("firstName", "John").add("lastName", "Smith")
				.addNull("unknownproperty").add("age", 25)
				.add("address",
						factory.createObjectBuilder().add("streetAddress", "21 2nd Street").add("city", "New York")
								.add("state", "NY").add("postalCode", "10021"))
				.add("phoneNumber",
						factory.createArrayBuilder()
								.add(factory.createObjectBuilder().add("type", "home").add("number", "212 555-1234"))
								.add(factory.createObjectBuilder().add("type", "fax").add("number", "646 555-4567")))
				.build();
		System.out.println(value.toString());

		String firstName = value.getString("firstName");
		String lastName = value.getString("lastName");
		if (value.isNull("unknownproperty")) {
			int ii = 0;
		}
		int age = value.getInt("age");
		JsonObject address = value.getJsonObject("address");

		int i = 0;

	}

	public void objectbuilder2() {
		Person person = new Person();
		person.setFirstName("anders");
		person.setLastName("olsson");
		person.setBirthdate(new Date());
		JsonObjectBuilder objectBuilder = Json.createObjectBuilder().add("firstName", person.getFirstName())
				.add("lastName", person.getLastName())
				.add("birthdate", new SimpleDateFormat("DD/MM/YYYY").format(person.getBirthdate()));
		String s = objectbuilderToString(objectBuilder);
		int i = 0;
	}
	
	public void arraybuilder() {
		Person person = new Person();
		person.setFirstName("anders");
		person.setLastName("olsson");
		person.setBirthdate(new Date());
		person.setEmails(new ArrayList<>());
		person.getEmails().add("k@a.com");
		person.getEmails().add("kenneth@anders.com");
		person.getEmails().add("eva@olsson.com");

		JsonObjectBuilder objectBuilder = Json.createObjectBuilder().add("firstName", person.getFirstName())
				.add("lastName", person.getLastName())
				.add("birthdate", new SimpleDateFormat("DD/MM/YYYY").format(person.getBirthdate()));
		
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        
		for(String email : person.getEmails()) {
		    arrayBuilder.add(email);
		}
		         
		objectBuilder.add("emails", arrayBuilder);
		
		String s = objectbuilderToString(objectBuilder);
		int i = 0;
	}
	
	public void stringToJson(){
		
		String jsonString = 
			"{"+
			"	    \"firstName\":\"anders\","+
			"	    \"lastName\":\"olsson\","+
			"	    \"birthdate\":\"140/05/2018\","+
			"	    \"emails\":["+
			"	        \"k@a.com\","+
			"	        \"kenneth@anders.com\","+
			"	        \"eva@olsson.com\""+
			"	    ]"+
			"	}";


		JsonReader reader = Json.createReader(new StringReader(jsonString));
		 
		JsonObject jsonObject = reader.readObject();
		Person person = new Person();

		try {
			
			 
			person.setFirstName(jsonObject.getString("firstName"));
			person.setLastName(jsonObject.getString("lastName"));
			person.setBirthdate(new SimpleDateFormat("DD/MM/YYYY").parse(jsonObject.getString("birthdate")));
			JsonArray emailsJson = jsonObject.getJsonArray("emails");
			 
			List<String> emails = new ArrayList<>();
			 
			for (JsonString j : emailsJson.getValuesAs(JsonString.class)) {
			    emails.add(j.getString());
			}
			 
			person.setEmails(emails);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		
	}
	
	private String objectbuilderToString(JsonObjectBuilder objectBuilder){
		Map<String, Boolean> config = new HashMap<>();
		 
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		JsonObject jsonObject = objectBuilder.build();
		String jsonString = null;
		         
		JsonWriterFactory writerFactory = Json.createWriterFactory(config);
		try(Writer writer = new StringWriter()) {
		    writerFactory.createWriter(writer).write(jsonObject);
		    jsonString = writer.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
	}
}
