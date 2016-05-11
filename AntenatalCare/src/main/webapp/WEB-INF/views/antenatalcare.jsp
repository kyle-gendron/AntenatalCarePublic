<%--@elvariable id="currentItem" type="edu.usm.cos420.antenatal.domain.PregnancyVisit"--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="common/header.jsp" %>

<div class="row">
  <div class="col-md-12">
    <div class="page-header">
      <h3>Antenatal Care</h3>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <ul class="nav nav-tabs">
        <li role="presentation" class="${allVisits}"><a href="<c:url value="/antenatal/all"/>">All Visits</a></li>
        <li role="presentation" class="${newVisit}"><a href="<c:url value="/antenatal/new"/>">New Visit</a></li>
        <li role="presentation" class="${findVisit}"><a href="<c:url value="/antenatal/find"/>">Find Visit</a></li>
      </ul>
      <%--@elvariable id="allVisits" type="java.lang.String"--%>
      <c:if test="${not empty allVisits}">
        <div class="panel">
          <div class="panel-body">
              <%--@elvariable id="visitList" type="java.util.ArrayList"--%>
            <table class="table table-striped table-condensed table-hover">
              <thead>
              <tr>
                <th>Visit ID</th>
                <th>Person</th>
                <th>Created</th>
                <th>Updated</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${visitList}" var="currentItem">
                <tr>
                  <td>
                    <a href="<c:url value="/antenatal/view/${currentItem.id}"/>">
                      <c:out value="${currentItem.id}"/>
                    </a>
                  </td>
                  <td><c:out value="${currentItem.personId}"/></td>
                  <td><c:out value="${currentItem.createdDate}"/></td>
                  <td><c:out value="${currentItem.updatedDate}"/></td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </c:if>
      <%--@elvariable id="newVisit" type="java.lang.String"--%>
      <c:if test="${not empty newVisit}">
        <div class="panel">
          <div class="panel-body">
            <form method="post" action="CreateVisitServlet" class="form-horizontal">
              <div class="col-md-6">
                <div class="row">
                  <div class="form-group">
                    <div class="col-xs-5">
                      <label>Parity</label>
                    </div>
                    <div class="col-xs-5">
                      <input type="number" class="form-control" name="quantity" min="0" max="20">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-xs-5">
                      <label>Systolic BP</label>
                    </div>
                    <div class="col-xs-5">
                      <input type="number" class="form-control" name="quantity" min="0" max="200"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-xs-5">
                      <label>Diastolic BP</label>
                    </div>
                    <div class="col-xs-5">
                      <input type="number" class="form-control" name="quantity" min="0" max="140">
                    </div>
                  </div>

                  <div class="form-group">
                    <div class="col-xs-5">
                      <label>Height (cm)</label>
                    </div>
                    <div class="col-xs-5">
                      <input type="number" class="form-control" name="quantity" min="0" max="200">
                    </div>
                  </div>

                  <div class="form-group">
                    <div class="col-xs-5">
                      <label>Weight (kg)</label>
                    </div>
                    <div class="col-xs-5">
                      <input type="number" class="form-control" name="quantity" min="0" max="140">
                    </div>
                  </div>

                  <div class="form-group">
                    <div class="col-xs-5">
                      <label>Gestation</label>
                    </div>
                    <div class="col-xs-5">
                      <input type="number" class="form-control" name="quantity" min="0" max="200">
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="row">
                  <div class="form-group">
                    <div class="col-xs-5">
                      <label>Fundal Height</label>
                    </div>
                    <div class="col-xs-5">
                      <input type="number" class="form-control" name="quantity" min="0" max="140">
                      </div>
                  </div>

                  <div class="form-group">
                    <div class="col-xs-5">
                      <label>Due Date</label>
                    </div>
                    <div class="col-xs-5">
                      <input type="date" class="form-control" name="date"></div>
                    </div>

                  <div class="form-group">
                    <div class="col-xs-5">
                      <label>HBatReg (g/dL)</label>
                    </div>
                    <div class="col-xs-5">
                      <input type="number" class="form-control" name="quantity" min="0" max="200">
                      </div>
                  </div>

                  <div class="form-group">
                    <div class="col-xs-5">
                      <label>HBat36 (g/dL)</label>
                    </div>
                    <div class="col-xs-5">
                      <input type="number" class="form-control" name="quantity" min="0" max="140">
                      </div>
                  </div>

                  <div class="form-group">
                    <div class="col-xs-5">
                      <label>Urine Test (Sugar)</label>
                    </div>
                    <div class="col-xs-5">
                      <input type="number" class="form-control" name="quantity" min="0" max="200">
                      </div>
                  </div>

                  <div class="form-group">
                    <div class="col-xs-5">
                      <label>Urine Test (Protein)</label>
                    </div>
                    <div class="col-xs-5">
                      <input type="number" class="form-control" name="quantity" min="0" max="140">
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <button class="btn btn-default" type="reset">Cancel</button>
                <button class="btn btn-primary" type="submit">Save</button>
              </div>
            </form>
          </div>
        </div>
      </c:if>
      <%--@elvariable id="findVisit" type="java.lang.String"--%>
      <c:if test="${not empty findVisit}">
        <div class="panel">
          <div class="panel-body">
            <form method="post" action="<c:url value="/antenatal/find"/>" class="form">
              <div class="form-group">
                <div class="col-sm-5">
                  <input class="form-control" type="text" name="search" placeholder="Visit ID">
                </div>
                <button type="submit" class="btn btn-default">Search</button>
              </div>
            </form>
          </div>
        </div>
      </c:if>
      <%--@elvariable id="viewVisit" type="java.lang.String"--%>
      <c:if test="${not empty viewVisit}">
        <%--@elvariable id="visitData" type="edu.usm.cos420.antenatal.domain.PregnancyVisit"--%>
        ${visitData.toString()}
      </c:if>
    </div>
  </div>
</div>

<%@ include file="common/footer.jsp" %>
