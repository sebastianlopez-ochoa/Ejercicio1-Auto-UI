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
 * @author maria
 */
public class NewCustomerTest {
    
    private static WebDriver driver = null;

    //Creo objetos de la clase de objetos
    Login login;
    Manager manager;
    NewCustomer newCustomer;
    Random r = new Random();
    
    public String numero() { 
        int min_all = 1;
        int max_day = 25;
        int max_month = 11;
        int min_year = 1980;
        int max_year = 40;
        
        Random ran = new Random();
        
        int day = ran.nextInt(max_day) + min_all;
        int month = ran.nextInt(max_month) + min_all;
        int year = ran.nextInt(max_year) + min_year;
        String dat= day+"/"+month+"/"+year;
        return dat;
    }
    
    public NewCustomerTest() {
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
        
        String name = "wilson";
        String Address= "derecho a la izquierda la casa verde del segundo piso";
        String city= "medellin";
        String state= "colombia";
        int number = 1234567890;       
        String email= nameEmail + "@gmail.com";        
        String date= numero();
        
        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice Delete Customer
        manager.clickNewCustomer();
        //Lleno el formulario de New Customer y le doy clic al boton Submit
        newCustomer.formNew(name,Address,city,state,pin,number,email,pass,date);
        String texto = newCustomer.getConfirmacion();
        
        System.out.println("aja: ");
        System.out.println(texto);
        //Verificacion
        //Si la alerta dice "New Customer Successfully", el cliente se creo correctamente
        assertEquals("El sistema dice: " + texto, texto, "Customer Registered Successfully!!!");
    }
    
    @Test
    public void testNewCustomer2() {
        
        
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
        String Address= "derecho a la derecha la casa verde del tercer piso";
        String city= "cd mexico";
        String state= "mexico";
        int number = 1234567890;       
        String email= nameEmail + "@gmail.com";        
        String date= numero();
        
        
        
        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice Delete Customer
        manager.clickNewCustomer();
        //Lleno el formulario de Delete Customer y le doy clic al boton Submit
        newCustomer.formNew(name,Address,city,state,pin,number,email,pass,date);

    }
    
    /*@Test
    public void testNewCustomer3() {
        
        
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
        
        String name = "messi";
        String Address= "a la izquierda derecho la casa zul celeste del primer piso";
        String city= "rosario";
        String state= "argentina";
        int number = 1234567890;       
        String email= nameEmail + "@gmail.com";        
        String date= numero();
        
        
        
        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice Delete Customer
        manager.clickNewCustomer();
        //Lleno el formulario de Delete Customer y le doy clic al boton Submit
        newCustomer.formNew(name,Address,city,state,pin,number,email,pass,date);
        //Sale una Alerta diciendo "Do you really want to delete this Customer?" y le doy aceptar
        driver.switchTo().alert().accept();
        //Sale otra alerta y copio lo que dice en un String
        String texto = driver.switchTo().alert().getText();

        //Verificacion
        //Si la alerta dice "Customer deleted Successfully", el cliente se elimino correctamente
        assertEquals("El sistema dice: " + texto, texto, "New Customer Successfully");
    }
    */
}
