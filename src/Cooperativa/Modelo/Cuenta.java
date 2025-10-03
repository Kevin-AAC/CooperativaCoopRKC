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
        System.out.println("Deposito exitoso");

    }

    public void retirar(double monto){
      try {
          if(monto <= 10000){
              throw new IllegalArgumentException("Cantitad minima a retirar debe ser 10.000");
          }
          if (monto > saldo){
              throw new IllegalArgumentException("Saldo insuficiente");
          }
          saldo -= monto;
          System.out.println("Retito exitoso " + monto);
      } catch (IllegalArgumentException e){
          System.out.println("❌ Ha ocurrido un error verifique la informacion: " + e.getMessage());

      } catch (Exception e){
          System.out.println("❌ Ha ocurrido un error verifique su saldo: " + e.getMessage());
      }


    }

    public double getSaldo(){
        return  saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    @Override
    public String toString(){
        return "Cuenta{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", tipo='" + tipo + '\'' +
                '}';
    }

}
