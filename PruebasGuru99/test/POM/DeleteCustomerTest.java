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
 * @author SEBASTIAN
 */
public class DeleteCustomerTest {

    private static WebDriver driver = null;
    //Creo objetos de la clase de objetos
    Login login;
    Menu menu;
    DeleteCustomer deleteCustomer;
    NewCustomer newCustomer;
    CustomerRegistered customerRegistered;
    EditCustomer editCustomer;
    Random r = new Random();

    //Licencias
    String userId = "mngr344087";
    String password = "UnupahA";

    //Informacion cliente
    String name = "Wilson";
    String address = "Derecho a la izquierda la casa verde";
    String city = "Medellin";
    String state = "Colombia";
    int number = 1234567890;
    String date = "12/12/2000";
    String email = "";
    String pass = "";
    String pin = "";

    public DeleteCustomerTest() {
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
        deleteCustomer = new DeleteCustomer(driver);
        newCustomer = new NewCustomer(driver);
        editCustomer = new EditCustomer(driver);
        customerRegistered = new CustomerRegistered(driver);

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

    //Caso de prueba 3: Eliminar el cliente y verificar que sea eliminado.
    @Test
    public void testDeleteCustomer1() {
        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice New Customer
        menu.clickNewCustomer();
        //Lleno el formulario de New Customer y le doy clic al boton Submit
        newCustomer.formNew(name, address, city, state, pin, number, email, pass, date);
        //Guarda el customerId
        String dataCustomerId = customerRegistered.getDataCustomerId();
        //Selecciono el hipervinculo que dice Delete Customer
        menu.clickDeleteCustomer();
        //Lleno el formulario de Delete Customer y le doy clic al boton Submit
        deleteCustomer.formDelete(dataCustomerId);
        //Sale una Alerta diciendo "Do you really want to delete this Customer?" y le doy aceptar
        driver.switchTo().alert().accept();
        //Sale otra Alerta y le doy Aceptar
        driver.switchTo().alert().accept();
        //Selecciono el hipervinculo que dice Edit Customer
        menu.clickEditCustomer();
        //Lleno el formulario de Edit Customer y le doy clic al boton Submit
        editCustomer.formEdit(dataCustomerId);
        //Sale una Alerta y copio lo que dice en un String
        String texto = driver.switchTo().alert().getText();
        System.out.println("Se elimino correctamente el cliente " + dataCustomerId + ": " + texto);

        //Verificacion
        //Si la alerta dice "Customer does not exist!!", el cliente se elimino correctamente
        assertEquals("No se pudo eliminar. El cliente " + dataCustomerId + " existe", texto, "Customer does not exist!!");
    }

    @Test
    public void testDeleteCustomer2() {
        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice New Customer
        menu.clickNewCustomer();
        //Lleno el formulario de New Customer y le doy clic al boton Submit
        newCustomer.formNew(name, address, city, state, pin, number, email, pass, date);
        //Guarda el customerId
        String dataCustomerId = customerRegistered.getDataCustomerId();
        //Selecciono el hipervinculo que dice Delete Customer
        menu.clickDeleteCustomer();
        //Lleno el formulario de Delete Customer y le doy clic al boton Submit
        deleteCustomer.formDelete(dataCustomerId);
        //Sale una Alerta diciendo "Do you really want to delete this Customer?" y le doy aceptar
        driver.switchTo().alert().accept();
        //Sale otra Alerta y le doy Aceptar
        driver.switchTo().alert().accept();
        //Selecciono el hipervinculo que dice Edit Customer
        menu.clickEditCustomer();
        //Lleno el formulario de Edit Customer y le doy clic al boton Submit
        editCustomer.formEdit(dataCustomerId);
        //Sale una Alerta y copio lo que dice en un String
        String texto = driver.switchTo().alert().getText();
        System.out.println("Se elimino correctamente el cliente " + dataCustomerId + ": " + texto);

        //Verificacion
        //Si la alerta dice "Customer does not exist!!", el cliente se elimino correctamente
        assertEquals("No se pudo eliminar. El cliente " + dataCustomerId + " existe", texto, "Customer does not exist!!");
    }

    /*
    @Test
    public void testDeleteCustomer3() {
        //Preparacion
        String id = "222222";

        //Ejecucion
        //Login
        login.formLogin(userId, password);
        //Selecciono el hipervinculo que dice Delete Customer
        menu.clickDeleteCustomer();
        //Lleno el formulario de Delete Customer y le doy clic al boton Submit
        deleteCustomer.formDelete(id);
        //Sale una Alerta diciendo "Do you really want to delete this Customer?" y le doy aceptar
        driver.switchTo().alert().accept();
        //Copio en un String  lo que dice la siguiente alerta
        String texto = driver.switchTo().alert().getText();

        //Verificacion
        assertEquals("No se pudo eliminar el cliente " + id + " porque: " + texto, texto, "Customer deleted Successfully");
    }

    @Test
    public void testDeleteCustomer4() {
        //Preparacion
        String id = "1";

        //Ejecucion
        //Login
        login.formLogin(userId, password);
        //Selecciono el hipervinculo que dice Delete Customer
        menu.clickDeleteCustomer();
        //Lleno el formulario de Delete Customer y le doy clic al boton Submit
        deleteCustomer.formDelete(id);
        //Sale una Alerta diciendo "Do you really want to delete this Customer?" y le doy aceptar
        driver.switchTo().alert().accept();
        //Copio en un String  lo que dice la siguiente alerta
        String texto = driver.switchTo().alert().getText();

        //Verificacion
        assertEquals("No se pudo eliminar el cliente " + id + " porque: " + texto, texto, "Customer deleted Successfully");
    }
     */
}
