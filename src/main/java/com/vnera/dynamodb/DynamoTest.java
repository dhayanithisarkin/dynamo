package com.vnera.dynamodb;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import java.util.List;


public class DynamoTest {
    private static AmazonDynamoDB client;

    public static void main(String[] args) {
        // This client will default to US West (Oregon)
        client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_WEST_2)
                .build();

        //saveItem();
        //readItem();
        deleteItem();
        readItem();

        client.shutdown();
    }

    private static void saveItem() {
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        InventoryItem item = new InventoryItem();
        item.setCustomerOt("10000:515");
        item.setOid(1L);
        item.setValue("Value of oid 1");

        mapper.save(item);
    }

    private static void readItem() {
        InventoryItem item = new InventoryItem();
        item.setCustomerOt("10000:515");

        DynamoDBQueryExpression<InventoryItem> query = new DynamoDBQueryExpression<InventoryItem>()
                .withHashKeyValues(item);

        DynamoDBMapper mapper = new DynamoDBMapper(client);
        List<InventoryItem> itemList = mapper.query(InventoryItem.class, query);

        for (InventoryItem it : itemList) {
            System.out.println(it.getCustomerOt());
            System.out.println(it.getOid());
            System.out.println(it.getValue());
        }
    }

    private static void deleteItem() {
        InventoryItem item = new InventoryItem();
        item.setCustomerOt("10000:515");

        DynamoDBMapper mapper = new DynamoDBMapper(client);
        mapper.delete(item);
    }
}
