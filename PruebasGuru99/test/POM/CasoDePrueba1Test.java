/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Esteban
 */
public class CasoDePrueba1Test {

    private static WebDriver driver = null;

    //Creo objetos de la clase de objetos
    Login login;
    Menu menu;
    NewCustomer newCustomer;
    Random r = new Random();

    //Licencias
    String userId = "mngr344087";
    String password = "UnupahA";

    //Informacion cliente
    String name = "";
    String address = "Cruce Estrella, NY City, Algonquin, in GTA IV";
    String city = "New York";
    String state = "USA";
    int number = 1234567890;
    String date = "12/12/2000";
    String email = "";
    String pass = "";
    String pin = "";

    public CasoDePrueba1Test() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/index.php");
        login = new Login(driver);
        menu = new Menu(driver);
        newCustomer = new NewCustomer(driver);

        //Preparacion
        String nameEmail = "";
        String alphabet = "qwertyuiopasdfghjklzxcvbnm1234567890";
        for (int x = 0; x < 9; x++) {
            nameEmail = nameEmail + (alphabet.charAt(r.nextInt(alphabet.length())));
        }

        pass = "";
        for (int x = 0; x < 9; x++) {
            pass = pass + (alphabet.charAt(r.nextInt(alphabet.length())));
        }

        pin = "";
        String numbers = "1234567890";
        for (int x = 0; x < 6; x++) {
            pin = pin + (numbers.charAt(r.nextInt(numbers.length())));
        }

        email = nameEmail + "@gmail.com";
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    //Caso de prueba 1: Verifique que el campo “Customer Name” es obligatorio.
    @Test
    public void testNewCustomer1() {
        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice New Customer
        menu.clickNewCustomer();
        //Lleno el formulario de New Customer (excepto el campo de customer name) y le doy clic al boton Submit        
        newCustomer.formNew(name, address, city, state, pin, number, email, pass, date);
        //Capturo la alerta
        String Warning = driver.switchTo().alert().getText();

        //Verificacion
        //Si la alerta dice "please fill all fields", se confirma la condicion de obligatoriedad
        assertEquals("El campo Customer Name no es obligatorio", Warning, "please fill all fields");
    }

    @Test
    public void testNewCustomer2() {
        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice New Customer
        menu.clickNewCustomer();
        //Lleno el formulario de New Customer (excepto el campo de customer name) y le doy clic al boton Submit        
        newCustomer.formNew(name, address, city, state, pin, number, email, pass, date);
        //Capturo la alerta
        String Warning = driver.switchTo().alert().getText();

        //Verificacion
        //Si la alerta dice "please fill all fields", se confirma la condicion de obligatoriedad
        assertEquals("El campo Customer Name no es obligatorio", Warning, "please fill all fields");
    }

    @Test
    public void testNewCustomer3() {
        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice New Customer
        menu.clickNewCustomer();
        //Lleno el formulario de New Customer (excepto el campo de customer name) y le doy clic al boton Submit        
        newCustomer.formNew(name, address, city, state, pin, number, email, pass, date);
        //Capturo la alerta
        String Warning = driver.switchTo().alert().getText();

        //Verificacion
        //Si la alerta dice "please fill all fields", se confirma la condicion de obligatoriedad
        assertEquals("El campo Customer Name no es obligatorio", Warning, "please fill all fields");
    }

    @Test
    public void testNewCustomer4() {
        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice New Customer
        menu.clickNewCustomer();
        //Lleno el formulario de New Customer (excepto el campo de customer name) y le doy clic al boton Submit        
        newCustomer.formNew(name, address, city, state, pin, number, email, pass, date);
        //Capturo la alerta
        String Warning = driver.switchTo().alert().getText();

        //Verificacion
        //Si la alerta dice "please fill all fields", se confirma la condicion de obligatoriedad
        assertEquals("El campo Customer Name no es obligatorio", Warning, "please fill all fields");
    }

    @Test
    public void testNewCustomer5() {
        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice New Customer
        menu.clickNewCustomer();
        //Lleno el formulario de New Customer (excepto el campo de customer name) y le doy clic al boton Submit        
        newCustomer.formNew(name, address, city, state, pin, number, email, pass, date);
        //Capturo la alerta
        String Warning = driver.switchTo().alert().getText();

        //Verificacion
        //Si la alerta dice "please fill all fields", se confirma la condicion de obligatoriedad
        assertEquals("El campo Customer Name no es obligatorio", Warning, "please fill all fields");
    }

}
