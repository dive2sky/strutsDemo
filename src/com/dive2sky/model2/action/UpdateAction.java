package com.dive2sky.model2.action;

import com.dive2sky.model2.ActionForward;
import com.dive2sky.user.User;
import com.dive2sky.user.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAction implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    User user = new User();
    user.setUserId(request.getParameter("userId"));
    user.setPassword(request.getParameter("password"));
    user.setName(request.getParameter("name"));
    user.setEmail(request.getParameter("email"));

    UserManager manager = UserManager.instance();
    manager.update(user);

    ActionForward forward = new ActionForward();
    forward.setPath("user_list.m2");
    forward.setRedirect(true);

    return forward;

  }
}
