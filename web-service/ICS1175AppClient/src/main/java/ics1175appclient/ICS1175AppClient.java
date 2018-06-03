/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics1175appclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 *
 * @author mhalkiad
 */

public class ICS1175AppClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
       InputStream is = null;
       BufferedReader br = null;

       try {
            
            System.out.print("Please give the search string: ");
            is = System.in;
            br = new BufferedReader(new InputStreamReader(is));
             
            String line = null;
             
            while ((line = br.readLine()) != null) {
                if (line.equalsIgnoreCase("quit")) {
                    break;
                }
                if (line.length() >= 3) {
                    //call the web service
                    System.out.println("Given string: " + line);
                    System.out.println(searchTerm(line));
                    break;
                }
                System.out.print("Give a search string with more than three characters: ");
            }
       }
        catch (IOException ioe) {
            System.out.println("Exception while reading input " + ioe);
        }
    }

    private static String searchTerm(java.lang.String searchTerm) {
        gr.forth.ics.ics1175webapp.SearchWS_Service service = new gr.forth.ics.ics1175webapp.SearchWS_Service();
        gr.forth.ics.ics1175webapp.SearchWS port = service.getSearchWSPort();
        return port.searchTerm(searchTerm);
    }
}
