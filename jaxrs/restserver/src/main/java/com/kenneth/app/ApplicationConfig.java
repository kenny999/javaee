package com.kenneth.app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.kenneth.BeverageResource;
import com.kenneth.BookResource;
import com.kenneth.CarResource;
import com.kenneth.GZIPEncoder;
import com.kenneth.ParamsResource;
import com.kenneth.PersonResource;
import com.kenneth.TruckResource;

@ApplicationPath("/rest-prefix")
public class ApplicationConfig extends Application {
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(
        		Arrays.asList(
        				BookResource.class,
        				ParamsResource.class,
        				BeverageResource.class,
        				GZIPEncoder.class,
        				CarResource.class,
        				TruckResource.class,
        				PersonResource.class));
    }
}