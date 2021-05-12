/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author rajanbastakoti
 */
public class Entity {
   private String brand;
   private String family;
   private String model;
   private String imei;
   private Double price;

 //constructor to force object have required members 
    public Entity(String brand, String family, String model, String imei, Double price) {
        this.brand = brand;
        this.family = family;
        this.model = model;
        this.imei = imei;
        this.price = price;
    }
//generate getter and setter
//getter methods will be used in expression language
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
   
    
   
  
    
}
