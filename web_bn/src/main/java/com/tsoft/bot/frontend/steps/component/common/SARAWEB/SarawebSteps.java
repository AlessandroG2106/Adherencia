package com.tsoft.bot.frontend.steps.component.common.SARAWEB;

import com.tsoft.bot.frontend.pages.pages.*;

import cucumber.api.PendingException;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Y;
import cucumber.api.java.es.Entonces;


public class SarawebSteps {

    HomePage homePage = new HomePage();
    Transaccion0710 transaccion0710 = new Transaccion0710();
    Transaccion7504 transaccion7504 = new Transaccion7504();
    Transaccion3840 transaccion3840 = new Transaccion3840();
    Transaccion3850 transaccion3850 = new Transaccion3850();

    Transaccion0100 transaccion0100 = new Transaccion0100();
    Transaccion1800 transaccion1800 = new Transaccion1800();
    Transaccion1100 transaccion1100 = new Transaccion1100();
    Transaccion0790 transaccion0790 = new Transaccion0790();

    Transaccion3970 transaccion3970 = new Transaccion3970();
    Transaccion2200 transaccion2200 = new Transaccion2200();
    Transaccion0271 transaccion0271 = new Transaccion0271();
    Transaccion9650 transaccion9650 = new Transaccion9650();
    Transaccion9660 transaccion9660 = new Transaccion9660();
    Transaccion1125 transaccion1125 = new Transaccion1125();

    @Dado("^Usuario ingresa al aplicativo\"([^\"]*)\"$")
    public void usuarioIngresaAlAplicativo(String casodeprueba) throws Throwable {

        homePage.ingresarWeb();
        homePage.loginSaraweb(casodeprueba);

    }

    @Cuando("^Ingresa a la transaccion\"([^\"]*)\"$")
    public void ingresaALaTransaccion(String casodeprueba) throws Throwable {

        homePage.ingresarTransaccion(casodeprueba);
    }

    @Y("^Se completa los datos de la transaccion\"([^\"]*)\"$")
    public void seCompletaLosDatosDeLaTransaccion(String casodeprueba) throws Throwable {

        transaccion0710.elegirTipoMoneda(casodeprueba);
        transaccion0710.ingresarDatos(casodeprueba);
        transaccion0710.ingresarImporteDeposito(casodeprueba);

    }

    @Entonces("^Se genera la transaccion$")
    public void seGeneraLaTransaccion() throws Throwable{

        transaccion0710.enviarTransaccion();

    }

    @Y("^Se completa los datos de transaccion\"([^\"]*)\"$")
    public void seCompletaLosDatosDeTransaccion(String casodeprueba) throws Throwable {

        transaccion7504.ingresarDatosTelegiro(casodeprueba);
        transaccion7504.ingresarDatosBeneficiario(casodeprueba);
        transaccion7504.ingresarDatosRemitente(casodeprueba);
        transaccion7504.ingresarImporte(casodeprueba);

    }

    @Entonces("^Se emite el telegiro$")
    public void seEmiteElTelegiro() throws Throwable{

        transaccion7504.enviarTransaccion();

    }

    @Y("^Se completa los datos de transaccion compraME\"([^\"]*)\"$")
    public void seCompletaLosDatosDeTransaccionCompraME(String casodeprueba) throws Throwable {

        transaccion3840.ingresarDatoCompraME(casodeprueba);
        transaccion3840.ingresarDatos(casodeprueba);

    }

    @Entonces("^Se realiza la compraME$")
    public void seRealizaLaCompraME() throws Throwable{

        transaccion3840.enviarTransaccion();

    }

    @Y("^Se completa los datos de transaccion ventaME\"([^\"]*)\"$")
    public void seCompletaLosDatosDeTransaccionVentaME(String casodeprueba) throws Throwable {

        transaccion3850.ingresarDatoVentaME(casodeprueba);
        transaccion3850.ingresarDatos(casodeprueba);

    }

    @Entonces("^Se emite la ventaME$")
    public void seEmiteLaVentaME() throws Throwable{

        transaccion3850.enviarTransaccion();
    }

    @Y("^Se completa los datos de transaccion consulta saldo de cuentas\"([^\"]*)\"$")
    public void seCompletaLosDatosDeTransaccionConsultaSaldoDeCuentas(String casodeprueba) throws Throwable {

        transaccion0100.ingresarDatosConsultaSaldo(casodeprueba);

    }

    @Entonces("^Se realiza la consulta saldo de cuentas$")
    public void seRealizaLaConsultaSaldoDeCuentas() throws Throwable{

        transaccion0100.enviarTransaccion();

    }

    @Y("^Se completa los datos de transaccion depósito en cuenta de ahorros\"([^\"]*)\"$")
    public void seCompletaLosDatosDeTransaccionDepósitoEnCuentaDeAhorros(String casodeprueba) throws Throwable {

        transaccion1800.ingresarDatosDepositoCuentaAhorros(casodeprueba);
        transaccion1800.ingresarDatosBeneficiario(casodeprueba);
        transaccion1800.ingresarImporte(casodeprueba);
        transaccion1800.ingresarDatosOrdenante(casodeprueba);
        transaccion1800.ingresarDatosEjecutante(casodeprueba);

    }

