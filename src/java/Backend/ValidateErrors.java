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
public class ValidateErrors {
    
    
public static boolean validateFamily(String family, Errorsphone error){
    
    if("".equals(family.trim())){
        error.setFamilyMissing(true);
        error.setAllValid(true);
        return false;
    }
    else {
        error.setFamilyMissing(false);
        
    }
    return true;
}
    

public static boolean validateBrand(String brand, Errorsphone error){
    if (brand ==null|| brand.equals("choose")){
        error.setBrandMissing(true);
        error.setAllValid(false);
        return false;
    }
    
    return true;
    
}

public static boolean validateModel(String model, Errorsphone error){
    if (model == null|| model.equals("choose")){
        error.setModelMising(true);
        error.setAllValid(false);
        return false;
    }
    return true;
}

public static boolean validateImei(String imei, Errorsphone error){
    
    if ("".equals(imei.trim())) {
        error.setImeilegal(true);
        return false;
    }
    
    String valImei = "\\d{13}";
    if (!imei.trim().matches(valImei)){
        error.setImeilegal(true);
        error.setAllValid(false);
        return false;
        
    }
    else return true;
}



public static boolean validatePrice(String price, Errorsphone error){
 price = price.trim();
 
 if("".equals(price)){
     error.setPriceNonnumeric(true);
     error.setAllValid(false);
     return false;
 }
 
 else {
     try{
     double pricenum = Double.parseDouble(price);
     
     if(pricenum < 0){
         error.setPricelow(true);
         error.setAllValid(false);
         return false;
     }
 }

    catch(NumberFormatException ex){
     error.setPriceNonnumeric(true);
     error.setAllValid(false);
     return false;
     
     }
}

 return true;

}

}