package com.dive2sky.user;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ray on 2016. 6. 28..
 */
public class UserManager {

  private UserManager() {
  }

  public static UserManager instance() {
    return (new UserManager());
  }

  public int create(User user) throws SQLException, ExistedUserException {

    if(getUserDao().existedUser(user.getUserId())) {
      throw new ExistedUserException(user.getUserId() + "�� �����ϴ� ���̵��Դϴ�.");
    }
    return getUserDao().create(user);
  }

  public int update(User user) throws SQLException {
    return getUserDao().update(user);
  }

  public int remove(String userId) throws SQLException {
    return getUserDao().remove(userId);
  }

  public User findUser(String userId) throws SQLException, UserNotFoundException {
    User user = getUserDao().findUser(userId);

    if (user == null) {
      throw new UserNotFoundException(userId + "�� �������� �ʴ� ���̵��Դϴ�.");
    }

    return user;
  }

  public List findUserList(int currentPage, int countPerPage) throws SQLException {
    return getUserDao().findUserList(currentPage, countPerPage);
  }

  public boolean login(String userId, String password) throws SQLException, PasswordMismatchException {
    User user = getUserDao().findUser(userId);

    if(user.isMatchPassword(password)) {
      throw new PasswordMismatchException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
    }

    return true;
  }

  private UserDao getUserDao() {
    return new UserDao();
  }
}
