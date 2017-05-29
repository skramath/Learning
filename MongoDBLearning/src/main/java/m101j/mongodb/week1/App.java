package m101j.mongodb.week1;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

/**
 * Created by gopis on 10/14/2015.
 */
public class App {
    public static void main(String args[]){
        Document doc = new Document().append("str","Hello, MongoDB");
        System.out.println(doc.getString("str"));


        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(100).build();
        MongoClient client = new MongoClient(new ServerAddress(),options);
        MongoDatabase db =  client.getDatabase("local").withReadPreference(ReadPreference.secondary());
        MongoCollection<BsonDocument> coll = db.getCollection("movies", BsonDocument.class);




    }
}
