package com.meli.container.Utils;

import com.meli.container.data.dto.Container;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access= AccessLevel.PRIVATE)
public class Utils {

    /**
     * Metodo encargado de retornar el valor máximo
     * @param a
     * @param b
     * @return
     */
    public static double max(double a, double b) {
        return (a > b) ? a : b;
    }

    /**
     * Metodo encargado de sumar los valores de cada contenedor
     * @param containers
     * @return
     */
    public static Double profitTotal(Container[] containers){
        Double profitTotal = 0D;
        for (Container c : containers ){
            profitTotal += c.getContainerPrice();
        }
        return profitTotal;
    }

    /**
     * Metodo para restar dos valores
     * @param a
     * @param b
     * @return
     */
    public static Double calContainerDispatched(Double a, Double b){
        return a-b;
    }

}
