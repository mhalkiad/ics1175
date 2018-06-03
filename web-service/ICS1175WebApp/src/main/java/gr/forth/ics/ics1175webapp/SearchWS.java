/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.forth.ics.ics1175webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONArray;

/**
 *
 * @author mhalkiad
 */

@WebService(serviceName = "SearchWS")
public class SearchWS {
    
    private static String url = "jdbc:postgresql://localhost:5432/ics1175";
    private static Connection con = null;
    private static ResultSet rs = null;
    private static PreparedStatement st = null;
    private static ArrayList<String> literalArray = null;
    private static JSONArray responseLiterals = null;
    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchTerm")
    public String searchTerm(@WebParam(name = "searchTerm") String searchTerm) {
        
        literalArray = new ArrayList<String>();
        try {
            // connect to Postgres and get a list of literals
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, "postgres", "postgres");
            st = con.prepareStatement(""
                    + "SELECT * "
                    + "FROM literals "
                    + "WHERE literal ILIKE '%" + searchTerm + "%'");
            rs = st.executeQuery();
            
            // compares literals from Postgres with searchTerm and add them into an arrayList
            while (rs.next()) {
                System.out.print("Column returned: ");
                System.out.println(rs.getString(1));
                literalArray.add(rs.getString(1));
            }
            
            // create a JSON array with the matching literals 
            responseLiterals = new JSONArray(literalArray);
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        finally {
            try {
                if (con != null) { 
                    con.close(); 
                }
                if (st != null ) { 
                    st.close(); 
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }  
        }           
        return responseLiterals.toString(); 
    }
}
