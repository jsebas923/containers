package com.meli.container.data;

import com.meli.container.data.dto.Container;
import com.meli.container.data.persistence.entity.ContainerStats;

public class Data {

    public static Container[] builContainers() {
        Container[] containers = new Container[2];

        Container c1 = new Container();
        Container c2 = new Container();

        c1.setName("C1");
        c1.setTransportCost(10);
        c1.setContainerPrice(25);

        c2.setName("C2");
        c2.setTransportCost(40);
        c2.setContainerPrice(50);

        containers[0] = c1;
        containers[1] = c2;

        return containers;
    }

    public static ContainerStats buildContainerStats() {
        ContainerStats containerStats = new ContainerStats();

        containerStats.setId(1L);
        containerStats.setContainerDispatched(120D);
        containerStats.setContainerNotDispatched(30D);
        containerStats.setBudgetUsed(200D);
        return containerStats;
    }
}
