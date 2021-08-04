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
public class Menu {

    //Objeto tipo WebDriver
    WebDriver driver;

    //Objetos
    By linkDeleteCustomer = By.linkText("Delete Customer");
    By linkNewCustomer = By.linkText("New Customer");
    By linkEditCustomer = By.linkText("Edit Customer");

    //Constructor
    public Menu(WebDriver driver) {
        this.driver = driver;
    }

    //Acciones
    //Dar clic hipervinculo Delete Customer
    public void clickDeleteCustomer() {
        driver.findElement(linkDeleteCustomer).click();
    }

    //Dar clic hipervinculo New Customer
    public void clickNewCustomer() {
        driver.findElement(linkNewCustomer).click();
    }

    //Dar clic hipervinculo Edit Customer
    public void clickEditCustomer() {
        driver.findElement(linkEditCustomer).click();
    }

}
