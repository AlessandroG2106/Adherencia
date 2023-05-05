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

public class Transaccion7504 extends BaseClass {

    public WebDriver driver;
    String scene="";
    public Screen screen;

    static GenerateWord generateWord = new GenerateWord();

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(BN_ExcelDataObject.EXCEL_FILE, BN_ExcelDataObject.EXCEL_SHEET);
    }

    public Transaccion7504(){
        this.driver = Hook.getDriver();
    }

    public void ingresarDatosTelegiro(String casodeprueba) throws Throwable {

        screen = new Screen();

        try{

            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPOMONEDA));

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Elegir tipo de moneda";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(5000);

            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODEPAGO));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Elegir tipo de pago";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(5000);

            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_OFICINADESTINO));

//            robot.keyPress(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Elegir oficina destino";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

        } catch (Throwable t) {
            stepFail(screen, "Error : [ Step : : " + "Datos de Telegiro" + " ] : " + t.getMessage());
            generateWord.sendText("Error : [ Step : : " + "Datos de Telegiro" + " ] : " + t.getMessage());
            generateWord.addImageToWord(screen);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }

    public void ingresarDatosBeneficiario(String casodeprueba) throws Throwable {

        String step = "Ingresar datos Beneficiario: ";
        screen = new Screen();

        try{

            sleep(5000);
            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_TIPOPERSONABENEFICIARIO));

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Elegir tipo de persona beneficiario";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(5000);

            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_TIPODOCUMENTOBENEFICIARIO));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Elegir tipo de documento del beneficiario";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(5000);

            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_NUMERODOCUMENTOBENEFICIARIO));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Ingresar número de documento del beneficiario";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(8000);

            if (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODOCUMENTOBENEFICIARIO).equals("1")) {

                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);

            } else {

                screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_NOMBREBENEFICIARIO));

                sleep(8000);
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);

            }

        } catch (Throwable t) {
            stepFail(screen, "Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.sendText("Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.addImageToWord(screen);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }

    public void ingresarDatosRemitente(String casodeprueba) throws Throwable {

        String step = "Ingresar datos Remitente: ";
        screen = new Screen();

        try {

            sleep(5000);
            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPOPERSONAREMITENTE));

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Elegir tipo de persona remitente";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(5000);

            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODOCUMENTOREMITENTE));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Elegir tipo de documento del remitente";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(5000);

            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_NUMERODOCUMENTOREMITENTE));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Ingresar número de documento del remitente";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(10000);

            if (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODOCUMENTOREMITENTE).equals("1")) {

                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);

            } else {

                screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_NOMBREREMITENTE));

                sleep(8000);
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);

                scene = "Se ingresa el nombre de remitente";
                generateWord.sendText(scene);
                generateWord.addImageToWord(screen);
                stepPass(screen, scene);

            }


        } catch (Throwable t) {
            stepFail(screen, "Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.sendText("Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.addImageToWord(screen);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }

    public void ingresarImporte(String casodeprueba) throws Throwable {

        sleep(10000);
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
            screen.type("si");

            sleep(5000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            sleep(5000);

            scene = "Se envía la transacción";
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
