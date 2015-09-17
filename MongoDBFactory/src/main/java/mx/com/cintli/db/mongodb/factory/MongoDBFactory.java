package mx.com.cintli.db.mongodb.factory;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import mx.com.cintli.db.authentication.DBAuthentication;
import mx.com.cintli.db.factory.DBFactory;

public class MongoDBFactory implements DBFactory<MongoDatabase>{
	private MongoClient mongoClient;
	
	public MongoDatabase getDB(DBAuthentication authentication){
		if(this.mongoClient==null)
			this.mongoClient = new MongoClient( "localhost");//,27017 
		return mongoClient.getDatabase(authentication.getDB());
	}
	public void closeDB(){
		if(this.mongoClient!=null)
			this.mongoClient.close();
	}
}