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

import static com.tsoft.bot.frontend.pages.objects.BN_ObjectTransaccion.ACEPTAR;

public class Transaccion0710 extends BaseClass {

    public WebDriver driver;
    String scene="";
    public Screen screen;

    static GenerateWord generateWord = new GenerateWord();

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(BN_ExcelDataObject.EXCEL_FILE, BN_ExcelDataObject.EXCEL_SHEET);
    }

    public Transaccion0710(){
        this.driver = Hook.getDriver();
    }

    public void elegirTipoMoneda(String casodeprueba) throws Throwable {

        String step = "Elegir el tipo de moneda: ";
        screen = new Screen();

        try{

            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPOMONEDA));

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            scene = step;
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

        } catch (Throwable t) {
            stepFail(screen, "Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.sendText("Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.addImageToWord(screen);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }

    public void ingresarDatos(String casodeprueba) throws Throwable {

        sleep(5000);
        String step = "Ingresar datos: ";
        screen = new Screen();

        try{
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            sleep(5000);

            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_NUMERODOCUMENTO));

            scene = step;
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

        } catch (Throwable t) {
            stepFail(screen, "Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.sendText("Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.addImageToWord(screen);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }


    public void ingresarImporteDeposito(String casodeprueba) throws Throwable {

        sleep(8000);
        String step = "Ingresar importe: ";
        screen = new Screen();

        try{

            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_IMPORTE));

            scene = step;
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

        } catch (Throwable t) {
            stepFail(screen, "Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.sendText("Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.addImageToWord(screen);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }

    public void enviarTransaccion() throws Throwable {

        sleep(5000);
        String step = "Se culminó la transacción correctamente";
        screen = new Screen();

        try {

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            sleep(5000);

            robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);

            scene = "Enviar depósito";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(5000);

            screen.find(ACEPTAR).highlight(2,"blue").click();

            scene = step;
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(5000);

        } catch (Throwable t) {
            stepFail(screen, "Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.sendText("Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.addImageToWord(screen);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }
}
