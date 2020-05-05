package rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Book;

@Path("/bookservice")
public class BookService {

    @POST
    @Path("/addonebook")
    @Consumes(MediaType.APPLICATION_JSON) 
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Book> saveBook(Book book) {
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

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Book> getAll(){
        return this.readBooks();
    }

    @GET
    @Path("/getbook/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(@PathParam("id") int id) {
        ArrayList<Book> list=this.readBooks();
        try {
            return list.get(id);
        }
        catch (IndexOutOfBoundsException e) {
            return new Book("No such book", -1);
        }
    }
    private ArrayList<Book> readBooks(){
        File file=new File("books.dat");
        ArrayList<Book> list=new ArrayList<>();
        if (file.exists()) {
            try {
                FileInputStream fis=new FileInputStream(file);
                ObjectInputStream ois=new ObjectInputStream(fis);
                list=(ArrayList<Book>)ois.readObject();
                ois.close();
                fis.close();
               
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;       
    }
}