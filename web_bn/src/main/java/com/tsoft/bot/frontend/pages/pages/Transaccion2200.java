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

public class Transaccion2200 extends BaseClass {

    public WebDriver driver;
    String scene="";
    public Screen screen;

    static GenerateWord generateWord = new GenerateWord();

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(BN_ExcelDataObject.EXCEL_FILE, BN_ExcelDataObject.EXCEL_SHEET);
    }

    public Transaccion2200(){
        this.driver = Hook.getDriver();
    }

    public void ingresarDatosEmisiondeCertificado(String casodeprueba) throws Throwable {

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

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_IMPORTE));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se ingresa importe";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODEPAGO));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            if (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODEPAGO).equals("1")) {

                scene = "Se selecciona forma de pago";
                generateWord.sendText(scene);
                generateWord.addImageToWord(screen);
                stepPass(screen, scene);

            } else if (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODEPAGO).equals("2")){

                sleep(3000);
                screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_CODBCO));

                scene = "Se ingresa código bco";
                generateWord.sendText(scene);
                generateWord.addImageToWord(screen);
                stepPass(screen, scene);

                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);

                sleep(3000);
                screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_NUMEROCHEQUE));

                scene = "Se ingresa número de cheque";
                generateWord.sendText(scene);
                generateWord.addImageToWord(screen);
                stepPass(screen, scene);

                int cantnumcheque = (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_NUMEROCHEQUE).length());
                System.out.println("La cantidad de numero cheque es:" +cantnumcheque);

                if (cantnumcheque != 8) {

                    sleep(3000);
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);

                }

                sleep(3000);
                screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_CODIGOCHEQUE));

            } else if (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODEPAGO).equals("3")) {

                sleep(3000);
                screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_CUENTA));

                scene = "Se ingresa número cta cte";
                generateWord.sendText(scene);
                generateWord.addImageToWord(screen);
                stepPass(screen, scene);



            }

        } catch (Throwable t) {
            stepFail(screen, "Error : [ Step : : " + "Datos de Telegiro" + " ] : " + t.getMessage());
            generateWord.sendText("Error : [ Step : : " + "Datos de Telegiro" + " ] : " + t.getMessage());
            generateWord.addImageToWord(screen);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }

    public void ingresarDatosDemandado(String casodeprueba) throws Throwable {

        String step = "Ingresar datos Demandado: ";
        screen = new Screen();

        try{

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_TIPOPERSONADEMANDADO));

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se selecciona tipo de persona demandado";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_TIPODOCUMENTODEMANDADO));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se selecciona tipo de documento demandado";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_NUMERODOCUMENTODEMANDADO));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se ingresa número de documento demandado";
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

    public void ingresarDatosDepositante(String casodeprueba) throws Throwable {

        String step = "Ingresar datos Depositante: ";
        screen = new Screen();

        try {

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_TIPOPERSONADEPOSITANTE));

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se selecciona tipo de persona depositante";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_TIPODOCUMENTODEPOSITANTE));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se selecciona tipo de documento depositante";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_NUMERODOCUMENTODEPOSITANTE));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se ingresa número de documento depositante";
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

    public void ingresarDatosDemandante(String casodeprueba) throws Throwable {

        String step = "Ingresar datos Demandante: ";
        screen = new Screen();

        try {

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_TIPOPERSONADEMANDANTE));

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se selecciona tipo de persona demandante";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_TIPODOCUMENTODEMANDANTE));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se selecciona tipo de documento demandante";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_NUMERODOCUMENTODEMANDANTE));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se ingresa número de documento demandante";
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

    public void ingresarDatosJuicio(String casodeprueba) throws Throwable {

        String step = "Ingresar datos Juicio: ";
        screen = new Screen();

        try {

            sleep(3000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);

            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_INICIALMOTIVODEJUICIO));

            sleep(3000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se selecciona inicial motivo de juicio";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_MOTIVODEJUICIO));

            sleep(3000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se selecciona motivo de juicio";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(2000);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_INICIALJUZGADO));

            sleep(3000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se selecciona inicial juzgado";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_LUGARJUZGADO));

            sleep(3000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se selecciona lugar juzgado";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_NOMBREJUZGADO));

            sleep(3000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Se selecciona nombre juzgado";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(3000);
            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_NROFORMATO));

            scene = "Se ingresa nro formato";
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

        sleep(6000);
        String step = "Se culminó la transacción correctamente";
        screen = new Screen();

        try {

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            sleep(3000);

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
