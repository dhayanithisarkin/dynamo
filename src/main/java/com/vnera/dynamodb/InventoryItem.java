package com.vnera.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "test_dhaya_store")
public class InventoryItem {
    private String customerOt;
    private long oid;
    private String value;

    @DynamoDBHashKey(attributeName = "customer_ot")
    public String getCustomerOt() {
        return customerOt;
    }
    public void setCustomerOt(String customerOt) {
        this.customerOt = customerOt;
    }

    @DynamoDBRangeKey(attributeName = "oid")
    public long getOid() {
        return oid;
    }
    public void setOid(long oid) {
        this.oid = oid;
    }

    @DynamoDBAttribute(attributeName = "value")
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
