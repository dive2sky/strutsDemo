package com.dive2sky.model2.action;

import com.dive2sky.model2.ActionForward;
import com.dive2sky.user.User;
import com.dive2sky.user.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String userId = request.getParameter("userId");

    UserManager manager = UserManager.instance();
    User user = manager.findUser(userId);

    request.setAttribute("user",user);

    ActionForward forward = new ActionForward();
    forward.setPath("user_view.jsp");

    return forward;
  }
}
