package Cooperativa.Modelo;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

public class CuentaAhorros extends Cuenta{
    private double interes;

    public CuentaAhorros(String numeroCuenta, double saldo, String tipo,double interes) {
        super(numeroCuenta, saldo, tipo);
        this.interes = interes;
    }

    public void intereses(){
        deposito(getSaldo()*interes);
    }
    public Double getInteres(){
        return  interes;
    }
    public void setInteres(double interes){
        this.interes = interes;
    }
}
