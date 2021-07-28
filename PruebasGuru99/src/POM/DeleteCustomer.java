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
public class DeleteCustomer {

    //Objeto tipo WebDriver
    WebDriver driver;

    //Objetos
    By txtCustomerId = By.name("cusid");
    By btnSubmit = By.name("AccSubmit");

    //Constructor
    public DeleteCustomer(WebDriver driver) {
        this.driver = driver;
    }

    //Acciones
    //Rellenar campo customerId
    public void setTxtCustomerId(String id) {
        driver.findElement(txtCustomerId).sendKeys(id);
    }

    //Dar clic boton login
    public void clickSubmit() {
        driver.findElement(btnSubmit).click();
    }

    //Invoco las acciones que cree anteriormente
    public void formDelete(String id) {
        this.setTxtCustomerId(id);
        this.clickSubmit();
    }
}
