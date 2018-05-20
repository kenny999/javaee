package com.kenneth.gui;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kenneth.model.Beverage;
import com.kenneth.model.Book;
import com.kenneth.model.Pub;

@Named
@ViewScoped
public class PostBeverageController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> availableFormats;
	private String format;

	private Pub pub;

	private static final String FORMAT_JSON = "Json";
	private static final String FORMAT_XML = "XML";

	@PostConstruct
	public void init() {
		availableFormats = new ArrayList<>();
		availableFormats.add("");
		availableFormats.add(FORMAT_JSON);
		availableFormats.add(FORMAT_XML);

	}

	public void onChange() {
		if (format.equals(FORMAT_JSON)) {
			postJson();

		} else if (format.equals(FORMAT_XML)) {
			postXml();
		}
	}

	private void postJson() {
		Client client = ClientBuilder.newClient();
		Response response = null;
		try {
			Beverage b = createBeverage();
			WebTarget target = client.target(new URI("http://localhost:8080/restserver/rest-prefix/beverage"));
			Builder request = target
					.request(MediaType.APPLICATION_JSON);
			response = request.post(Entity.json(b));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pub = response.readEntity(Pub.class);
		int i = 0;
	}

	private void postXml() {
		Client client = ClientBuilder.newClient();
		Response response = null;
		try {
			Beverage b = createBeverage();
			Entity<Beverage> xml = Entity.xml(b);
			WebTarget target = client.target(new URI("http://localhost:8080/restserver/rest-prefix/beverage"));
			Builder request = target.request();
			Builder accept = request
					.accept(MediaType.APPLICATION_XML);
			response = accept
					.post(xml);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (response.getStatus() == 200) {
			pub = response.readEntity(Pub.class);
		}
		int i = 0;
	}

	public Pub getPub() {
		return pub;
	}

	public void setPub(Pub pub) {
		this.pub = pub;
	}

	private Beverage createBeverage() {
		Beverage b = new Beverage();
		b.setAlcoholic(true);
		b.setName("Norrlands guld");
		b.setQuantity(4);
		return b;
	}

	public List<String> getAvailableFormats() {
		return availableFormats;
	}

	public void setAvailableFormats(List<String> availableFormats) {
		this.availableFormats = availableFormats;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
