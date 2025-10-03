package Cooperativa.App;

import Cooperativa.Modelo.Cooperativa;
import Cooperativa.Modelo.Cuenta;
import Cooperativa.Modelo.CuentaAhorros;
import Cooperativa.Modelo.Socio;
import Cooperativa.Transacciones.Deposito;
import Cooperativa.Transacciones.Retiro;


import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Cooperativa cooperativa = new Cooperativa("COOPRKC", "avenida avestruz", "007");
    static List<CuentaAhorros> cuentasGlobales = new ArrayList<>();
    public static void main(String[] args) {
        int opcion=0;

        while(opcion != 9){
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    agregarSocio();
                    break;
                case 2:
                    crearCuenta();
                    break;
                case  3:
                    //realizarRetiro();
                    break;
                case 4:
                    //realizarDeposito();
                case 5:
                    asignarCuenta();


            }
        }



        /*
        Socio socio1 = new Socio("Carpintero", "9876543");
        Socio socio2 = new Socio("laura", "9876543");
        Socio socio3 = new Socio("Carlos", "57532545");
        Socio socio4 = new Socio("Jesus", "00120200");
        */
        CuentaAhorros cuenta = new CuentaAhorros("001", 1000.0, "Ahorros",0.02);
        CuentaAhorros cuenta1 = new CuentaAhorros("002", 1000000, "Ahorros",0.01);
        CuentaAhorros cuenta2 = new CuentaAhorros("123", 2300.0, "Ahorros",0.02);
        CuentaAhorros cuenta3 = new CuentaAhorros("004", 750000.0, "Ahorros",0.05);
        CuentaAhorros cuenta4 = new CuentaAhorros("12345678", 1000.0, "Ahorros",0.01);

        System.out.println("==========Retirar============");
        Retiro retirar = new Retiro (5000, cuenta1,"24/09/2025");
        retirar.ejecutar();
        Retiro retirar3 = new Retiro (50000, cuenta3,"24/09/2025");
        retirar3.ejecutar();

        System.out.println("==========Depositar============");
        Deposito deposito = new Deposito(350000,cuenta1,"23/09/2025");
        deposito.ejecutar();

        Deposito deposito2 = new Deposito(150000,cuenta2,"23/09/2025");
        deposito2.ejecutar();
        System.out.println(deposito+"\n"+deposito2);

        System.out.println("=============Interes==============");
        cuenta2.intereses();
        System.out.println("💳 Cuenta " + cuenta2.getNumeroCuenta() +
                " | 📈 Interés E.A: " + (cuenta2.getInteres() * 100) + "%" +
                " | 💰 Saldo: $" + String.format("%,.2f", cuenta2.getSaldo()));


        cooperativa.getSocios().stream().map(Socio::getNombre).forEach(System.out::println);
        System.out.println("===========Filtro de Cuentas ===========");
        cooperativa.getCuentas().stream().filter(cuentas -> cuentas.getSaldo()>500000).map(cuentas -> String.format( "💳 Cuenta Nº %s | Saldo: $%,.2f",cuentas.getNumeroCuenta(),cuentas.getSaldo())).forEach(System.out::println);
        System.out.println("===========Saldo Total Cooperativa ===========");
        double saldoCooperativa =cooperativa.getSocios().stream().flatMap(socio -> socio.getListaCuenta().stream()).map(Cuenta::getSaldo).reduce(0.0,(a,b)->a+b);
        System.out.println("\n💹 Suma total de saldos: $" + String.format("%,.2f", saldoCooperativa));
        System.out.println("======================");
        System.out.println("Cooperativa info: " + cooperativa);


    }
    static void mostrarMenu(){
        System.out.println("=== Cooperativa RKC ===");
        System.out.println("1. Ingresar Socio");
        System.out.println("2. Crear Cuenta");
        System.out.println("3. Realizar Retiro");
        System.out.println("4. Realizar Deposito");
        System.out.println("5. Asignar Cuenta");
        System.out.println("9. Salir");
        System.out.print("Selecciona una opción: ");
    }
    static void agregarSocio(){
        System.out.println("Ingrese el nombre del socio");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la cédula del socio");
        String cedula = scanner.nextLine();
        Socio nuevoSocio = new Socio(nombre,cedula);
        cooperativa.agregarSocio(nuevoSocio);
        System.out.println("Socio agregado exitosamente: " + nuevoSocio);

    }
    static Socio buscarSocio(String cedula){
        return cooperativa.getSocios().stream().filter(socio -> socio.getCedula().equals(cedula)).findFirst().orElse(null);
    }

    static void asignarCuenta(){
        System.out.println("Ingrese la cedula del socio");
        String cedula = scanner.nextLine();
        Socio socio = buscarSocio(cedula);
        if(socio == null){
            System.out.println("socio no encontrado");
            return;
        }
        System.out.println("Ingrese el numero de Cuenta");
        String numeroCuenta = scanner.nextLine();
        if(verificarCuentaEnSocios(numeroCuenta)){
            System.out.println("Error esta cuenta ya esta asignada");
            return;
        }
        CuentaAhorros cuenta = cuentasGlobales.stream().filter(cuentas -> cuentas.getNumeroCuenta().equals(numeroCuenta)).findFirst().orElse(null);
        if(cuenta == null){
            System.out.println("No existe esta cuenta");
            return;
        }
        socio.agregarCuenta(cuenta);
        System.out.println("Cuenta "+numeroCuenta+" Asignada Correctamente al socio "+ socio.getNombre());


    }

    static CuentaAhorros crearCuenta(){
        System.out.println("Ingrese numero de cuenta");
        String numeroCuenta = scanner.nextLine();
        System.out.println("Ingrese Saldo");
        double saldo = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese el tipo de cuenta");
        String tipo = scanner.nextLine();
        System.out.println("Ingrese la taza de interes");
        double interes = scanner.nextDouble();
        scanner.nextLine();
        CuentaAhorros nuevaCuenta = new CuentaAhorros(numeroCuenta,saldo,tipo,interes);
        cuentasGlobales.add(nuevaCuenta);
        System.out.println("Cuenta creada exitosamente: " + numeroCuenta);
        return nuevaCuenta;

    }
    static boolean verificarCuentaEnSocios(String numeroCuenta){
        return cooperativa.getSocios().stream().flatMap(socio -> socio.getListaCuenta().stream())
                .anyMatch(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta));

    }



}
