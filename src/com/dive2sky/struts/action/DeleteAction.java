package com.dive2sky.struts.action;

import com.dive2sky.struts.form.UserForm;
import com.dive2sky.user.UserManager;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @struts.action
 *      path="/user_remove"
 * 		name="userForm"
 *      scope="request"
 *
 * @struts.action-forward
 *      name="user_list"
 *      path="/user_list.do"
 * 		redirect="true"
 */
public class DeleteAction extends Action {

  public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
  ) {
    UserForm userForm = (UserForm) form;
    String userId = userForm.getUserId();

    UserManager userManager = UserManager.instance();
    try {
      userManager.remove(userId);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return mapping.findForward("user_list");

  }
}
