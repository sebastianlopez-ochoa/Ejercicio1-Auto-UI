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
 * @author Wilber
 */
public class NewCustomer {

    //Objeto tipo WebDriver
    WebDriver driver;

    //Objetos
    By txtCustomerName = By.name("name");
    By txtCustomerAddress = By.name("addr");
    By txtCustomerCity = By.name("city");
    By txtCustomerState = By.name("state");
    By txtCustomerPin = By.name("pinno");
    By txtCustomerNumber = By.name("telephoneno");
    By txtCustomerEmail = By.name("emailid");
    By txtCustomerPassword = By.name("password");
    By btnSubmit = By.name("sub");
    By dates = By.name("dob");

    //Constructor
    public NewCustomer(WebDriver driver) {
        this.driver = driver;
    }

    //Acciones
    //Rellenar campos
    public void setTxtCustomerName(String Name) {
        driver.findElement(txtCustomerName).sendKeys(Name);
    }

    public void setTxtCustomerAddress(String Address) {
        driver.findElement(txtCustomerAddress).sendKeys(Address);
    }

    public void setTxtCustomerCity(String City) {
        driver.findElement(txtCustomerCity).sendKeys(City);
    }

    public void setTxtCustomerState(String State) {
        driver.findElement(txtCustomerState).sendKeys(State);
    }

    public void setTxtCustomerPin(String Pin) {
        driver.findElement(txtCustomerPin).sendKeys(Pin);
    }

    public void setTxtCustomerNumber(int Number) {
        driver.findElement(txtCustomerNumber).sendKeys(Integer.toString(Number));
    }

    public void setTxtCustomerEmail(String Email) {
        driver.findElement(txtCustomerEmail).sendKeys(Email);
    }

    public void setTxtCustomerPassword(String Password) {
        driver.findElement(txtCustomerPassword).sendKeys(Password);
    }

    public void setDate(String date) {
        driver.findElement(dates).sendKeys(date);
    }

    //Dar clic boton
    public void clickSubmit() {
        driver.findElement(btnSubmit).click();
    }

    //Invoco las acciones que cree anteriormente
    public void formNew(String name, String Address, String city, String state, String pin, int number, String email, String pass, String date) {
        this.setTxtCustomerName(name);
        this.setDate(date);
        this.setTxtCustomerAddress(Address);
        this.setTxtCustomerCity(city);
        this.setTxtCustomerState(state);
        this.setTxtCustomerPin(pin);
        this.setTxtCustomerNumber(number);
        this.setTxtCustomerEmail(email);
        this.setTxtCustomerPassword(pass);
        this.clickSubmit();
    }

}
