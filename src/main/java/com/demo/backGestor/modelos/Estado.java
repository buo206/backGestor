package com.demo.backGestor.modelos;

/*ESTADO ES P PROCESO , F FINALIZADO , E ESPERA*/
public enum Estado{
    P , F , E;
    public static Estado getEstado(String state){
        state = state.toUpperCase();
        Estado resultado = Estado.E;
        switch (state){
            case "PROCESO" :
                resultado =  Estado.P;
                break ;
            case "FINALIZADO" :
                resultado =  Estado.F;
                break ;
            case "ESPERA":
                resultado =  Estado.E;
                break ;

        }

        return resultado ;
    }
}
