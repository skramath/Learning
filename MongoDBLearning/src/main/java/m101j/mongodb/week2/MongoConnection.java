package m101j.mongodb.week2;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

/**
 * Created by gopis on 2/2/2016.
 */
public class MongoConnection {

    public static void main(String[] args) {
        MongoClient client = new MongoClient(new ServerAddress("localhost",27017));
        MongoDatabase db = client.getDatabase("local");
        MongoCollection collection = db.getCollection("movies");
        System.out.println(collection.find().first());


    }
}
