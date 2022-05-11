package com.meli.container.service;

import com.meli.container.Utils.Utils;
import com.meli.container.controller.response.ResponseContainer;
import com.meli.container.data.dto.Container;
import com.meli.container.data.persistence.entity.ContainerStats;
import com.meli.container.data.persistence.repository.ContainerStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContainerService {

    @Autowired
    private ContainerStatsRepository containerHistoryRepository;

    public ResponseContainer selectContainers(double budget, Container[] containers){

        int n = containers.length;
        double dp[][] = buildArrayResult(containers, budget);
        Double containerDispatched = dp[n][(int) budget];
        Double containerNotDispatched = Utils.calContainerDispatched(
                Utils.profitTotal(containers), containerDispatched);
        String containersDispatched = getContainers(dp, budget, containers);
        System.out.println("los contenedores selecionados son: " + containersDispatched);

        persisContainerStats(containerDispatched, containerNotDispatched, budget);

        return ResponseContainer.builder()
                .ContainersDispatched(containersDispatched).build();
    }

    /**
     * Metodo encargado de generar la matriz de los resultados intermedios
     *
     * @param containers
     * @param totalCost
     * @return
     */
    private double[][] buildArrayResult(Container[] containers, double totalCost) {

        int arraySize = containers.length;
        double dp[][] = new double[arraySize + 1][(int) (totalCost + 1)];

        for (int i = 0; i <= arraySize; i++) {
            for (int w = 0; w <= totalCost; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (containers[i - 1].getTransportCost() <= w) {
                    dp[i][w] = Utils.max(containers[i - 1].getContainerPrice() +
                                    dp[i - 1][(int) (w - containers[i - 1].getTransportCost())],
                            dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp;
    }

    /**
     * Metodo para conocer los nombre de los contenedores que se deben enviar
     * @param dp
     * @param totalCost
     * @param containers
     * @return
     */
    private String getContainers(double[][] dp, double totalCost, Container[] containers) {
        int n = containers.length;
        StringBuilder selectContainer = new StringBuilder();

        double j = totalCost;
        for (int i = n; i > 0; i--) {
            if (dp[i][(int) j] == dp[i - 1][(int) j]) {
                continue;
            } else {
                selectContainer.append(containers[i - 1].getName());
                selectContainer.append(" ");
                j -= containers[i - 1].getTransportCost();
            }
        }
        return selectContainer.toString();
    }

    /**
     * Se persiste las estadisticas de cada ejecución de selección
     *
     * @param containerDispatched
     * @param notDispatched
     * @param budgetUsed
     */
    private void persisContainerStats(Double containerDispatched, Double notDispatched, Double budgetUsed) {

        Optional<ContainerStats> optionalContainerStats = containerHistoryRepository.findById(1L);


        if (optionalContainerStats.isPresent()) {

            optionalContainerStats.get().setContainerDispatched(containerDispatched +
                    optionalContainerStats.get().getContainerDispatched());
            optionalContainerStats.get().setContainerNotDispatched(containerDispatched +
                    optionalContainerStats.get().getContainerNotDispatched());
            optionalContainerStats.get().setBudgetUsed(budgetUsed + optionalContainerStats.get().getBudgetUsed());

            containerHistoryRepository.save(optionalContainerStats.get());

        } else {
            ContainerStats containerStats = new ContainerStats();
            containerStats.setId(1L);
            containerStats.setContainerDispatched(containerDispatched);
            containerStats.setContainerNotDispatched(notDispatched);
            containerStats.setBudgetUsed(budgetUsed);
            containerHistoryRepository.save(containerStats);
        }
    }
}


