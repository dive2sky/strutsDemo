package com.dive2sky.struts.action;

import com.dive2sky.struts.form.UserForm;
import com.dive2sky.user.PasswordMismatchException;
import com.dive2sky.user.UserManager;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @struts.action
 *      path="/login"
 *      scope="request"
 *		input="/struts/login.jsp"
 *      name="userForm"
 *
 * @struts.action-forward
 *      name="user_list"
 *      path="/user_list.do"
 * 		redirect="true"
 *
 */
public class LoginAction extends Action {

  public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
  ) {
    UserForm userForm = (UserForm) form;

    UserManager manager = UserManager.instance();
    try {
      manager.login(userForm.getUserId(), userForm.getPassword());
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (PasswordMismatchException e) {
      e.printStackTrace();
    }

    HttpSession session = request.getSession();
    session.setAttribute("userId", userForm.getUserId());

    return mapping.findForward("user_list");

  }

}
