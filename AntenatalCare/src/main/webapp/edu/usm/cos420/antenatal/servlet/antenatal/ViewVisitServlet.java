package edu.usm.cos420.antenatal.servlet.antenatal;

import edu.usm.cos420.antenatal.daoFactory.DaoFactory;
import edu.usm.cos420.antenatal.domain.PregnancyVisit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aaron on 5/8/2016.
 */
@WebServlet(name = "ViewVisitServlet", urlPatterns = {"/antenatal/view/*"})
public class ViewVisitServlet extends HttpServlet {

  private final DaoFactory db;

  public ViewVisitServlet() {
    db = DaoFactory.getDatabase();
  }
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String[] urls = request.getRequestURL().toString().split("/");
    String visitId = urls[urls.length-1];

    PregnancyVisit visit = db.getAntenatalVisitDao().find(visitId);

    request.setAttribute("antenatalTabStyle", "active");
    request.setAttribute("viewVisit", "active");
    request.setAttribute("visitData", visit);

    request.getRequestDispatcher("/WEB-INF/views/antenatalcare.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
    doGet(httpServletRequest, httpServletResponse);
  }

}
