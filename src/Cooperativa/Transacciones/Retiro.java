package Cooperativa.Transacciones;

import Cooperativa.Modelo.Cuenta;

import java.awt.print.Printable;

public class Retiro implements Transaccion {
    private double montoAretirar;
    private Cuenta cuentaAretirar;
    private String fechaRetiro;

    public Retiro(double montoAretirar, Cuenta cuentaAretirar, String fechaRetiro) {
        this.montoAretirar = montoAretirar;
        this.cuentaAretirar = cuentaAretirar;
        this.fechaRetiro = fechaRetiro;

    }
    @Override
    public void ejecutar (){
        cuentaAretirar.retirar(montoAretirar);
    }
    @Override
    public double getMonto(){
        return montoAretirar;
    }
    @Override
    public String toString (){
        return "Retirar: "+montoAretirar+ "Fecha del retiro"+fechaRetiro;
    }
}
