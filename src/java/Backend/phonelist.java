/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.sql.*;
import java.util.*;

/**
 *
 * @author rajanbastakoti
*/


public class phonelist {
    private ArrayList<Entity> phones;
    private String total = null;
    //create an empty list
    public phonelist(){
        this(new ArrayList<Entity>());
    }
   
    public phonelist(ArrayList<Entity> phones) {
        this.phones = phones;
    }
    
    //to get value of the list
    public ArrayList<Entity> getPhones() {
        return phones;
    }
    //addphones to the list of a session
    public void addphones(Entity phones){
        this.phones.add(phones);
    }
    //used to search phones by IMEI (returns object)
    public Entity searchByIMEI(String imei){
        Entity found= null;
        for(Entity iterator: this.phones){
            if(iterator.getImei().equals(imei)){
                found = iterator;
            }
        }
        return found;
    }
    
    public void removed(String Imei){
        int deleted = 1;
        for(int i=0; i < this.phones.size(); i++){
            if (Imei.equals(this.phones.get(i).getImei())){
                deleted = i;
            }
        }
        this.phones.remove(deleted);
    }
    
    public String total(){
        double sum = 0.0;
        for(Entity iterator: this.phones){
            sum = sum+ iterator.getPrice();
            }
        this.total = String.valueOf(sum);
        return total;
    }
    
    
public void loadPhones(){
    Connection connection = null;
    Statement statement = null;
    ResultSet results = null;
    
    try{
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
          
          connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Laptop","app","app");
    }
    
    catch (SQLException ex) {
            System.out.println("Connection failed!");
        }  
     catch (Exception ex) {
            System.out.println("No driver!");
        }
    
    try{
        
        statement = (Statement) connection.createStatement();
        results = statement.executeQuery("select * from Phone");
        
        // run until the records end
    while (results.next()){
        String imei = results.getString("IMEI");
        String brand = results.getString("BRAND");
        String family = results.getString("FAMILY");
        String model = results.getString("MODEL");
        Double price = results.getDouble("PRICE");
        
        
        Entity dataphone = new Entity(brand,family,imei,model,price);
        this.phones.add(dataphone);
    }    
    
    }
    
    catch (SQLException ex) {
        System.out.println("Query failed!");
    }
    
    /**
     *
     * @param imei
     * @param brand
     * @param family
     * @param model
     * @param price
     */
}
    public static void basePhones(String imei, String brand, String family, String model, String price){
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        
        try {
            // Load the appropriate database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            // Connect to the database through that driver, using the 
            // database url and the username and password
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Laptop","app","app");
            
            }
        catch (SQLException ex) {
            System.out.println("Connection failed!");
        }
        catch (Exception ex) {
            System.out.println("No driver!");
        }
        
        try{
            //template to add records
            String template = "insert into Phones" 
                    + "(brand, family, imei, model, model, price)" +
                    "values (?,?,?,?,?)";
            
            statement = connection.prepareStatement(template);
               
            statement.setString(1, brand);
            statement.setString(2, family);
            statement.setString(3, imei);
            statement.setString(4, model);
            statement.setString(5, price);
            
            statement.executeUpdate();
            
        }
        catch(SQLException ex){
            System.out.println("Failed at phone list");
        }
        
        
    }
    
    
    
    
    
    
}    
 

