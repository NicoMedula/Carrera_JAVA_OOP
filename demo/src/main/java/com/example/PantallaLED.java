package com.example;

public class PantallaLED {
    INombreParaLed value;
    
        public PantallaLED(INombreParaLed value){
            this.value = value;
        }
    
    public String getTexto() {
       return value.getNombreParaLed();
    }

   

}
