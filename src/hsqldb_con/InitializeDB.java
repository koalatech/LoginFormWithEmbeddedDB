package hsqldb_con;
import java.sql.*;

public class InitializeDB {
    public Connection con;
    public Statement st;
    public PreparedStatement pst = null;
    public ResultSet rs;
    
    
    public InitializeDB(){
        final String DRIVER = "org.hsqldb.jdbcDriver";
        final String JDBC_URL = "jdbc:hsqldb:file:testdb;ifexists=true";
        try{
           Class.forName(DRIVER); 
           con =  DriverManager.getConnection(JDBC_URL);
           st = con.createStatement();
           
          
           
           //Insert data to table
           con.createStatement().execute("insert into accounts values "
                                         + "('admin','admin')");
                                   
        
        //   con.close();
        }catch(Exception ex){
            System.out.println("ERROR: " + ex);
        }
    }
    
   public void createTable()throws SQLException{
        //Create table
           con.createStatement().execute("create table accounts("
                                        + "username varchar(20),"
                                        + "password varchar(20))");
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
        InitializeDB t =new InitializeDB();
        t.selectData();
        System.out.println("My Change v3");
    }
}