package com.ws1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/bet", decoders = ChatDecoder.class, encoders = ChatEncoder.class)
public class BetEndpoint {

	private static Set<String> connectedSessions = new HashSet<>();

	@OnOpen
	public void onConnect(Session session, EndpointConfig ec) {
		connectedSessions.add(session.getId());
	}

	@OnMessage
	public void onMessage(BetMessage msg, Session session) throws IOException, EncodeException {
		for (Session s : session.getOpenSessions()) {
			s.getBasicRemote().sendObject(msg);
		}
	}

	@OnClose
	public void onClose(Session session, CloseReason reason) {
		connectedSessions.remove(session.getId());

		if (reason.equals(CloseReason.CloseCodes.CLOSED_ABNORMALLY)) {

		}
	}

}
