package Cooperativa.Modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Socio {
    private String nombre;
    private String cedula;
    private ArrayList<String> listaCuenta = new ArrayList<>();

    public Socio (String nombre, String cedula){
        this.nombre = nombre;
        this.cedula = cedula;
        this.listaCuenta = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ArrayList<String> getListaCuenta() {
        return listaCuenta;
    }

    public void setListaCuenta(ArrayList<String> listaCuenta) {
        this.listaCuenta = listaCuenta;
    }
    @Override
    public String toString(){
        return ""+nombre+"";
    }
}

