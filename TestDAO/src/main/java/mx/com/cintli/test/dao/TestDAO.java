package mx.com.cintli.test.dao;

import mx.com.cintli.db.factory.DBFactory;
import mx.com.cintli.db.mongodb.authentication.MongoDBAuthentication;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TestDAO {
	private MongoDatabase db;
	public TestDAO(DBFactory<MongoDatabase> factory){
		System.out.println("--.. TestDAO was created ..--");
		if(factory!=null)
			this.db = factory.getDB(new MongoDBAuthentication("test", null, null));
		test();
	}
	public void test(){
		System.out.println("**********************************");
		System.out.println("Creating a new document testPol");
		MongoCollection<Document> coll = this.db.getCollection("testPol");
		Document doc = new Document()
				.append("nombre", "Pedro")
				.append("apellido", "Gomez")
				.append("edad", "18")
				.append("info", new Document("cash",1000).append("card", "123145679867"));
		coll.insertOne(doc);
		System.out.println("doc in collection"+coll.count());
		Document myDoc = coll.find().first();
		System.out.println(myDoc.toJson());
	}
	
}
