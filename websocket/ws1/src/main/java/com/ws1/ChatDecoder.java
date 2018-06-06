package com.ws1;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder.Text;
import javax.websocket.EndpointConfig;

public class ChatDecoder implements Text<BetMessage>{

	@Override
	public void init(EndpointConfig config) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public BetMessage decode(String s) throws DecodeException {
		JsonReader reader = Json.createReader(new StringReader(s));		 
		JsonObject jsonObject = reader.readObject();
		BetMessage msg = new BetMessage();
		msg.setBet(jsonObject.getString("bet"));
		msg.setUser(jsonObject.getString("user"));
		return msg;
	}

	@Override
	public boolean willDecode(String s) {
		return s != null;
	}
}
