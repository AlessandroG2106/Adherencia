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

public class Transaccion1125 extends BaseClass {

    public WebDriver driver;
    String scene="";
    public Screen screen;

    static GenerateWord generateWord = new GenerateWord();

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(BN_ExcelDataObject.EXCEL_FILE, BN_ExcelDataObject.EXCEL_SHEET);
    }

    public Transaccion1125(){
        this.driver = Hook.getDriver();
    }

    public void ingresarDatosConsultaCodigoCCIAhorrosMNME(String casodeprueba) throws Throwable {

        String step = "Ingresar datos consulta retiros Multired";
        screen = new Screen();

        try{

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPOMONEDA));

            scene = "Elegir tipo de moneda";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_CUENTA));

            scene = "Ingresar cuenta";
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

        String step = "Se culminó la transacción correctamente";
        screen = new Screen();

        try {

            sleep(10000);

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            scene = "Se envía la transacción";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);

            screen.find(ACEPTAR).highlight(2,"blue").click();

            scene = step;
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);

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
