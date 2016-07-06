package com.dive2sky.model2.action;

import com.dive2sky.model2.ActionForward;
import com.dive2sky.user.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAction implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String userId = request.getParameter("userId");

    UserManager manager = UserManager.instance();
    manager.remove(userId);

    ActionForward forward = new ActionForward();
    forward.setPath("user_list.m2");
    forward.setRedirect(true);

    return forward;
  }
}
