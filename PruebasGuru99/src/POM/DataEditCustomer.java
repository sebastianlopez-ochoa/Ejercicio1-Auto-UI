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
public class DataEditCustomer {

    //Objeto tipo WebDriver
    WebDriver driver;

    //Objetos
    By dataCustomerName = By.name("name");
    By dataCustomerGender = By.name("gender");
    By dataCustomerDate = By.name("dob");
    By dataCustomerAddress = By.name("addr");
    By dataCustomerCity = By.name("city");
    By dataCustomerState = By.name("state");
    By dataCustomerPin = By.name("pinno");
    By dataCustomerNumber = By.name("telephoneno");
    By dataCustomerEmail = By.name("emailid");

    //Constructor
    public DataEditCustomer(WebDriver driver) {
        this.driver = driver;
    }

    //Acciones
    //Retornar lo que contiene los inputs text
    public String getDataCustomerName() {
        String x = driver.findElement(dataCustomerName).getAttribute("value");
        return x;
    }

    public String getDataCustomerGender() {
        String x = driver.findElement(dataCustomerGender).getAttribute("value");
        return x;
    }

    public String getDataCustomerDate() {
        String x = driver.findElement(dataCustomerDate).getAttribute("value");
        return x;
    }

    public String getDataCustomerAddress() {
        String x = driver.findElement(dataCustomerAddress).getAttribute("value");
        return x;
    }

    public String getDataCustomerCity() {
        String x = driver.findElement(dataCustomerCity).getAttribute("value");
        return x;
    }

    public String getDataCustomerState() {
        String x = driver.findElement(dataCustomerState).getAttribute("value");
        return x;
    }

    public String getDataCustomerPin() {
        String x = driver.findElement(dataCustomerPin).getAttribute("value");
        return x;
    }

    public String getDataCustomerNumber() {
        String x = driver.findElement(dataCustomerNumber).getAttribute("value");
        return x;
    }

    public String getDataCustomerEmail() {
        String x = driver.findElement(dataCustomerEmail).getAttribute("value");
        return x;
    }

}
