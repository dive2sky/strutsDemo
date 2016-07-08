package com.dive2sky.struts.action;

import com.dive2sky.struts.form.UserForm;
import com.dive2sky.user.User;
import com.dive2sky.user.UserManager;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @struts.action
 *      path="/user_modify"
 * 		input="/struts/user_modify.jsp"
 *      name="userForm"
 *      scope="request"
 *
 * @struts.action-forward
 *      name="user_list"
 *      path="/user_list.do"
 * 		redirect="true"
 */

public class UpdateAction extends Action {

  public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
  ) throws Exception {

    UserForm userForm = (UserForm) form;

    User user = new User();
    PropertyUtils.copyProperties(user, userForm);

    UserManager manager = UserManager.instance();
    manager.update(user);

    return mapping.findForward("user_list");
  }
}
