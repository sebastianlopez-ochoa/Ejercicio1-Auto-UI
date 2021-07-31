/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author SEBASTIAN
 */
public class CustomerRegistered {

    //Objeto tipo WebDriver
    WebDriver driver;

    //Objetos
    By dataCustomerId = By.xpath("//tbody/tr[4]/td[2]");  
    By dataCustomerName = By.xpath("//tbody/tr[5]/td[2]");
    By dataCustomerGender = By.xpath("//tbody/tr[6]/td[2]");
    By dataCustomerDate = By.xpath("//tbody/tr[7]/td[2]");
    By dataCustomerAddress = By.xpath("//tbody/tr[8]/td[2]");
    By dataCustomerCity = By.xpath("//tbody/tr[9]/td[2]");
    By dataCustomerState = By.xpath("//tbody/tr[10]/td[2]");
    By dataCustomerPin = By.xpath("//tbody/tr[11]/td[2]");
    By dataCustomerNumber = By.xpath("//tbody/tr[12]/td[2]");
    By dataCustomerEmail = By.xpath("//tbody/tr[13]/td[2]");
    

    //Constructor
    public CustomerRegistered(WebDriver driver) {
        this.driver = driver;
    }

    //Acciones
    //Retorna el campo de Customer ID
    public String getDataCustomerId() {
        String x = driver.findElement(dataCustomerId).getText();
        return x;
    }  
    public String getDataCustomerName() {
        String x = driver.findElement(dataCustomerName).getText();
        return x;
    }  
    public String getDataCustomerGender() {
        String x = driver.findElement(dataCustomerGender).getText();
        return x;
    }
    public String getDataCustomerDate() {
        String x = driver.findElement(dataCustomerDate).getText();
        return x;
    }
    public String getDataCustomerAddress() {
        String x = driver.findElement(dataCustomerAddress).getText();
        return x;
    }
    public String getDataCustomerCity() {
        String x = driver.findElement(dataCustomerCity).getText();
        return x;
    }
    public String getDataCustomerState() {
        String x = driver.findElement(dataCustomerState).getText();
        return x;
    }
    public String getDataCustomerPin() {
        String x = driver.findElement(dataCustomerPin).getText();
        return x;
    }
    public String getDataCustomerNumber() {
        String x = driver.findElement(dataCustomerNumber).getText();
        return x;
    }
    public String getDataCustomerEmail() {
        String x = driver.findElement(dataCustomerEmail).getText();
        return x;
    }
}
