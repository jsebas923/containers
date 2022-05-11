package com.meli.container.data.persistence.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamoDBTable(tableName = "container_stats")
public class ContainerStats {

    @DynamoDBHashKey
    private Long id;

    @DynamoDBAttribute(attributeName = "container_dispatched")
    private Double containerDispatched;

    @DynamoDBAttribute(attributeName = "container_not-dispatched")
    private Double containerNotDispatched;

    @DynamoDBAttribute(attributeName = "budget_used")
    private Double budgetUsed;
}
