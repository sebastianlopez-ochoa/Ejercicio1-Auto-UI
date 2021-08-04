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
    Menu menu;
    NewCustomer newCustomer;
    CustomerRegistered customerRegistered;
    EditCustomer editCustomer;
    DataEditCustomer dataEditCustomer;
    Random r = new Random();

    //Licencias
    String userId = "mngr344087";
    String password = "UnupahA";

    //Informacion cliente
    String name = "Wilson";
    String gender = "male";
    String address = "Derecho a la izquierda la casa verde";
    String city = "Medellin";
    String state = "Colombia";
    int number = 1234567890;
    String date = "12/12/2000";
    String email = "";
    String pass = "";
    String pin = "";
    String confi = "2000-12-12";

    public String prueba(String name, String gender, String address, String city, String state, String pin, int number, String email, String date) {

        String verificacion = "false";

        String dataCustomerName = dataEditCustomer.getDataCustomerName();
        System.out.println(name + " = " + dataCustomerName);
        String dataCustomerGender = dataEditCustomer.getDataCustomerGender();
        System.out.println(gender + " = " + dataCustomerGender);
        String dataCustomerDate = dataEditCustomer.getDataCustomerDate();
        System.out.println(date + " = " + dataCustomerDate);
        String dataCustomerAddress = dataEditCustomer.getDataCustomerAddress();
        System.out.println(address + " = " + dataCustomerAddress);
        String dataCustomerCity = dataEditCustomer.getDataCustomerCity();
        System.out.println(city + " = " + dataCustomerCity);
        String dataCustomerState = dataEditCustomer.getDataCustomerState();
        System.out.println(state + " = " + dataCustomerState);
        String dataCustomerPin = dataEditCustomer.getDataCustomerPin();
        System.out.println(pin + " = " + dataCustomerPin);
        String dataCustomerNumber = dataEditCustomer.getDataCustomerNumber();
        System.out.println(Integer.toString(number) + " = " + dataCustomerNumber);
        String dataCustomerEmail = dataEditCustomer.getDataCustomerEmail();
        System.out.println(email + " = " + dataCustomerEmail);

        if ((name.equals(dataCustomerName)) && (gender.equals(dataCustomerGender)) && (address.equals(dataCustomerAddress)) && (city.equals(dataCustomerCity))
                && (state.equals(dataCustomerState)) && (pin.equals(dataCustomerPin)) && (Integer.toString(number).equals(dataCustomerNumber)) && (email.equals(dataCustomerEmail))) {
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
        menu = new Menu(driver);
        newCustomer = new NewCustomer(driver);
        customerRegistered = new CustomerRegistered(driver);
        editCustomer = new EditCustomer(driver);
        dataEditCustomer = new DataEditCustomer(driver);

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

    //Caso de prueba 2: Crear un customer.
    /*
    Verifique en la pantalla que se presenta, el mensaje de creación correcto y que se presenten
    en la tabla, los datos que fueron ingresados. Importante que capture el “Customer ID”, dado que 
    este es el que se requiere para realizar las demás operaciones (imprímalo en consola también
    para que sepa cual es el ID)
     */
    @Test
    public void testNewCustomer1() {
        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice Delete Customer
        menu.clickNewCustomer();
        //Lleno el formulario de New Customer y le doy clic al boton Submittitle
        newCustomer.formNew(name, address, city, state, pin, number, email, pass, date);
        //Guarda en la variable texto el titulo cuando se crea un nuevo cliente: Customer Registered Successfully!!!
        String texto = customerRegistered.getTitleRegisteredSuccessfully();
        //Guardar el customerId
        String dataCustomerId = customerRegistered.getDataCustomerId();
        //Selecciono el hipervinculo que dice Edit Customer
        menu.clickEditCustomer();
        //Lleno el formulario de Edit Customer y le doy clic al boton Submit
        editCustomer.formEdit(dataCustomerId);
        String very = prueba(name, gender, address, city, state, pin, number, email, confi);
        //Imprimo en consola
        System.out.println("Customer id: " + dataCustomerId);
        System.out.println("¿Todo correcto?: " + very + "\n");
        //Verificacion
        //Verifica el mensaje de creación correcto
        assertEquals("No se creo el cliente", texto, "Customer Registered Successfully!!!");
        //Verifica que cuando se crea el nuevo cliente se presenten los mismos datos que fueron ingresados
        assertEquals("¿La informacion concuerda?: " + very, very, "true");
    }

    @Test
    public void testNewCustomer2() {
        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice Delete Customer
        menu.clickNewCustomer();
        //Lleno el formulario de New Customer y le doy clic al boton Submittitle
        newCustomer.formNew(name, address, city, state, pin, number, email, pass, date);
        //Guarda en la variable texto el titulo cuando se crea un nuevo cliente: Customer Registered Successfully!!!
        String texto = customerRegistered.getTitleRegisteredSuccessfully();
        //Guardar el customerId
        String dataCustomerId = customerRegistered.getDataCustomerId();
        //Selecciono el hipervinculo que dice Edit Customer
        menu.clickEditCustomer();
        //Lleno el formulario de Edit Customer y le doy clic al boton Submit
        editCustomer.formEdit(dataCustomerId);
        String very = prueba(name, gender, address, city, state, pin, number, email, confi);
        //Imprimo en consola
        System.out.println("Customer id: " + dataCustomerId);
        System.out.println("¿Todo correcto?: " + very + "\n");
        //Verificacion
        //Verifica el mensaje de creación correcto
        assertEquals("No se creo el cliente", texto, "Customer Registered Successfully!!!");
        //Verifica que cuando se crea el nuevo cliente se presenten los mismos datos que fueron ingresados
        assertEquals("¿La informacion concuerda?: " + very, very, "true");
    }

}
