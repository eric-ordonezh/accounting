package mx.com.cintli.db.factory;

import mx.com.cintli.db.authentication.DBAuthentication;

public interface DBFactory<T> {
	T getDB(DBAuthentication authentication);
	void closeDB();
}
