package org.mongodb.sample.main;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.mongodb.sample.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by bapaydin on 29.09.2016.
 */
public class MongoDBDemo {
   static Logger logger = Logger.getLogger(MongoDBDemo.class.getName());

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase test = mongoClient.getDatabase("test");
        if(test != null){
            logger.info(test.getName() +" DB initialize successfully");
        }



        MongoCollection<Document> users = test.getCollection("users");
        if(users != null){
            logger.info(users.toString() +" collection created successfully");
            Document document = users.find().first();
            logger.info("First Document in collection : " + document.toJson());
        }

        User createdUser =createUser();
        Document userDocument = createUserDocument(createdUser);
        users.insertOne(userDocument);

        List<Document> documents = createDocuments();
        users.insertMany(documents);
    }

    public static User createUser(){
        User u = new User();
        u.setId(3);
        u.setName("Pankaj");
        u.setEmployee(true);
        u.setRole("CEO");
        return u ;
    }

    public static Document createUserDocument(User u){
       Document document = new Document("_id",u.getId())
        .append("name",u.getName())
        .append("role",u.getRole())
        .append("isEmployee",u.isEmployee());
        return document;
    }

    public static List<Document> createDocuments(){
        List<Document> documentList = new ArrayList<Document>();
        for(int i = 0 ; i < 10 ; i++){
            documentList.add(new Document("i",i));
        }
        return documentList;
    }
}
