package Cooperativa.Transacciones;

import Cooperativa.Modelo.Cuenta;

public class Operaciones implements Transaccion{
     private double monto;
     private Cuenta cuentaOrigen;
     private String fecha;


  public Operaciones (double monto, Cuenta cuentaOrigen, String fecha){
      this.monto = monto;
      this.cuentaOrigen= cuentaOrigen;
      this.fecha = fecha;
  }
  @Override
  public void ejecutar(){
      cuentaOrigen.retirar(monto);
  }
  @Override
    public double getMonto(){
      return monto;
  }
}
