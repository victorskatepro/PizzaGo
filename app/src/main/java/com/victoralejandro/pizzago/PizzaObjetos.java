package com.victoralejandro.pizzago;

/**
 * Created by JARVIS on 29/08/2017.
 */

public class PizzaObjetos {

    private String tipo,maza,extra;
    private int preciotipo,precioextra;

    public PizzaObjetos() {
        this.tipo = tipo;
        this.maza = maza;
        this.extra = extra;
        this.preciotipo = preciotipo;
        this.precioextra = precioextra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMaza() {
        return maza;
    }

    public void setMaza(String maza) {
        this.maza = maza;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public int getPreciotipo() {
        return preciotipo;
    }

    public void setPreciotipo(int preciotipo) {
        this.preciotipo = preciotipo;
    }


    public int getPrecioextra() {
        return precioextra;
    }

    public void setPrecioextra(int precioextra) {
        this.precioextra = precioextra;
    }
}
