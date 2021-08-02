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
    Manager manager;
    NewCustomer newCustomer;
    Random r = new Random();
   
    
    public String numero() { 
        int min_all = 1;
        int max_day = 25;
        //int max_month = 11;      
        Random ran = new Random();
        int day = (int)(Math. random()*30+1);
        //int month = ran.nextInt(max_month) + min_all;
        String dat= day+"/12/2000";
        return dat;
    }
    
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
        manager = new Manager(driver);
        newCustomer = new NewCustomer(driver);
    }
    
    @After
    public void tearDown() {
        //driver.quit();
    }
    
    //Licencias
    String userId = "mngr344087";
    String password = "UnupahA";
    
    @Test
    public void testNewCustomer1() {
                
        String nameEmail ="";       
        String alphabet = "qwertyuiopasdfghjklzxcvbnm1234567890";
        for (int x = 0; x < 9; x++) {
           nameEmail = nameEmail + (alphabet.charAt(r.nextInt(alphabet.length())));
        }
        
        String pass= "";
        for (int x = 0; x < 9; x++) {
           pass = pass + (alphabet.charAt(r.nextInt(alphabet.length())));
        }
        
        String pin= "";
        String numbers = "1234567890";
        for (int x = 0; x < 6; x++) {
           pin = pin + (numbers.charAt(r.nextInt(numbers.length())));
        }
        
        String name = "";
        String Address= "Cruce Estrella, NY City, Algonquin, in GTA IV";
        String city= "New York";
        String state= "USA";
        int number = 1234567890;       
        String email= nameEmail + "@gmail.com";        
        String date= numero();
                
        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice Delete Customer
        manager.clickNewCustomer();
        //Lleno el formulario de New Customer (excepto el campo de customer name) y le doy clic al boton Submit        
        newCustomer.formNew(name,Address,city,state,pin,number,email,pass,date);
        //Capturo la alerta
        String Warning = driver.switchTo().alert().getText();
        
        System.out.println(Warning);
        //Verificacion
        //Si la alerta dice "please fill all fields", se confirma la condicion de obligatoriedad
        assertEquals("El sistema dice: " + Warning, Warning, "please fill all fields");
    }
}
