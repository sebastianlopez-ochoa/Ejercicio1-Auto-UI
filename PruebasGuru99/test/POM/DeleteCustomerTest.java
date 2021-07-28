/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

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
    Manager manager;
    DeleteCustomer deleteCustomer;

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
        manager = new Manager(driver);
        deleteCustomer = new DeleteCustomer(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    //Licencias
    String userId = "mngr344087";
    String password = "UnupahA";

    @Test
    public void testDeleteCustomer1() {
        //Preparacion
        String id = "18288";

        //Ejecucion
        //Hago login
        login.formLogin(userId, password);
        //En la pagina de inicio selecciono el hipervinculo que dice Delete Customer
        manager.clickDeleteCustomer();
        //Lleno el formulario de Delete Customer y le doy clic al boton Submit
        deleteCustomer.formDelete(id);
        //Sale una Alerta diciendo "Do you really want to delete this Customer?" y le doy aceptar
        driver.switchTo().alert().accept();
        //Sale otra alerta y copio lo que dice en un String
        String texto = driver.switchTo().alert().getText();

        //Verificacion
        //Si la alerta dice "Customer deleted Successfully", el cliente se elimino correctamente
        assertEquals("El sistema dice: " + texto, texto, "Customer deleted Successfully");
    }

    @Test
    public void testDeleteCustomer2() {
        //Preparacion
        String id = "222222";

        //Ejecucion
        login.formLogin(userId, password);
        manager.clickDeleteCustomer();
        deleteCustomer.formDelete(id);
        driver.switchTo().alert().accept();
        String texto = driver.switchTo().alert().getText();

        //Verificacion
        assertEquals("El sistema dice: " + texto, texto, "Customer deleted Successfully");
    }

    @Test
    public void testDeleteCustomer3() {
        //Preparacion
        String id = "1";

        //Ejecucion
        login.formLogin(userId, password);
        manager.clickDeleteCustomer();
        deleteCustomer.formDelete(id);
        driver.switchTo().alert().accept();
        String texto = driver.switchTo().alert().getText();

        //Verificacion
        assertEquals("El sistema dice: " + texto, texto, "Customer deleted Successfully");
    }
}
