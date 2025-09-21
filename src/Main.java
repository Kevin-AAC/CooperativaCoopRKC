import Cooperativa.Modelo.Cooperativa;
import Cooperativa.Modelo.Cuenta;
import Cooperativa.Modelo.CuentaAhorros;
import Cooperativa.Modelo.Socio;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         Cooperativa cooperativa = new Cooperativa("Coo pollitos en fuga","calle siempre viva avenida avestruz","123456");
         Socio socio1 = new Socio ("Carpintero","9876543");
         Cuenta cuenta = new CuentaAhorros("12345678",1000.0,"A");
         cooperativa.agregarSocio(socio1);

         System.out.println("Cooperativa info: " + cooperativa.getSocios());
         System.out.println("Socio el pollo: " + socio1.getNombre());
         System.out.println("Cuenta del pollo: " + cuenta.getSaldo());



    }

}