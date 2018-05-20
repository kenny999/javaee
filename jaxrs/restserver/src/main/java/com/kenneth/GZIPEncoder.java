package com.kenneth;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;


public class GZIPEncoder { // TODO implements WriterInterceptor {

	public void aroundWriteTo(WriterInterceptorContext ctx) throws IOException, WebApplicationException {
		GZIPOutputStream os = new GZIPOutputStream(ctx.getOutputStream());
		ctx.getHeaders().putSingle("Content-Encoding", "gzip");
		ctx.setOutputStream(os);
		ctx.proceed();
		return;
	}
}