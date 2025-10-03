package Cooperativa.App;

import Cooperativa.Modelo.Cooperativa;
import Cooperativa.Modelo.Cuenta;
import Cooperativa.Modelo.CuentaAhorros;
import Cooperativa.Modelo.Socio;
import Cooperativa.Transacciones.Deposito;
import Cooperativa.Transacciones.Retiro;


import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Cooperativa cooperativa = new Cooperativa("COOPRKC", "avenida avestruz", "007");

    public static void main(String[] args) {

        int opcion = 0;
        while (opcion != 9) {
            mostrarMenu();
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();  // limpiar buffer
                switch (opcion) {
                    case 1:
                        agregarSocio();
                        break;
                    case 2:
                        crearCuenta();
                        break;
                    case 3:
                        realizarRetiro();
                        break;
                    case 4:
                        realizarDeposito();
                        break;
                    case 5:
                        asignarCuenta();
                        break;
                    case 6:
                        filtarCuentas();
                        break;
                    case 7:
                        listaSocios();
                        break;
                    case 8:
                        sumaTotalCooperativa();
                        break;
                    case 9:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida, inténtelo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor ingresa un número válido.");
                scanner.nextLine();  // limpiar entrada incorrecta
            }
        }
    }
        static void mostrarMenu() {
        System.out.println("=== Cooperativa RKC ===");
        System.out.println("1. Ingresar Socio");
        System.out.println("2. Crear Cuenta");
        System.out.println("3. Realizar Retiro");
        System.out.println("4. Realizar Deposito");
        System.out.println("5. Asignar Cuenta");
        System.out.println("6. Filtar Cuenta");
        System.out.println("7. Listar socios");
        System.out.println("8. sumaTotalCooperativa");
        System.out.println("9. Salir");
        System.out.print("Selecciona una opción: ");
    }

    static void agregarSocio() {
        System.out.println("Ingrese el nombre del socio");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la cédula del socio");
        String cedula = scanner.nextLine();
        Socio nuevoSocio = new Socio(nombre, cedula);
        cooperativa.agregarSocio(nuevoSocio);
        System.out.println("Socio agregado exitosamente: " + nuevoSocio);

    }

    static Socio buscarSocio(String cedula) {
        return cooperativa.getSocios().stream().filter(socio -> socio.getCedula().equals(cedula)).findFirst().orElse(null);
    }

    static void asignarCuenta() {
        System.out.println("Ingrese la cedula del socio");
        String cedula = scanner.nextLine();
        Socio socio = buscarSocio(cedula);
        if (socio == null) {
            System.out.println("socio no encontrado");
            return;
        }
        System.out.println("Ingrese el numero de Cuenta");
        String numeroCuenta = scanner.nextLine();
        if (verificarCuentaEnSocios(numeroCuenta)) {
            System.out.println("Error esta cuenta ya esta asignada");
            return;
        }
        Cuenta cuenta = cooperativa.getCuentas().stream()
                .filter(c -> c.getNumeroCuenta().equals(numeroCuenta))
                .findFirst()
                .orElse(null);

        if (cuenta == null) {
            System.out.println("No existe esta cuenta");
            return;
        }
        socio.agregarCuenta(cuenta);
        System.out.println("Cuenta " + numeroCuenta + " Asignada Correctamente al socio " + socio.getNombre());


    }

    static CuentaAhorros crearCuenta() {
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
        CuentaAhorros nuevaCuenta = new CuentaAhorros(numeroCuenta, saldo, tipo, interes);
        cooperativa.agregarCuentaGlobal(nuevaCuenta);
        System.out.println("Cuenta creada exitosamente: " + numeroCuenta);
        return nuevaCuenta;

    }

    static void realizarRetiro(){
        try {
            System.out.println("Realizar retiro ");
            System.out.print("Ingrese el número de cuenta: ");
            String numero = scanner.nextLine();

            Cuenta cuenta = cooperativa.getCuentas().stream()
                    .filter(c -> c.getNumeroCuenta().equals(numero))
                    .findFirst()
                    .orElse(null);

            if (cuenta == null) {
                throw new IllegalArgumentException("No existe la cuenta " + numero);
            }
            System.out.println("Ingrese el valor a retirar");
            double monto = scanner.nextDouble();
            scanner.nextLine();
            cuenta.retirar(monto);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    static boolean verificarCuentaEnSocios(String numeroCuenta) {
        return cooperativa.getSocios().stream().flatMap(socio -> socio.getListaCuenta().stream())
                .anyMatch(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta));

    }

    static void filtarCuentas() {
        System.out.println("===========Filtro de Cuentas ===========");
        System.out.println("Ingrese el Monto para filtrar");
        double monto = scanner.nextDouble();
        scanner.nextLine();
        cooperativa.getCuentas().stream()
                .filter(cuenta -> cuenta.getSaldo() > monto)
                .map(cuenta -> String.format("💳 Cuenta Nº %s | Saldo: $%,.2f", cuenta.getNumeroCuenta(), cuenta.getSaldo()))
                .forEach(System.out::println);
    }

    static void listaCuentas() {
        System.out.println("Mostrando todas las cuentas:");
        cooperativa.getCuentas().forEach(cuenta -> System.out.println(
                String.format("Cuenta %s | Saldo: $%,.2f", cuenta.getNumeroCuenta(), cuenta.getSaldo())
        ));

    }

    static void listaSocios() {
        cooperativa.getSocios().stream().map(Socio::getNombre).forEach(System.out::println);
    }

    static void sumaTotalCooperativa() {
        System.out.println("===========Saldo Total Cooperativa ===========");
        double saldoCooperativa = cooperativa.getCuentas().stream().mapToDouble(Cuenta::getSaldo).sum();
        System.out.println("\n💹 Suma total de saldos: $" + String.format("%,.2f", saldoCooperativa));
    }
    static void realizarDeposito(){
        try {
            System.out.println("Realizar deposito ");
            System.out.print("Ingrese el número de cuenta: ");
            String numero = scanner.nextLine();

            Cuenta cuenta = cooperativa.getCuentas().stream()
                    .filter(c -> c.getNumeroCuenta().equals(numero))
                    .findFirst()
                    .orElse(null);

            if (cuenta == null) {
                throw new IllegalArgumentException("No existe la cuenta " + numero);
            }
            System.out.println("Ingrese el valor a depositar");
            double monto = scanner.nextDouble();
            scanner.nextLine();
            cuenta.deposito(monto);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

}


