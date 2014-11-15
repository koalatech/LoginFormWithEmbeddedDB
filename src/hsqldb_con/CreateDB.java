package hsqldb_con;

//import com.sun.corba.se.impl.util.Version;

//import java.util.logging.Logger;
import java.sql.*;

import java.sql.*; //package to handle SQL Statements
public class CreateDB {
    public Connection con;
    public Statement st;
    public PreparedStatement pst = null;
    public ResultSet rs;
    
    
    public CreateDB(){
        try{
           Class.forName("org.hsqldb.jdbcDriver"); 
           con =  DriverManager.getConnection("jdbc:hsqldb:file:testdb;", "SA", "");
           st = con.createStatement();
           
           //Create table
           con.createStatement().execute("create table accounts("
                                        + "username varchar(20),"
                                        + "password varchar(20))");
           
           //Insert data to table
           con.createStatement().execute("insert into accounts values "
                                         + "('admin','admin')");
                                   
           
        //   con.close();
        }catch(Exception ex){
            System.out.println("ERROR: " + ex);
        }
    }
       public void selectData(){
            try{
                String select_query = "select * from accounts";

                System.out.println("Records from Database: ");
                  rs = st.executeQuery(select_query);

                  while(rs.next()){

                       String username = rs.getString("username");
                       String password = rs.getString("password");
       
                

                       System.out.println("Username: " + username);
                       System.out.println("Password: " + password);
                 }//end of while

            }catch(Exception ex){
                System.out.println(ex);
            }//end of catch
        } 
    
    
    public static void main(String [] args){
        CreateDB t =new CreateDB();
        t.selectData();
        System.out.println("My Change v3");
    }
}