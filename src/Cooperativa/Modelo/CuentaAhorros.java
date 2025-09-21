package Cooperativa.Modelo;

public class CuentaAhorros extends Cuenta{
    private double interes;

    public CuentaAhorros(String numeroCuenta, double saldo, String tipo) {
        super(numeroCuenta, saldo, tipo);
    }

    public void intereses(){
        deposito(getSaldo()*interes);
    }
}
