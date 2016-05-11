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
@WebServlet(name = "FindVisitServlet", urlPatterns = {"/antenatal/find"})
public class FindVisitServlet extends HttpServlet {
  private final DaoFactory db;

  public FindVisitServlet() {
    db = DaoFactory.getDatabase();
  }
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("antenatalTabStyle", "active");
    request.setAttribute("findVisit", "active");
    request.getRequestDispatcher("/WEB-INF/views/antenatalcare.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    doGet(httpServletRequest, httpServletResponse);
    String searchKey = request.getParameter("search");
    PregnancyVisit visit = db.getAntenatalVisitDao().find(searchKey);

    request.setAttribute("antenatalTabStyle", "active");
    request.setAttribute("viewVisit", "active");
    request.setAttribute("visitData", visit);

    request.getRequestDispatcher("/WEB-INF/views/antenatalcare.jsp").forward(request, response);
  }

}
