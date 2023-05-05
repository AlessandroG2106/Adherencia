# language: es
@SARAWEB
Característica: SARAWEB TRX5

  @0710-IngresoACaja
  Esquema del escenario: <ID_CASO> SC001 - Ingreso a Caja

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de la transaccion"<casodeprueba>"
    Entonces  Se genera la transaccion

    Ejemplos:
      |    ID_CASO   | casodeprueba |
      |    CP_001    | 1            |
    #  |    CP_002    | 2            |
    #  |    CP_003    | 3            |
     # |    CP_004    | 4            |

  @7504-EmisionDeTelegiro
  Esquema del escenario: <ID_CASO> SC002 - Emisión de Telegiro

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de transaccion"<casodeprueba>"
    Entonces  Se emite el telegiro

    Ejemplos:
      |    ID_CASO   | casodeprueba |
      |    CP_005    | 5            |
      |    CP_006    | 6            |
      |    CP_007    | 7            |
      |    CP_008    | 8            |

  @3850-VentaME
  Esquema del escenario: <ID_CASO> SC004 - Venta ME

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de transaccion ventaME"<casodeprueba>"
    Entonces  Se emite la ventaME

    Ejemplos:
      |    ID_CASO   | casodeprueba |
      |    CP_013    | 13           |
      |    CP_014    | 14           |
      |    CP_015    | 15           |
      |    CP_016    | 16           |

  @3840-CompraME
  Esquema del escenario: <ID_CASO> SC003 - Compra ME

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de transaccion compraME"<casodeprueba>"
    Entonces  Se realiza la compraME

    Ejemplos:
      |    ID_CASO   | casodeprueba |
      |    CP_009    | 9            |
      |    CP_010    | 10           |
      |    CP_011    | 11           |
      |    CP_012    | 12           |




  @0100-ConsultaSaldoCuentas
  Esquema del escenario: <ID_CASO> SC005 - Consulta saldo cuentas

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de transaccion consulta saldo de cuentas"<casodeprueba>"
    Entonces  Se realiza la consulta saldo de cuentas

    Ejemplos:
      |    ID_CASO   | casodeprueba |
#      |    CP_017    | 17           |
#      |    CP_018    | 18           |
#      |    CP_019    | 19           |
#      |    CP_020    | 20           |
#      |    CP_021    | 21           |
#      |    CP_022    | 22           |
      |    CP_023    | 23           |
      |    CP_024    | 24           |

  @1800-DepositosEnCuentaDeAhorros
  Esquema del escenario: <ID_CASO> SC006 - Depósitos en cuenta de ahorros

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de transaccion depósito en cuenta de ahorros"<casodeprueba>"
    Entonces  Se realiza el depósito en cuenta de ahorros

    Ejemplos:
      |    ID_CASO   | casodeprueba |
      |    CP_025    | 25           |
      |    CP_026    | 26           |
      |    CP_027    | 27           |
      |    CP_028    | 28           |
      |    CP_029    | 29           |
      |    CP_030    | 30           |
      |    CP_031    | 31           |
      |    CP_032    | 32           |

  @1100-ConsultaDeSaldoDeAhorros
  Esquema del escenario: <ID_CASO> SC007 - Consulta de saldo de ahorros

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de transaccion consulta de saldo de ahorros"<casodeprueba>"
    Entonces  Se realiza la consulta de saldo de ahorros

    Ejemplos:
      |    ID_CASO   | casodeprueba |
      |    CP_033    | 33           |
      |    CP_034    | 34           |

  @0790-NotadeAbonoVarios
  Esquema del escenario: <ID_CASO> SC008 - Nota de Abono Varios

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de Nota de Abono Varios"<casodeprueba>"
    Entonces  Se realiza la nota de abono varios
    Ejemplos:
      |    ID_CASO   | casodeprueba |
      |    CP_035    | 35           |
      |    CP_036    | 36           |
      |    CP_037    | 37           |
      |    CP_038    | 38           |
      |    CP_039    | 39           |
      |    CP_040    | 40           |





  @3970-PagoLuzYAguaProvincias
  Esquema del escenario: <ID_CASO> SC009 - Pago Luz y Agua Provincias

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de Pago Luz y Agua provincias"<casodeprueba>"
    Entonces  Se realiza pago luz y agua provincias
    Ejemplos:
      |    ID_CASO   | casodeprueba |
      |    CP_041    | 41           |
      |    CP_042    | 42           |

  @0271-ConsultaRetirosMultired
  Esquema del escenario: <ID_CASO> SC010 - Consulta Retiros Multired

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de Consulta Retiros Multired"<casodeprueba>"
    Entonces  Se realiza consulta retiros multired
    Ejemplos:
      |    ID_CASO   | casodeprueba |
      |    CP_043    | 43           |
      |    CP_044    | 44           |

  @1125-ConsultaCodigoCCIAhorrosMNME
  Esquema del escenario: <ID_CASO> SC011 - Consulta Código CCI Ahorros MN ME

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de Consulta Codigo CCI Ahorros MN ME"<casodeprueba>"
    Entonces  Se realiza consulta codigo CCI ahorros MN ME
    Ejemplos:
      |    ID_CASO   | casodeprueba |
      |    CP_045    | 45           |
      |    CP_046    | 46           |

  @9650-PagodeTributoconReciboEfectivoyCheque
  Esquema del escenario: <ID_CASO> SC012 - Pago de Tributo con Recibo Efectivo y Cheque

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de Pago de Tributo con Recibo Efectivo y Cheque"<casodeprueba>"
    Entonces  Se realiza consulta pago de tributo con recibo efectivo y cheque
    Ejemplos:
      |    ID_CASO   | casodeprueba |
      |    CP_047    | 47           |
      |    CP_048    | 48           |
      |    CP_049    | 49           |
      |    CP_050    | 50           |
      |    CP_051    | 51           |
      |    CP_052    | 52           |
      |    CP_053    | 53           |
      |    CP_054    | 54           |
      |    CP_055    | 55           |
      |    CP_056    | 56           |

  @9660-PagodeTributosVariosEfectivoyCheque
  Esquema del escenario: <ID_CASO> SC013 - Pago de Tributos Varios Efectivo y Cheque

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de Pago de Tributos Varios Efectivo y Cheque"<casodeprueba>"
    Entonces  Se realiza consulta pago de tributos varios efectivo y cheque
    Ejemplos:
      |    ID_CASO   | casodeprueba |
      |    CP_057    | 57           |
      |    CP_058    | 58           |
      |    CP_059    | 59           |
      |    CP_060    | 60           |
      |    CP_061    | 61           |
      |    CP_062    | 62           |
      |    CP_063    | 63           |
      |    CP_064    | 64           |
      |    CP_065    | 65           |
      |    CP_066    | 66           |

  @2200-EmisiónDeCertificadoEnMNYME
  Esquema del escenario: <ID_CASO> SC008 - Emisión de certificado en MN y ME

    Dado      Usuario ingresa al aplicativo"<casodeprueba>"
    Cuando    Ingresa a la transaccion"<casodeprueba>"
    Y         Se completa los datos de Emisión de certificado en MN y ME"<casodeprueba>"
    Entonces  Se realiza la emisión de certificado en MN y ME
    Ejemplos:
      |    ID_CASO   | casodeprueba |
      |    CP_067    | 67           |
      |    CP_068    | 68           |
      |    CP_069    | 69           |
      |    CP_070    | 70           |
      |    CP_071    | 71           |
      |    CP_072    | 72           |