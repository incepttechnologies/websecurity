/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incept.security;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bhalepr
 */
@Named
@RequestScoped
public class LogoutHandler {

  FacesContext context = FacesContext.getCurrentInstance();
  @Inject
  HttpServletRequest request;
  @Inject
  HttpSession session;

  /**
   * Creates a new instance of RoleCheck
   */
  public LogoutHandler() {
  }


  /**
   * invalidates current session and redirects to login page
   */
  public void signOut() {
    try {
      request.logout();
      session.invalidate();
      System.out.println("Signout invoked");
      FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation
              (FacesContext.getCurrentInstance(), null, "/faces/login.xhtml?faces-redirect=true");
    } catch (Exception ex) {
      ex.printStackTrace();
      System.out.println("Error Signout -" +  ex.getMessage());
    }
  }
}
