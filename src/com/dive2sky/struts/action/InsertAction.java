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

public class InsertAction extends Action {

  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletRequest response) throws Exception {
    UserForm userForm = (UserForm) form;

    User user = new User();

    PropertyUtils.copyProperties(user, userForm);

    UserManager manager = UserManager.instance();
    manager.create(user);

    return mapping.findForward("user_list");
  }
}
