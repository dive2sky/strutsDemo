package com.dive2sky.struts.action;

import com.dive2sky.user.UserManager;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @struts.action
 * path="/user_list"
 * scope="request"
 *
 * @struts.action-forward
 * name="user_list"
 * path="/struts/user_list.jsp"
 */

public class ListAction extends Action {

  /**
   * UserManager 의 list 메서드를 호출하여
   * List 를 reponse 에 저장한다
   * user_list.jsp 에서 response 에 저장된 List 객체를 이용한다.
   */

  public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response) {

    UserManager manager = UserManager.instance();
    List userList = null;
    try {
      userList = manager.findUserList(1,10);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    request.setAttribute("userList", userList);

    return mapping.findForward("user_list");
  }
}
