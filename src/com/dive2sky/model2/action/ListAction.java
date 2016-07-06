package com.dive2sky.model2.action;

import com.dive2sky.model2.ActionForward;
import com.dive2sky.user.UserManager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String currentPageStr = request.getParameter("currentPage");

    int currentPage = 1;

    if( (currentPageStr != null) && (!currentPageStr.equals(""))) {
      currentPage = Integer.parseInt(currentPageStr);
    }

    int countPerPage = 10;

    UserManager manager = UserManager.instance();
    List userList = manager.findUserList(currentPage, countPerPage);

    request.setAttribute("userList", userList);

    ActionForward forward = new ActionForward();
    forward.setPath("user_list.jsp");

    return forward;
  }
}
