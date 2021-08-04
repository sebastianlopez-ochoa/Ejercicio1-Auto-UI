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
public class Login {

    //Objeto tipo WebDriver
    WebDriver driver;

    //Objetos
    By txtUserId = By.name("uid");
    By txtPassword = By.name("password");
    By btnLogin = By.name("btnLogin");

    //Constructor
    public Login(WebDriver driver) {
        this.driver = driver;
    }

    //Acciones
    //Rellenar campo userId
    public void setTxtUserId(String id) {
        driver.findElement(txtUserId).sendKeys(id);
    }

    //Rellenar campo password
    public void setTxtPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    //Dar clic boton login
    public void clickLogin() {
        driver.findElement(btnLogin).click();
    }

    //Invoco las acciones que cree anteriormente
    public void formLogin(String id, String password) {
        this.setTxtUserId(id);
        this.setTxtPassword(password);
        this.clickLogin();
    }
    
}
