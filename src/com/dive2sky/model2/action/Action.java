package com.dive2sky.model2.action;

import com.dive2sky.model2.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
