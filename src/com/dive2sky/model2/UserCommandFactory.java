package com.dive2sky.model2;

import com.dive2sky.model2.action.Action;
import com.dive2sky.model2.action.DeleteAction;
import com.dive2sky.model2.action.IllegalCommandException;
import com.dive2sky.model2.action.InsertAction;
import com.dive2sky.model2.action.InsertFormAction;
import com.dive2sky.model2.action.ListAction;
import com.dive2sky.model2.action.LoginAction;
import com.dive2sky.model2.action.LoginFormAction;
import com.dive2sky.model2.action.UpdateAction;
import com.dive2sky.model2.action.UpdateFormAction;
import com.dive2sky.model2.action.ViewAction;

public class UserCommandFactory {

  private UserCommandFactory() {

  }

  public static UserCommandFactory getInstance() {
    return new UserCommandFactory();
  }

  public Action getAction(String command) throws IllegalCommandException {
    Action action = null;

    if (command.equals("list")) {
      action = new ListAction();
    } else if (command.equals("view")) {
      action = new ViewAction();
    } else if (command.equals("insert")) {
      action = new InsertAction();
    } else if (command.equals("update")) {
      action = new UpdateAction();
    } else if (command.equals("delete")) {
      action = new DeleteAction();
    } else if (command.equals("login")) {
      action = new LoginAction();
    } else if (command.equals("updateForm")) {
      action = new UpdateFormAction();
    } else if (command.equals("insertForm")) {
      action = new InsertFormAction();
    } else if (command.equals("loginForm")) {
      action = new LoginFormAction();
    } else {
      throw new IllegalCommandException("잘못된 실행명령입니다. 다른 명령을 실행해 주십시요");
    }

    return action;
  }
}
