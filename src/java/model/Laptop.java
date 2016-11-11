/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Duyet
 */
public class Laptop {
    private String lapID, lapName;
    private int price;

    public String getLapID() {
        return lapID;
    }

    public void setLapID(String lapID) {
        this.lapID = lapID;
    }

    public String getLapName() {
        return lapName;
    }

    public void setLapName(String lapName) {
        this.lapName = lapName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Laptop() {
    }

    public Laptop(String lapID, String lapName, int price) {
        this.lapID = lapID;
        this.lapName = lapName;
        this.price = price;
    }
    
    
}
