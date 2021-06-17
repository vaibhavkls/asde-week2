package com.day7;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class ConnectToMongo {
    public static void main(String[] args) {
        String connectionString = System.getProperty("mongodb+srv://username:password@cluster0-abcde.mongodb.net/test?w=majority");
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
        }
    }
}