package com.dive2sky.model2.action;

import com.dive2sky.model2.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertFormAction implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionForward forward = new ActionForward();
    forward.setPath("user_write.jsp");
    forward.setRedirect(true);

    return forward;
  }
}
