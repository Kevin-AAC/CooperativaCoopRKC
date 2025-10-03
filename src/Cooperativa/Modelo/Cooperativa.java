package Cooperativa.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Cooperativa {
    private String nombre;
    private String direccion;
    private String codigo;
    private List<Socio> socios = new ArrayList<>();
    private List<Cuenta> cuentasGlobales = new ArrayList<>();
    public Cooperativa(String nombre, String direccion, String codigo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigo = codigo;
    }

    public void agregarSocio(Socio socio){
        socios.add(socio);
    }

    public List<Socio> getSocios(){
        return socios;
    }
    public void agregarCuentaGlobal(Cuenta cuenta){
        cuentasGlobales.add(cuenta);
    }

    public List<Cuenta> getCuentas() {
        return cuentasGlobales;
    }


    @Override
    public String toString() {
        return "Cooperativa" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", codigo='" + codigo + '\'' +
                ", socios=" + socios
                ;
    }

}

