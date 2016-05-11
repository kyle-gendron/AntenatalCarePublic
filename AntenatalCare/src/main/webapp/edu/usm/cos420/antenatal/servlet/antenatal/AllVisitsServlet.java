package edu.usm.cos420.antenatal.servlet.antenatal;

import edu.usm.cos420.antenatal.daoFactory.DaoFactory;
import edu.usm.cos420.antenatal.domain.PregnancyVisit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by aaron on 5/8/2016.
 */
@WebServlet(name = "AllVisitsServlet", urlPatterns = {"/antenatal/all"})
public class AllVisitsServlet extends HttpServlet {

  private final DaoFactory db;

  public AllVisitsServlet() {
    db = DaoFactory.getDatabase();
  }
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("antenatalTabStyle", "active");
    request.setAttribute("allVisits", "active");

    // Get all the visits in the db.
    List<PregnancyVisit> visits = db.getAntenatalVisitDao().list();
    request.setAttribute("visitList", visits);
    request.getRequestDispatcher("/WEB-INF/views/antenatalcare.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
    doGet(httpServletRequest, httpServletResponse);
  }

}