    @Entonces("^Se realiza el depósito en cuenta de ahorros$")
    public void seRealizaElDepósitoEnCuentaDeAhorros() throws Throwable{

        transaccion1800.enviarTransaccion();

    }


    @Y("^Se completa los datos de transaccion consulta de saldo de ahorros\"([^\"]*)\"$")
    public void seCompletaLosDatosDeTransaccionConsultaDeSaldoDeAhorros(String casodeprueba) throws Throwable {

        transaccion1100.ingresarDatosConsultaSaldoAhorros(casodeprueba);

    }

    @Entonces("^Se realiza la consulta de saldo de ahorros$")
    public void seRealizaLaConsultaDeSaldoDeAhorros() throws Throwable{

        transaccion1100.enviarTransaccion();

    }


    @Y("^Se completa los datos de Emisión de certificado en MN y ME\"([^\"]*)\"$")
    public void seCompletaLosDatosDeEmisiónDeCertificadoEnMNYME(String casodeprueba) throws Throwable {

        transaccion2200.ingresarDatosEmisiondeCertificado(casodeprueba);
        transaccion2200.ingresarDatosDemandado(casodeprueba);
        transaccion2200.ingresarDatosDepositante(casodeprueba);
        transaccion2200.ingresarDatosDemandante(casodeprueba);
        transaccion2200.ingresarDatosJuicio(casodeprueba);

    }

    @Entonces("^Se realiza la emisión de certificado en MN y ME$")
    public void seRealizaLaEmisiónDeCertificadoEnMNYME() throws Throwable{

        transaccion2200.enviarTransaccion();

    }

    @Y("^Se completa los datos de Nota de Abono Varios\"([^\"]*)\"$")
    public void seCompletaLosDatosDeNotaDeAbonoVarios(String casodeprueba) throws Throwable {

        transaccion0790.ingresarDatosNotaDeAbonoVarios(casodeprueba);

    }

    @Entonces("^Se realiza la nota de abono varios$")
    public void seRealizaLaNotaDeAbonoVarios() throws Throwable{

        transaccion0790.enviarTransaccion();

    }

    @Y("^Se completa los datos de Pago Luz y Agua provincias\"([^\"]*)\"$")
    public void seCompletaLosDatosDePagoLuzYAguaProvincias(String casodeprueba) throws Throwable {

        transaccion3970.ingresarDatosPagoLuzYAguaProvincias(casodeprueba);

    }

    @Entonces("^Se realiza pago luz y agua provincias$")
    public void seRealizaPagoLuzYAguaProvincias() throws Throwable{

        transaccion3970.enviarTransaccion();

    }

    @Y("^Se completa los datos de Consulta Retiros Multired\"([^\"]*)\"$")
    public void seCompletaLosDatosDeConsultaRetirosMultired(String casodeprueba) throws Throwable {

        transaccion0271.ingresarDatosConsultaRetirosMultired(casodeprueba);

    }

    @Entonces("^Se realiza consulta retiros multired$")
    public void seRealizaConsultaRetirosMultired() throws Throwable{

        transaccion0271.enviarTransaccion();

    }

    @Y("^Se completa los datos de Consulta Codigo CCI Ahorros MN ME\"([^\"]*)\"$")
    public void seCompletaLosDatosDeConsultaCodigoCCIAhorrosMNME(String casodeprueba) throws Throwable {

        transaccion1125.ingresarDatosConsultaCodigoCCIAhorrosMNME(casodeprueba);

    }

    @Entonces("^Se realiza consulta codigo CCI ahorros MN ME$")
    public void seRealizaConsultaCodigoCCIAhorrosMNME() throws Throwable{

        transaccion1125.enviarTransaccion();

    }

    @Y("^Se completa los datos de Pago de Tributo con Recibo Efectivo y Cheque\"([^\"]*)\"$")
    public void seCompletaLosDatosDePagoDeTributoConReciboEfectivoYCheque(String casodeprueba) throws Throwable {

        transaccion9650.ingresarDatosPagodeTributoconReciboEfectivoyCheque(casodeprueba);

    }


    @Entonces("^Se realiza consulta pago de tributo con recibo efectivo y cheque$")
    public void seRealizaConsultaPagoDeTributoConReciboEfectivoYCheque() throws Throwable{

        transaccion9650.enviarTransaccion();

    }


    @Y("^Se completa los datos de Pago de Tributos Varios Efectivo y Cheque\"([^\"]*)\"$")
    public void seCompletaLosDatosDePagoDeTributosVariosEfectivoYCheque(String casodeprueba) throws Throwable {

        transaccion9660.ingresarDatosPagodeTributosVariosEfectivoyCheque(casodeprueba);

    }

    @Entonces("^Se realiza consulta pago de tributos varios efectivo y cheque$")
    public void seRealizaConsultaPagoDeTributosVariosEfectivoYCheque() throws Throwable{

        transaccion9660.enviarTransaccion();

    }
}
