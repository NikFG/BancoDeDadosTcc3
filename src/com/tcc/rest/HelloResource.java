package com.tcc.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloResource {
	@GET
	public String get(){
		return "Hello get";
	}
	@POST
	public String post(){
		return "Hello POST";
	}
	@PUT
	public String put(){
		return "hello put";
	}
	
	@DELETE
	public String delete(){
		return "hello delete";
	}

}
