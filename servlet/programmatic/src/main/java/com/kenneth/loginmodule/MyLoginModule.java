package com.kenneth.loginmodule;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;

@SuppressWarnings("unused")
public class MyLoginModule implements LoginModule {

	private final static String ROLE_PROPERTY_PREFIX = "bks.auth.adgroup.friendly.role";

	private Subject subject;
	private CallbackHandler callbackHandler;
	private Map<String, ?> options;

	private Anvandare principal;
	private char[] password;
	private String username;

	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		this.options = options;

	}

	public boolean login() throws LoginException {
		NameCallback nameCallback = new NameCallback("Name:");
		PasswordCallback passwordCallback = new PasswordCallback("Password:", false);
		Callback[] callbacks = new Callback[] { nameCallback, passwordCallback };

		try {
			callbackHandler.handle(callbacks);
		} catch (IOException e1) {
			logAndThrowLoginException(e1.getMessage(), e1);
		} catch (UnsupportedCallbackException e2) {
			logAndThrowLoginException(e2.getMessage(), e2);
		}
		String name = nameCallback.getName();
		if (name == null || name.isEmpty()) {
			logAndThrowLoginException("Inget användarnamn angivet.");
		}

		password = passwordCallback.getPassword();
		if (password == null || password.length == 0) {
			logAndThrowLoginException("Inget lösenord angivet.");
		}
		username = name;
		loadUserDataFromBackend(name, String.valueOf(password));
		return true;
	}

	public boolean commit() throws LoginException {
		Set<Principal> principals = subject.getPrincipals();

		// Lägg till rollerna. De måste ligga i en grupp Roles för att det ska
		// fungera i JBoss AS och Seam
		SimpleGroup group = new SimpleGroup("Roles");
		String role = "";

		if(username.equals("user")){
			role = "user";
		} else if(username.equals("admin")){
			role = "admin";
		}

		group.addMember(new SimplePrincipal(role));
		principals.add(group); // JBoss AS kräver att man skapar en principal
		// enligt följande
		SimpleGroup callerPrincipal = new SimpleGroup("CallerPrincipal");
		callerPrincipal.addMember(principal);
		principals.add(callerPrincipal);

		// Seam kräver att man gör enligt följande
		principals.add(principal);

		subject.getPrivateCredentials().add(password);

		return true;
	}

	public boolean abort() throws LoginException {
		return true;
	}

	public boolean logout() throws LoginException {
		return true;
	}

	private void logAndThrowLoginException(String message, Exception e) throws LoginException {
		throw new LoginException(message);
	}

	private void logAndThrowLoginException(String message) throws LoginException {
		throw new LoginException(message);
	}

	private void loadUserDataFromBackend(String name, String password) throws LoginException {
		
		if(! name.equals(password)){
			throw new LoginException("Felaktigt passord");
		}
		if(name.equals("user")){
			// ok
		} else if(name.equals("admin")){
			// ok
		} else {
			throw new LoginException("Felaktig användare");			
		}

		principal = new Anvandare();
		if(username.equals("user")){
			principal.setName("kalle jonsson");
		} else if(username.equals("admin")){
			principal.setName("anna nicholaus");
		}
		
		
		
	}
}
