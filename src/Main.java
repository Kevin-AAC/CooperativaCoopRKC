import Cooperativa.Modelo.Cooperativa;
import Cooperativa.Modelo.Cuenta;
import Cooperativa.Modelo.CuentaAhorros;
import Cooperativa.Modelo.Socio;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Socio socio1 = new Socio("Carpintero", "9876543");
        Cooperativa cooperativa = new Cooperativa("COOPRKC", "avenida avestruz", "007");

        Socio socio2 = new Socio("laura", "9876543");
        Socio socio3 = new Socio("Carlos", "57532545");
        Socio socio4 = new Socio("Jesus", "00120200");


        Cuenta cuenta = new CuentaAhorros("001", 1000.0, "Ahorros");
        Cuenta cuenta1 = new Cuenta("002", 1000000, "Corriente");
        Cuenta cuenta2 = new CuentaAhorros("123", 230.000, "Ahorros");
        Cuenta cuenta3 = new CuentaAhorros("004", 750.000, "Ahorros");
        Cuenta cuenta4 = new Cuenta("12345678", 1000.0, "Corriente");

        socio1.agregarCuenta(cuenta);
        socio1.agregarCuenta(cuenta2);
        socio2.agregarCuenta(cuenta1);
        socio3.agregarCuenta(cuenta3);
        socio4.agregarCuenta(cuenta4);

        cooperativa.agregarSocio(socio1);
        cooperativa.agregarSocio(socio2);
        cooperativa.agregarSocio(socio3);

        cooperativa.getSocios().stream().map(Socio::getNombre).forEach(System.out::println);


        System.out.println("Socio : " + socio1.getNombre());
        socio1.mostrarCuenta();
        System.out.println("Socio : " + socio2.getNombre());
        socio2.mostrarCuenta();

        cooperativa.agregarSocio(socio1);

        System.out.println("Cooperativa info: " + cooperativa);
        System.out.println("Socio el pollo: " + socio1.getNombre());


    }

}