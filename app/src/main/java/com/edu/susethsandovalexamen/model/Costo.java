package com.edu.susethsandovalexamen.model;

public class Costo {
    private int tipoLamp;
    private double cantLamp;

    public void setTipoLamp(int tipoLamp) {
        this.tipoLamp = tipoLamp;
    }

    public void setCantLamp(double cantLamp) {
        this.cantLamp = cantLamp;
    }

    public String venta(){
        double costoPro;
        double precioVenta;
        double precioTot=0;
        if(tipoLamp==1){ //NORMALES
            costoPro = 50;
            precioVenta= (costoPro*0.85)+costoPro;
            precioTot= precioVenta*cantLamp;

        }else if(tipoLamp==2){ //DECORATIVAS
            costoPro = (((50*1.5)+50)*3)+125;
            precioVenta= (costoPro*0.85)+costoPro;
            precioTot= precioVenta*cantLamp;
        } else if(tipoLamp ==3){ //BURO
            costoPro = (50*1.5)+50;
            precioVenta= (costoPro*0.85)+costoPro;
            precioTot= precioVenta*cantLamp;
        }

        //SABER SI HAY DESCUENTO
        if(precioTot>1000){
            precioTot = descuento(precioTot);
        }
        return "Total a pagar: "+precioTot;

    }
    public double descuento(double precio){
        double precioFinal=0;
        if(precio>1000 && precio<3000){ //15%
            precioFinal = precio-(precio*.15);
        }else if(precio>3000 && precio<5000){ //20%
            precioFinal = precio-(precio*.2);
        }else if(precio>5000){ //25%
            precioFinal = precio- (precio*.25);
        }
        return precioFinal;
    }
}
