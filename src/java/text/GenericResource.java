/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Flor
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
     public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of helloWorld.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public void getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Path("getLetterCount")
    @Consumes(MediaType.APPLICATION_XML)
    public int getLetterCount(String content) {
        System.out.println("getLetterCount:"+content);
        
        int count = 0;
        char[] characters = content.toCharArray();
        for (char character : characters){
            if(Character.isLetter(character)){
              count++;
            }      
        }
        System.out.println("getLetterCount:"+count);
         return count;
    }
    
    @PUT
    @Path("getWordCount")
    @Consumes(MediaType.APPLICATION_XML)
    public int getWordCount(String content) {
        int count = 0;
        System.out.println("getWordCount:"+content);
        
        String[] lines = content.split("\\n");
        for (String line : lines){      //using java for each loop to print elements of string a
            String[] words = line.split("\\s"); // Split the string based on white space
            count = count + words.length;
        }
        System.out.println("getWordCount:"+count);
        return count;
    }

    @PUT
    @Path("getLineCount")
    @Consumes(MediaType.APPLICATION_XML)
    public int getLineCount(String content) {
        System.out.println("getLineCount:"+content);
        
        int count = 0;
        String[] lines = content.split("\\n");
        count = lines.length;
        System.out.println("getLineCount:"+count);
        return count;
    }
}
