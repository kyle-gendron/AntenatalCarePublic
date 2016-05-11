package edu.usm.cos420.antenatal.servlet.antenatal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kyle on 5/11/2016.
 */
@WebServlet(name = "ReportingServlet", urlPatterns = {"/antenatal/reporting"})
public class ReportingServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("antenatalTabStyle", "active");
    request.setAttribute("reporting", "active");
    request.getRequestDispatcher("/WEB-INF/views/antenatalcare.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
    doGet(httpServletRequest, httpServletResponse);
  }
}
