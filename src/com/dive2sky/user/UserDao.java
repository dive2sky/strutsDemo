package com.dive2sky.user;

import com.dive2sky.db.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

  public int create(User user) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      StringBuffer insertQuery = new StringBuffer();
      insertQuery.append("INSERT INTO USERINFO VALUES ");
      insertQuery.append("(?, ?, ?, ?)");

      conn = ConnectionManager.getConnection();
      pstmt = conn.prepareStatement(insertQuery.toString());
      pstmt.setString(1, user.getUserId());
      pstmt.setString(2, user.getPassword());
      pstmt.setString(3, user.getName());
      pstmt.setString(4, user.getEmail());

      int result = pstmt.executeUpdate();

      pstmt.close();
      conn.close();

      return result;
    }
    finally {
      if ( pstmt != null ) {
        pstmt.close();
      }

      if ( conn != null ) {
        conn.close();
      }
    }
  }

  public int update(User user) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      StringBuffer updateQuery = new StringBuffer();
      updateQuery.append("UPDATE USERINFO SET ");
      updateQuery.append("password=?, name=?, email=? ");
      updateQuery.append("WHERE userid=? ");

      conn = ConnectionManager.getConnection();
      pstmt = conn.prepareStatement(updateQuery.toString());
      pstmt.setString(1, user.getPassword());
      pstmt.setString(2, user.getName());
      pstmt.setString(3, user.getEmail());
      pstmt.setString(4, user.getUserId());

      int result = pstmt.executeUpdate();

      pstmt.close();
      conn.close();

      return result;
    } finally {
      if ( pstmt != null ){
        pstmt.close();
      }

      if ( conn != null ){
        conn.close();
      }
    }
  }

  public int remove(String userId) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      StringBuffer removeQuery = new StringBuffer();
      removeQuery.append("DELETE FROM USERINFO ");
      removeQuery.append("WHERE userid=? ");

      conn = ConnectionManager.getConnection();
      pstmt = conn.prepareStatement(removeQuery.toString());
      pstmt.setString(1, userId);

      int result = pstmt.executeUpdate();

      pstmt.close();
      conn.close();

      return result;
    } finally {
      if ( pstmt != null ){
        pstmt.close();
      }

      if ( conn != null ){
        conn.close();
      }
    }
  }

  public User findUser(String userId) throws SQLException {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      StringBuffer findQuery = new StringBuffer();
      findQuery.append("SELECT ");
      findQuery.append("password, name, email ");
      findQuery.append("FROM USERINFO ");
      findQuery.append("WHERE userid=? ");

      con = ConnectionManager.getConnection();
      pstmt = con.prepareStatement(findQuery.toString());
      pstmt.setString(1, userId);

      rs = pstmt.executeQuery();

      User user = null;
      if ( rs.next() ){
        user = new User();

        user.setUserId(userId);
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
      }

      rs.close();
      pstmt.close();
      con.close();

      return user;
    } finally {
      if ( rs != null ){
        rs.close();
      }
      if ( pstmt != null ){
        pstmt.close();
      }
      if ( con != null ){
        con.close();
      }
    }
  }

  public boolean existedUser(String userId) throws SQLException {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      StringBuffer existedQuery = new StringBuffer();
      existedQuery.append("SELECT count(*) FROM USERINFO ");
      existedQuery.append("WHERE userid=? ");

      con = ConnectionManager.getConnection();
      pstmt = con.prepareStatement(existedQuery.toString());
      pstmt.setString(1, userId);

      rs = pstmt.executeQuery();

      int count = 0;
      if ( rs.next() ){
        count = rs.getInt(1);
      }

      rs.close();
      pstmt.close();
      con.close();

      if ( count == 1 ) {
        return true;
      } else {
        return false;
      }
    } finally {
      if ( rs != null ){
        rs.close();
      }
      if ( pstmt != null ){
        pstmt.close();
      }
      if ( con != null ){
        con.close();
      }
    }
  }

  public List findUserList(int currentPage, int countPerPage)
      throws SQLException {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      StringBuffer findQuery = new StringBuffer();
      findQuery.append("SELECT ");
      findQuery.append("userid, password, name, email ");
      findQuery.append("FROM USERINFO");

      con = ConnectionManager.getConnection();
      pstmt = con.prepareStatement(findQuery.toString(),
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY );

      rs = pstmt.executeQuery();

      int start = ((currentPage-1) * countPerPage) + 1;

      List userList = null;
      if ( (start >= 0) && rs.absolute(start) ) {
        boolean hasNext = false;
        userList = new ArrayList();

        do {
          User user = new User();
          user.setUserId(rs.getString("userid"));
          user.setPassword(rs.getString("password"));
          user.setName(rs.getString("name"));
          user.setEmail(rs.getString("email"));

          userList.add(user);
        } while ( (hasNext = rs.next()) && (--countPerPage > 0));
      }

      rs.close();
      pstmt.close();
      con.close();

      return userList;
    } finally {
      if ( rs != null ){
        rs.close();
      }
      if ( pstmt != null ){
        pstmt.close();
      }
      if ( con != null ){
        con.close();
      }
    }
  }

}