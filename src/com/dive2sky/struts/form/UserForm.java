package com.dive2sky.struts.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class UserForm extends ActionForm {

  private String password = null;
  private String userId = null;
  private String email = null;
  private String name = null;

  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    return null;
  }

  public void reset(ActionMapping mapping, HttpServletRequest request) {
    password = null;
    userId = null;
    email = null;
    name = null;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
