package com.saloonsoft.app;

//Requires official Java MongoDB Driver 3.6+
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Test {
 
 public static void main(String[] args) {
     
     try (MongoClient client = new MongoClient("salonsoft-shard-00-01-bpikx.mongodb.net", 27017)) {
         
         MongoDatabase database = client.getDatabase("salonsoft");
         MongoCollection<Document> collection = database.getCollection("Test3");
         
         // Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/
         
         Document query = new Document();
         
         Block<Document> processBlock = new Block<Document>() {
             @Override
             public void apply(final Document document) {
                 System.out.println(document);
             }
         };
         
         collection.find(query).forEach(processBlock);
         
     } catch (MongoException e) {
         // handle MongoDB exception
     }
 }
 
}