package com.demo.backGestor.modelos;

/*ESTADO ES P PROCESO , F FINALIZADO , E ESPERA , R Revision*/
public enum Estado{
    P , F , E , R;
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
            case "REVISION":
                resultado = Estado.R ;
                break;
        }

        return resultado ;
    }
}
