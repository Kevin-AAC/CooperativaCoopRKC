package Cooperativa.App;

import Cooperativa.Modelo.Cooperativa;
import Cooperativa.Modelo.Cuenta;
import Cooperativa.Modelo.CuentaAhorros;
import Cooperativa.Modelo.Socio;
import Cooperativa.Transacciones.Deposito;
import Cooperativa.Transacciones.Retiro;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Socio socio1 = new Socio("Carpintero", "9876543");
        Cooperativa cooperativa = new Cooperativa("COOPRKC", "avenida avestruz", "007");

        Socio socio2 = new Socio("laura", "9876543");
        Socio socio3 = new Socio("Carlos", "57532545");
        Socio socio4 = new Socio("Jesus", "00120200");


        CuentaAhorros cuenta = new CuentaAhorros("001", 1000.0, "Ahorros",0.02);
        CuentaAhorros cuenta1 = new CuentaAhorros("002", 1000000, "Ahorros",0.01);
        CuentaAhorros cuenta2 = new CuentaAhorros("123", 2300.0, "Ahorros",0.02);
        CuentaAhorros cuenta3 = new CuentaAhorros("004", 750000.0, "Ahorros",0.05);
        CuentaAhorros cuenta4 = new CuentaAhorros("12345678", 1000.0, "Ahorros",0.01);
        System.out.println("==========Retirar============");
        Retiro retirar = new Retiro (5000000, cuenta1,"24/09/2025");
        retirar.ejecutar();
        Retiro retirar3 = new Retiro (20000, cuenta3,"24/09/2025");
        retirar3.ejecutar();

        System.out.println("==========Depositar============");
        Deposito deposito = new Deposito(350000,cuenta1,"23/09/2025");
        deposito.ejecutar();

        Deposito deposito2 = new Deposito(150000,cuenta2,"23/09/2025");
        deposito2.ejecutar();
        System.out.println(deposito+"\n"+deposito2);
        System.out.println("=========Agregar Cuenta a Socios=============");
        socio1.agregarCuenta(cuenta);
        socio1.agregarCuenta(cuenta);//duplicado
        socio1.agregarCuenta(cuenta2);
        socio2.agregarCuenta(cuenta1);
        socio3.agregarCuenta(cuenta3);
        socio4.agregarCuenta(cuenta4);
        System.out.println("=============Interes==============");
        cuenta2.intereses();
        System.out.println("💳 Cuenta " + cuenta2.getNumeroCuenta() +
                " | 📈 Interés E.A: " + (cuenta2.getInteres() * 100) + "%" +
                " | 💰 Saldo: $" + String.format("%,.2f", cuenta2.getSaldo()));
        System.out.println("====================================");

        cooperativa.agregarSocio(socio1);
        cooperativa.agregarSocio(socio2);
        cooperativa.agregarSocio(socio3);
        cooperativa.agregarSocio(socio4);
        System.out.println("📋 Socios registrados:");
        cooperativa.getSocios().stream().map(Socio::getNombre).forEach(System.out::println);
        System.out.println("===========Filtro de Cuentas ===========");
        cooperativa.getCuentas().stream().filter(cuentas -> cuentas.getSaldo()>500000).map(cuentas -> String.format( "💳 Cuenta Nº %s | Saldo: $%,.2f",cuentas.getNumeroCuenta(),cuentas.getSaldo())).forEach(System.out::println);
        System.out.println("===========Saldo Total Cooperativa ===========");
        double saldoCooperativa =cooperativa.getSocios().stream().flatMap(socio -> socio.getListaCuenta().stream()).map(Cuenta::getSaldo).reduce(0.0,(a,b)->a+b);
        System.out.println("\n💹 Suma total de saldos: " + saldoCooperativa);
        System.out.println("======================");
        System.out.println("Cooperativa info: " + cooperativa);

    }

}