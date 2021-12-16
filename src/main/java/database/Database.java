package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private static final String JDBC_URL = System.getenv("JDBC_DATABASE_URL");
    	//"jdbc:sqlite:/Users/taina/sqlite/Chinook_Sqlite.sqlite";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL);
    }
}