package com.kenneth.loginmodule;

import java.security.acl.Group;

import javax.security.auth.login.LoginException;

import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;

public class DerivedLoginModule extends UsernamePasswordLoginModule {

	@Override
	protected String getUsersPassword() throws LoginException {
		String userName = getUsername();
		if (userName.equals("user")) {
			return "user";
		} else if (userName.equals("admin")) {
			return "admin";
		}
		return null;
	}

	@Override
	protected Group[] getRoleSets() throws LoginException {
		SimpleGroup group = new SimpleGroup("Roles");

		String userName = getUsername();
		if (userName.equals("user")) {
			group.addMember(new SimplePrincipal("user"));
			return new Group[] { group };

		} else if (userName.equals("admin")) {
			group.addMember(new SimplePrincipal("admin"));
			return new Group[] { group };
		}
		return null;
	}
}
