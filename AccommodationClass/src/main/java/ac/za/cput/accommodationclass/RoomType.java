
package ac.za.cput.accommodationclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class RoomType {
    
   static final String DATABASE_URL = "jdbc:derby://localhost:1527/AccommodationDB";
   private final String username = "Administration";
   private final String password = "Password";
     
    private String uniName;
    private String typeOfRoom;
    private String costPerMonth;
    private String locationType;

 
    RoomType (String UniName, String TypeOfRoom, String CostPerMonth, String LocationType) {
    this.uniName = UniName; 
       this.typeOfRoom = TypeOfRoom; 
          this.costPerMonth = CostPerMonth; 
             this.locationType = LocationType; 
}
 @Override
    public String toString() {
        return  "TYPEOFROOM=" + "UniName=" + uniName +
                ", TypeOfRoom=" + typeOfRoom + 
                ", CostPerMonth=" + costPerMonth +
                ", LocationType=" + locationType +'}';   
    }    

  
 
       public boolean save(){
   
Connection connection = null;
Statement statement = null;
int ok;
boolean success = true;

try {

connection = DriverManager.getConnection( DATABASE_URL, username , password );
statement = connection.createStatement();
ok = statement.executeUpdate("INSERT INTO TYPEOFROOMS VALUES( '"+uniName+"' , '"+typeOfRoom+"' , '"+costPerMonth+"' , '"+locationType+"')");

if(ok>0){
JOptionPane.showMessageDialog(null, "Successfully Saved The Information");
System.exit(0);
}
else{
JOptionPane.showMessageDialog(null, "ERROR : Could not save Information");
success = false;

}
}
catch(SQLException sqlexception){
JOptionPane.showMessageDialog(null, "ERROR : Could not save Information" + sqlexception);
success = false;


}
catch(Exception exception ){
JOptionPane.showMessageDialog(null, "ERROR : The From Will Reset" +exception);
success = false;


}
   finally {

try{

if(statement != null);
   statement.close();
}
catch(Exception exception){
JOptionPane.showMessageDialog(null, exception.getMessage(), "WARNING", JOptionPane.ERROR_MESSAGE);
}

try{
if(connection != null);
   connection.close();
}
catch(Exception exception){
JOptionPane.showMessageDialog(null, exception.getMessage(), "WARNING", JOptionPane.ERROR_MESSAGE);         }

}
      return success; }

}
        
