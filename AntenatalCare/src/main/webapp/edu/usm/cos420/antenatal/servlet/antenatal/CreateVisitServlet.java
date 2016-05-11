package edu.usm.cos420.antenatal.servlet.antenatal;

import edu.usm.cos420.antenatal.daoFactory.DaoFactory;
import edu.usm.cos420.antenatal.domain.PregnancyVisit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import static edu.usm.cos420.antenatal.utils.Parsers.parseInteger;

/**
 * Created by aaron on 5/8/2016.
 */
@WebServlet(name = "CreateVisitServlet", urlPatterns = {"/antenatal/create"})
public class CreateVisitServlet extends HttpServlet {
  private final DaoFactory db;

  public CreateVisitServlet() {
    db = DaoFactory.getDatabase();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("antenatalTabStyle", "active");
    request.setAttribute("newVisit", "active");
    request.getRequestDispatcher("/WEB-INF/views/antenatalcare.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String parity = request.getParameter("parity");

    PregnancyVisit visit = new PregnancyVisit(UUID.randomUUID().toString());

    visit.setParity(parseInteger(parity));

    //db.getAntenatalVisitDao().add(visit.getId(), visit);

    request.setAttribute("antenatalTabStyle", "active");
    request.setAttribute("viewVisit", "active");
    request.setAttribute("visitData", visit);

    request.getRequestDispatcher("/WEB-INF/views/antenatalcare.jsp").forward(request, response);
  }

}
