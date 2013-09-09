package at.apa.prototype.backend.rest;

import at.apa.prototype.backend.ejb.UserServiceLocal;
import at.apa.prototype.backend.entity.User;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Provider
@Path("/user")
public class UserResource {

	@EJB
	UserServiceLocal service;

	@GET
	@Path ("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam ("id") int id) throws NamingException {
		User user = service.getUser(id);
		return Response.status(Response.Status.OK).entity(user).build();
	}


	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() throws NamingException {
		final GenericEntity<List<User>> entity = new GenericEntity<List<User>>(service.getUsers()) { };
		return Response.status(Response.Status.OK).entity(entity).build();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(User user) throws NamingException {
		service.addUser(user);
		return Response.status(Response.Status.CREATED).entity(user.getId()).build();
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response changeUser(User user) throws NamingException {
		service.changeUser(user);
		return Response.status(Response.Status.CREATED).entity(user.getId()).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteUser(@PathParam("id") int id) throws NamingException {
		service.deleteUser(id);
		return Response.status(Response.Status.OK).build();
	}
}
