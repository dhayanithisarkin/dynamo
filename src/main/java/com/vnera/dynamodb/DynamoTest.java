package com.vnera.dynamodb;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;


public class DynamoTest {
    private static AmazonDynamoDB client;

    public static void main(String[] args) {
        // This client will default to US West (Oregon)
        client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_WEST_2)
                .build();

        //saveItem();
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






}
