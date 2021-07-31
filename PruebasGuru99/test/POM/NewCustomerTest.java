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
    CustomerRegistered customerRegistered;
    Random r = new Random();
    String confi="";
    
    public String numero() { 
        int min_all = 1;
        int max_day = 25;
        //int max_month = 11;      
        Random ran = new Random();
        int day = (int)(Math. random()*30+1);
        //int month = ran.nextInt(max_month) + min_all;
        String dat= day+"/12/2000";
        confi = "2000-12-"+day;
        return dat;
    }
    
    public String prueba(String name,String Gender,String Address,String city,String state,String pin,int number,String email, String date){
        
        String verificacion = "false";
            
        String dataCustomerName = customerRegistered.getDataCustomerName();
        System.out.println(name + " = " + dataCustomerName);
        String dataCustomerGender = customerRegistered.getDataCustomerGender();
        System.out.println(Gender + " = " + dataCustomerGender);
        String dataCustomerDate = customerRegistered.getDataCustomerDate();
        System.out.println(date + " = " + dataCustomerDate);
        String dataCustomerAddress = customerRegistered.getDataCustomerAddress();
        System.out.println(Address + " = " + dataCustomerAddress);
        String dataCustomerCity = customerRegistered.getDataCustomerCity();
        System.out.println(city + " = " + dataCustomerCity);
        String dataCustomerState = customerRegistered.getDataCustomerState();
        System.out.println(state + " = " + dataCustomerState);
        String dataCustomerPin = customerRegistered.getDataCustomerPin();
        System.out.println(pin + " = " + dataCustomerPin);
        String dataCustomerNumber = customerRegistered.getDataCustomerNumber();
        System.out.println(Integer.toString(number) + " = " + dataCustomerNumber);
        String dataCustomerEmail = customerRegistered.getDataCustomerEmail();
        System.out.println(email + " = " + dataCustomerEmail);
        
        if((name.equals(dataCustomerName)) && (Gender.equals(dataCustomerGender)) && (Address.equals(dataCustomerAddress)) && (city.equals(dataCustomerCity)) &&
                (state.equals(dataCustomerState)) && (pin.equals(dataCustomerPin)) && (Integer.toString(number).equals(dataCustomerNumber)) && (email.equals(dataCustomerEmail)))
        {
            verificacion = "true";
        }       
        
        return verificacion;
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
        customerRegistered = new CustomerRegistered(driver);
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
        
        confi="";
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
        
        String name = "Wilson";
        String Gender = "male";
        String Address= "Derecho a la izquierda la casa verde";
        String city= "Medellin";
        String state= "Colombia";
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
        //Guardar el customerId
        String dataCustomerId = customerRegistered.getDataCustomerId();
        String very = prueba(name, Gender, Address, city, state, pin ,number,email,confi);
        
        
        System.out.println("aja: ");
        System.out.println(texto);
        
        System.out.println("customer id: " + dataCustomerId);
        System.out.println("todo correcto: " + very);
        //Verificacion
        //Si la alerta dice "New Customer Successfully", el cliente se creo correctamente
        assertEquals("El sistema dice: " + texto, texto, "Customer Registered Successfully!!!");
        assertEquals("La informacion concuerda: " + very, very, "true");
    }
    
    /*@Test
    public void testNewCustomer2() {
        
        confi="";
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
        
        String name = "Arnulfo";
        String Gender = "male";
        String Address= "Derecho a la derecha la casa verde";
        String city= "CD Mexico";
        String state= "Mexico";
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
        //Guardar el customerId
        String dataCustomerId = customerRegistered.getDataCustomerId();
        String very = prueba(name, Gender, Address, city, state, pin ,number,email,confi);
        
        
        System.out.println("aja: ");
        System.out.println(texto);
        
        System.out.println("customer id: " + dataCustomerId);
        System.out.println("todo correcto: " + very);
        //Verificacion
        //Si la alerta dice "New Customer Successfully", el cliente se creo correctamente
        assertEquals("El sistema dice: " + texto, texto, "Customer Registered Successfully!!!");
        assertEquals("La informacion concuerda: " + very, very, "true");

    }
    
    @Test
    public void testNewCustomer3() {
        
        confi="";
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
        
        String name = "Messi";
        String Gender = "male";
        String Address= "A la izquierda derecho la casa zul celeste";
        String city= "Rosario";
        String state= "Argentina";
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
        //Guardar el customerId
        String dataCustomerId = customerRegistered.getDataCustomerId();
        String very = prueba(name, Gender, Address, city, state, pin ,number,email,confi);
        
        
        System.out.println("aja: ");
        System.out.println(texto);
        
        System.out.println("customer id: " + dataCustomerId);
        System.out.println("todo correcto: " + very);
        //Verificacion
        //Si la alerta dice "New Customer Successfully", el cliente se creo correctamente
        assertEquals("El sistema dice: " + texto, texto, "Customer Registered Successfully!!!");
        assertEquals("La informacion concuerda: " + very, very, "true");
    }*/
}
