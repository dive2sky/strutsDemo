package com.dive2sky.struts.action;

import com.dive2sky.struts.form.UserForm;
import com.dive2sky.user.User;
import com.dive2sky.user.UserManager;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFormAction extends Action {

  public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
  ) throws Exception {

    UserForm userForm = (UserForm)form;

    UserManager manager = UserManager.instance();
    User user = manager.findUser(userForm.getUserId());

    request.setAttribute("user", user);

    return mapping.findForward("user_modify");

  }
}
