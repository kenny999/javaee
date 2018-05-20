package com.kenneth.gui;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kenneth.model.Car;
import com.kenneth.model.Garage;

@Named
@ViewScoped
public class MatchResourceController implements Serializable {

	private static final long serialVersionUID = 1L;

	public String getContenttype() {
		return contenttype;
	}

	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	private String contenttype;
	private String accept;
	private Garage garage;
	
	public Garage getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	public void submit(){
		Client client = ClientBuilder.newClient();
		Response response = null;
		try {
			Car c = createCar();
			Entity<Car> carAsEntity = null;
			if(contenttype != null && contenttype.equals(MediaType.APPLICATION_JSON)){
				carAsEntity = Entity.json(c);
			} else if (contenttype != null && contenttype.equals(MediaType.APPLICATION_XML)){
				carAsEntity = Entity.xml(c);				
			} else {
				carAsEntity = Entity.text(c);
			}
			WebTarget target = client.target(new URI("http://localhost:8080/restserver/rest-prefix/car"));
			Builder request = null;

			if(contenttype != null && contenttype.equals(MediaType.APPLICATION_JSON)){
				request = target.request(MediaType.APPLICATION_JSON);
			} else if (contenttype != null && contenttype.equals(MediaType.APPLICATION_XML)){
				request = target.request(MediaType.APPLICATION_XML);
			} else {
				request = target.request();
			}
			
			Builder accept = request;

			if(contenttype != null && contenttype.equals(MediaType.APPLICATION_JSON)){
				accept = request.accept(MediaType.APPLICATION_JSON);			
			} else if (contenttype != null && contenttype.equals(MediaType.APPLICATION_XML)){
				accept = request.accept(MediaType.APPLICATION_XML);			
			}
			
			response = accept
					.post(carAsEntity);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (response.getStatus() == 200) {
			garage = response.readEntity(Garage.class);
		}
		int i = 0;
	}

	private Car createCar() {
		Car c = new Car();
		c.setBrand("Volvo");
		c.setModel("S40");
		c.setDescription("Fresh");
		
		return c;
	}


}
