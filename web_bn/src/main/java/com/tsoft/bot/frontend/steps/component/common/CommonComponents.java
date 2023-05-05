package com.tsoft.bot.frontend.steps.component.common;

import com.tsoft.bot.frontend.BaseClass;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

public class CommonComponents extends BaseClass {
    static GenerateWord generateWord = new GenerateWord();

    public static void cargarBrowser(WebDriver driver, String url) throws Throwable {

        try {

            if (StringUtils.isNotEmpty(url)) {

                driver.get(url);
                stepPass(driver, "Ingresar correctamente a la URL: '"+url+"'");
                generateWord.sendText("Ingresar correctamente a la URL: '"+url+"'");
                generateWord.sendBreak();
                generateWord.addImageToWord(driver);
                sleep(500);

            } else {
                throw new Exception("Error al cargar la página, NO existe el parámetro URL del aplicativo ");
            }

        } catch ( NoSuchWindowException | NoSuchSessionException e ){
            stepFailNoShoot("[Error al cargar Browser] : Navegador se cerró inesperadamente : " + e.getMessage());
            generateWord.sendText("[Error al cargar Browser] : Navegador se cerró inesperadamente : " + e.getMessage());
            driver.close();
            throw e;
        } catch ( Throwable t ) {
            stepFail(driver, "[Error al cargar Browser] : " + t.getMessage());
            generateWord.sendText("[Error al cargar Browser] : " + t.getMessage());
            generateWord.addImageToWord(driver);
            driver.close();
            throw t;
        }
    }
}
