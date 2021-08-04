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
    By titleRegisteredSuccessfully = By.className("heading3");

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

    //Retorna el titulo cuando se crea un nuevo cliente: Customer Registered Successfully!!!
    public String getTitleRegisteredSuccessfully() {
        String x = driver.findElement(titleRegisteredSuccessfully).getText();
        return x;
    }

}
