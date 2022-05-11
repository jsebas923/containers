package com.meli.container.Utils;

import com.meli.container.data.Data;
import com.meli.container.data.dto.Container;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    void maxTest(){
        double a = 5;
        double b = 3;
        Assertions.assertEquals(Utils.max(a,b), 5);
    }

    @Test
    void profitTotalTest(){
        Container[] containers = Data.builContainers();
        Double profitTotal = Utils.profitTotal(containers);

        Assertions.assertNotNull(profitTotal);
        Assertions.assertEquals(profitTotal,75);
    }

    @Test
    void calContainerDispatchedTest(){
        Double a = 69454D;
        Double b = 36509D;

        Assertions.assertNotNull(Utils.calContainerDispatched(a, b));
    }
}
