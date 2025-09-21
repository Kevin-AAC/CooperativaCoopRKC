package Cooperativa.Modelo;

public class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private String tipo;


    public Cuenta(String numeroCuenta, double saldo, String tipo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public void deposito(double monto){
        saldo += monto;

    }

    public void retirar(double monto){
        if(saldo < monto){
            System.out.println("Saldo Insuficiente");
        }else {
            System.out.println("Retiro Exitoso");
            saldo -= monto;
        }
    }
}
