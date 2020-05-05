package rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.AnswerDao;
import data.Answer;

@Path("/answerservice")
public class AnswerService {
    
	@POST
    @Path("/addanswer")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAnswer(Answer answer) {
    	AnswerDao.addAnswer(answer);
    }
   
    

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Answer> getAll(){
        return AnswerDao.getAnswers();
    }

    
    @DELETE
    @Path("/delete")
    public boolean deleteAnswer(@QueryParam("id") int id) {
        return AnswerDao.deleteAnswer(id);
    }
    
    
    @PUT
    @Path("/update")
    public boolean updateAnswer(@QueryParam("id") int id) {
        return AnswerDao.updateAnswer(id);
    }
}