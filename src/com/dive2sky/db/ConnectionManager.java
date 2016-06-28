package com.dive2sky.db;

import java.sql.Connection;
import java.sql.SQLException;

import snaq.db.ConnectionPoolManager;


public class ConnectionManager {

  public static Connection getConnection() throws SQLException {
    ConnectionPoolManager dbm = ConnectionPoolManager.getInstance();

    return dbm.getConnection("mysql");
  }
}
