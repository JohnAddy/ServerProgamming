package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import data.Book;

@Path("/bookservice")
public class BookService {
	
	
	@POST
	@Path("/addbook")
	@Consumes("application/x-www-form-urlencoded") //Method can receive POSTed data from an html form
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> addBook(@FormParam("name") String name, @FormParam("pages") int pages){
		Book book=new Book();
		book.setName(name);
		book.setPages(pages);
		File file=new File("books.dat");
		ArrayList<Book> list=new ArrayList<>();
		if (file.exists()) {
			list=this.readBooks();
		}
		try {
			list.add(book);
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
		}
		catch(FileNotFoundException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;       
	}
	
	private ArrayList<Book> readBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Path("/getonebook/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBook(@PathParam("id") int id) {
		ArrayList<Book> list=getBooks();
		Book book=list.get(id);
		ResponseBuilder builder = Response.ok(book);
		return builder.build();
	}

	@GET
	@Path("/getallbooks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBooks() {
		ArrayList<Book> list=getBooks();
		ResponseBuilder builder = Response.ok(list);
		return builder.build();
	}

	private ArrayList<Book> getBooks() {
		// TODO Auto-generated method stub
		ArrayList<Book> list=new ArrayList<>();
		Book b=new Book(1, "The Man in the Woods", 202);
		list.add(b);
		b=new Book(2, "Great Man", 2000);
		list.add(b);
		b=new Book(3, "Gold Coast", 160);
		list.add(b);
		
		return list;
	}
	@POST
	@Path("/addonebook")
	@Consumes(MediaType.APPLICATION_JSON) //Method can receive POSTed data from an html form
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> addOneBook(Book book){

		File file=new File("books.dat");
		ArrayList<Book> list=new ArrayList<>();
		if (file.exists()) {
			list=this.readOneBooks();
		}
		try {
			list.add(book);
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
		}
		catch(FileNotFoundException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;    

	}

	private ArrayList<Book> readOneBooks() {
		// TODO Auto-generated method stub
		return null;
	}
}