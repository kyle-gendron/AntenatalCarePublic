package edu.usm.cos420.antenatal.servlet.antenatal;

import edu.usm.cos420.antenatal.controller.AntenatalController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aaron on 5/8/2016.
 */
@WebServlet(name = "AllVisitsServlet", urlPatterns = {"/antenatal/all"})
public class AllVisitsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("antenatalTabStyle", "active");
    request.setAttribute("allVisits", "active");

    // Get all the visits in the db.

    request.setAttribute("visitList", "active");
    List visitList =
    request.getRequestDispatcher("/WEB-INF/views/antenatalcare.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
    doGet(httpServletRequest, httpServletResponse);
  }

}
