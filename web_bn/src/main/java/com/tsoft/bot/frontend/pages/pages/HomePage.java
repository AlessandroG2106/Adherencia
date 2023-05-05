package com.tsoft.bot.frontend.pages.pages;

import com.tsoft.bot.frontend.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.objects.BN_ExcelDataObject;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.GenerateWord;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

import static com.tsoft.bot.frontend.steps.component.common.CommonComponents.cargarBrowser;
import static com.tsoft.bot.frontend.pages.objects.BN_ObjectTransaccion.LOGO;
import static org.sikuli.script.ImagePath.find;

public class HomePage extends BaseClass {

    public WebDriver driver;
    String scene="";
    public Screen screen;

    static GenerateWord generateWord = new GenerateWord();

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(BN_ExcelDataObject.EXCEL_FILE, BN_ExcelDataObject.EXCEL_SHEET);
    }

    public HomePage(){
        this.driver = Hook.getDriver();
    }

    public void ingresarWeb() throws Throwable {

        String aplicacion="C:/Users/Orlando/AppData/Local/Discord/app-1.0.9013/Discord.exe";
        Runtime run = Runtime.getRuntime();


        System.out.println("Se ingresa a la aplicación");
        run.exec(aplicacion);

        System.out.println("Se cargó la pagina");
        //find(LOGO);
        //ESPERAR QUE APAREZCA UN ELEMENTO ****01
        //sleep(15000);

    }

    public void loginSaraweb(String casodeprueba) throws Throwable {
        Robot robot = new Robot();
        String step = "Ingresar a la aplicacion";
        screen = new Screen();

        sleep(2000);
        screen.type("974609823"); //Apertura de caja
        System.out.println("Se escribe el usuario");
        robot.keyPress(KeyEvent.VK_TAB);
        sleep(1000);
        //Ingresa usuario
        screen.type("ale123456789G");
        System.out.println("Se escribe la contraseña");
        sleep(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public void ingresarTransaccion(String casodeprueba) throws Throwable {

        screen = new Screen();
        String step = "Ingresar a la transacción: ";

        try{

            sleep(2000);
            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_TRANSACCION));
            sleep(10000);

            scene = step;
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

        } catch (Throwable t) {
            stepFail(driver, "Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.sendText("Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.addImageToWord(screen);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }

}
