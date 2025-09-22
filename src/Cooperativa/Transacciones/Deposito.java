package Cooperativa.Transacciones;

import Cooperativa.Modelo.Cuenta;

public class Deposito implements Transaccion{
    private double monto;
    private Cuenta cuentaDestino;
    private String fecha;

    public Deposito(double monto, Cuenta cuentaDestino, String fecha) {
        this.monto = monto;
        this.cuentaDestino = cuentaDestino;
        this.fecha = fecha;
    }

    @Override
    public void ejecutar() {
        cuentaDestino.deposito(monto);

    }

    @Override
    public double getMonto() {
        return monto;
    }

    @Override
    public String toString(){
        return "Deposito: "+monto+" el: "+ fecha;
    }
}
