/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.forth.ics.rdf2db;

import java.io.File;
import java.sql.Connection;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.riot.RDFDataMgr;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author mhalkiad
 */

public class Main {
    
    private static String url = "jdbc:postgresql://localhost:5432/ics1175";
    private static Connection con = null;
    private static java.sql.Statement sqlStmt = null;
            
    public static void main(String[] args) {
        
        // get a jena model from Turtle output
        Model model = RDFDataMgr.loadModel(System.getProperty("user.dir") + File.separator + args[0]);
        try {
            
            // connect to Postgres and create a new sql statement
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, "postgres", "postgres");
            sqlStmt = con.createStatement();
            
            // iterate the jena model
            StmtIterator iter = model.listStatements();
            while (iter.hasNext()) {
                Statement stmt = iter.nextStatement();
                Resource  subject   = stmt.getSubject();
                Property  predicate = stmt.getPredicate();
                RDFNode object = stmt.getObject();
                
                // check for literal into statement and then insert to Postgres
                if(object.isLiteral()) {
                   String query = "insert into literals values ('" + object.toString() + "')";
                   // update the Postgres
                   sqlStmt.executeUpdate(query);
                }                
            }      
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) { 
                    con.close(); 
                }
                if (sqlStmt != null ) { 
                    sqlStmt.close(); 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }  
        }           
    }
}
