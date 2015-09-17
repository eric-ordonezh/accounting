package mx.com.cintli.db.mongodb.authentication;

import mx.com.cintli.db.authentication.DBAuthentication;

public class MongoDBAuthentication implements DBAuthentication{
	private String dbName;
	private String user;
	private String password;
	
	public MongoDBAuthentication(String dbName,String user,String password){
		this.dbName = dbName;
		this.user = user;
		this.password = password;
	}
	
	@Override
	public String getDB() {
		return this.dbName;
	}
	@Override
	public String getUser() {
		return this.user;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	
	public void setDB(String dbName) {
		this.dbName=dbName;
	}
}
