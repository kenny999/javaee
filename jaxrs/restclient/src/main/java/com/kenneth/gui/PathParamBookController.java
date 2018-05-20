package com.kenneth.gui;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kenneth.model.Book;

@Named
@ViewScoped
public class PathParamBookController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String param;

	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void submit() {
		Client client = ClientBuilder.newClient();
		Response response = null;
		try {
			response = client.target(new URI("http://localhost:8080/restserver/rest-prefix/books/")).path(param)
					.request(MediaType.APPLICATION_JSON).get();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		book = response.readEntity(Book.class);
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

}
