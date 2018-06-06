package com.ws1;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ChatEncoder implements Encoder.Text<BetMessage>{

	@Override
	public void init(EndpointConfig config) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public String encode(BetMessage msg) throws EncodeException {
		JsonObjectBuilder objectBuilder = Json.createObjectBuilder().add("bet", msg.getBet()).add("user", msg.getUser());
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
