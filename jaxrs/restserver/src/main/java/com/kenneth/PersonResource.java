package com.kenneth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kenneth.model.Person;

@Path("/person")
public class PersonResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject f() {
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

		for (String email : person.getEmails()) {
			arrayBuilder.add(email);
		}

		objectBuilder.add("emails", arrayBuilder);
		Map<String, Boolean> config = new HashMap<>();

		config.put(JsonGenerator.PRETTY_PRINTING, true);
		JsonObject jsonObject = objectBuilder.build();
		return jsonObject;
	}
}
