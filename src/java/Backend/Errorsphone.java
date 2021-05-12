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
public class Errorsphone {
    
private boolean allValid = true;
private boolean brandMissing = false;
private boolean familyMissing =false;
private boolean modelMising = false;
private boolean imeilegal = false;
private boolean pricelow = false;
private boolean priceNonnumeric = false;

    public boolean isAllValid() {
        return allValid;
    }

    public void setAllValid(boolean allValid) {
        this.allValid = allValid;
    }

    public boolean isBrandMissing() {
        return brandMissing;
    }

    public void setBrandMissing(boolean brandMissing) {
        this.brandMissing = brandMissing;
    }

    public boolean isFamilyMissing() {
        return familyMissing;
    }

    public void setFamilyMissing(boolean familyMissing) {
        this.familyMissing = familyMissing;
    }

    public boolean isModelMising() {
        return modelMising;
    }

    public void setModelMising(boolean modelMising) {
        this.modelMising = modelMising;
    }

    public boolean isImeilegal() {
        return imeilegal;
    }

    public void setImeilegal(boolean imeilegal) {
        this.imeilegal = imeilegal;
    }

    public boolean isPricelow() {
        return pricelow;
    }

    public void setPricelow(boolean pricelow) {
        this.pricelow = pricelow;
    }

    public boolean isPriceNonnumeric() {
        return priceNonnumeric;
    }

    public void setPriceNonnumeric(boolean priceNonnumeric) {
        this.priceNonnumeric = priceNonnumeric;
    }



}
