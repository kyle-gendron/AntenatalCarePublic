package edu.usm.cos420.antenatal.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aaron on 5/2/2016.
 */

@WebServlet(name = "FamilyPlanning", urlPatterns = {"/familyplanning"})
public class FamilyPlanning extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("indexTabStyle", "active");
    request.getRequestDispatcher("/WEB-INF/views/familyplanning.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
    doGet(httpServletRequest, httpServletResponse);
  }

}
