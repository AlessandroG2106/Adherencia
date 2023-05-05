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

public class Transaccion1800 extends BaseClass {

    public WebDriver driver;
    String scene="";
    public Screen screen;

    static GenerateWord generateWord = new GenerateWord();

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(BN_ExcelDataObject.EXCEL_FILE, BN_ExcelDataObject.EXCEL_SHEET);
    }

    public Transaccion1800(){
        this.driver = Hook.getDriver();
    }

    public void ingresarDatosDepositoCuentaAhorros(String casodeprueba) throws Throwable {

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

            scene = "Elegir tipo de depósito";
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
            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_CUENTA));

            if (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODEPAGO).equals("1")) {

                scene = "Se ingresa cuenta";
                generateWord.sendText(scene);
                generateWord.addImageToWord(screen);
                stepPass(screen, scene);

            } else if (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODEPAGO).equals("2")){

                sleep(5000);
                screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_NUMEROCHEQUE));

                scene = "Se ingresa número de cheque";
                generateWord.sendText(scene);
                generateWord.addImageToWord(screen);
                stepPass(screen, scene);

                int cantnumcheque = (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_NUMEROCHEQUE).length());
                System.out.println("La cantidad de numero cheque es:" +cantnumcheque);

                if (cantnumcheque != 8) {

                    sleep(3000);
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);

                }

                sleep(3000);
                screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_CODCTACTE));

                int cantcodctacte = (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_CODCTACTE).length());
                System.out.println("La cantidad de cod cta cte es:" +cantcodctacte);

                if (cantcodctacte != 15) {

                    sleep(3000);
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);

                }

            } else if (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODEPAGO).equals("3")) {

                sleep(5000);
                screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_NUMEROCHEQUE));

                scene = "Se ingresa número de cheque";
                generateWord.sendText(scene);
                generateWord.addImageToWord(screen);
                stepPass(screen, scene);

                int cantnumcheque = (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_NUMEROCHEQUE).length());
                System.out.println("La cantidad de numero cheque es:" + cantnumcheque);

                if (cantnumcheque != 8) {

                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);

                }

                sleep(3000);
                screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_CODCTACTE));

                scene = "Se ingresa código cta cte";
                generateWord.sendText(scene);
                generateWord.addImageToWord(screen);
                stepPass(screen, scene);

                int cantcodctacte = (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_CODCTACTE).length());
                System.out.println("La cantidad de cod cta cte es:" + cantcodctacte);

                if (cantcodctacte != 15) {

                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);
                }
                    sleep(5000);
                    screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_CODBCO));

                    scene = "Se ingresa código bco";
                    generateWord.sendText(scene);
                    generateWord.addImageToWord(screen);
                    stepPass(screen, scene);

                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);

                } else if (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODEPAGO).equals("4")) {

                    sleep(5000);
                    screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_NUMEROCHEQUE));

                    scene = "Se ingresa número de cheque";
                    generateWord.sendText(scene);
                    generateWord.addImageToWord(screen);
                    stepPass(screen, scene);

                    int cantnumcheque = (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_NUMEROCHEQUE).length());
                    System.out.println("La cantidad de numero cheque es:" + cantnumcheque);

                    if (cantnumcheque != 8) {

                        Robot robot = new Robot();
                        robot.keyPress(KeyEvent.VK_TAB);
                        robot.keyRelease(KeyEvent.VK_TAB);

                    }

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

        sleep(5000);
        String step = "Ingresar importe: ";
        screen = new Screen();

        try{

            screen.type(getData().get(Integer.parseInt(casodeprueba)-1).get(BN_ExcelDataObject.COLUMN_IMPORTE));

            scene = step;
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

        } catch (Throwable t) {
            stepFail(screen, "Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.sendText("Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.addImageToWord(screen);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }

    public void ingresarDatosOrdenante(String casodeprueba) throws Throwable {

        String step = "Ingresar datos Ordenante: ";
        screen = new Screen();

        try {

            sleep(5000);

            String cantnumcheque = (getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODOCUMENTOORDENANTE));
            System.out.println("El tipo de documento es:" + cantnumcheque);

            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODOCUMENTOORDENANTE));

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Elegir tipo de documento ordenante";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(5000);
            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_NUMERODOCUMENTOORDENANTE));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Ingresar número de documento del ordenante";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(6000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

        } catch (Throwable t) {
            stepFail(screen, "Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.sendText("Error : [ Step : : " + step + " ] : " + t.getMessage());
            generateWord.addImageToWord(screen);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }

    public void ingresarDatosEjecutante(String casodeprueba) throws Throwable {

        String step = "Ingresar datos Ejcutante: ";
        screen = new Screen();

        try {

            sleep(5000);
            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_TIPODOCUMENTOEJECUTANTE));

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Elegir tipo de documento ejecutante";
            generateWord.sendText(scene);
            generateWord.addImageToWord(screen);
            stepPass(screen, scene);

            sleep(5000);
            screen.type(getData().get(Integer.parseInt(casodeprueba) - 1).get(BN_ExcelDataObject.COLUMN_NUMERODOCUMENTOEJECUTANTE));

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            scene = "Ingresar número de documento del ejecutante";
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
