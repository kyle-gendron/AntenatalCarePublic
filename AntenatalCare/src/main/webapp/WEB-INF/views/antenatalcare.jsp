


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
                    <div>
                      <tr>
                        <td><c:out value="${currentItem.id}"/></td>
                        <td><c:out value="${currentItem.personId}"/></td>
                        <td><c:out value="${currentItem.createdDate}"/></td>
                        <td><c:out value="${currentItem.updatedDate}"/></td>
                      </tr>
                    </div>
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
                <form method="post" action="CreateVisitServlet" class="form-inline">
                  <div class="form-group"><span class="label label-default" style="font-size: medium">Parity</span>&nbsp;<input type="number" class="form-control" name="quantity" min="0" max="20" style="width: 60px;"></div> &nbsp;&nbsp;
                  <div class="form-group"><span class="label label-default" style="font-size: medium">Systolic BP</span>&nbsp;<input type="number" class="form-control" name="quantity" min="0" max="200" style="width: 70px;"></div> /
                  <div class="form-group"><span class="label label-default" style="font-size: medium">Diastolic BP</span>&nbsp;<input type="number" class="form-control" name="quantity" min="0" max="140" style="width: 70px;"></div>&nbsp;&nbsp;
                  <div class="form-group"><span class="label label-default" style="font-size: medium">Height</span>&nbsp;<input type="number" class="form-control" name="quantity" min="0" max="200" style="width: 70px;"><label>cm</label></div> &nbsp;&nbsp;
                  <div class="form-group"><span class="label label-default" style="font-size: medium">Weight</span>&nbsp;<input type="number" class="form-control" name="quantity" min="0" max="140" style="width: 70px;"><label>kg</label></div>&nbsp;&nbsp;
                  <div class="form-group"><span class="label label-default" style="font-size: medium">Gestation</span>&nbsp;<input type="number" class="form-control" name="quantity" min="0" max="200" style="width: 70px;"></div>&nbsp;&nbsp;
                  <div class="form-group"><span class="label label-default" style="font-size: medium">Fundal Height</span>&nbsp;<input type="number" class="form-control" name="quantity" min="0" max="140" style="width: 70px;"></div>&nbsp;&nbsp;
                  <div class="form-group"><span class="label label-default" style="font-size: medium">Due Date</span>&nbsp;<input type="date" class="form-control" name="date" style="width: 100px;"></div>&nbsp;&nbsp;
                  <div class="form-group"><span class="label label-default" style="font-size: medium">HBatReg (g/dL)</span>&nbsp;<input type="number" class="form-control" name="quantity" min="0" max="200" style="width: 70px;"></div> &nbsp;&nbsp;
                  <div class="form-group"><span class="label label-default" style="font-size: medium">HBat36 (g/dL)</span>&nbsp;<input type="number" class="form-control" name="quantity" min="0" max="140" style="width: 70px;"></div>&nbsp;&nbsp;
                  <div class="form-group"><span class="label label-default" style="font-size: medium">Urine Test (Sugar)</span>&nbsp;<input type="number" class="form-control" name="quantity" min="0" max="200" style="width: 70px;"></div> &nbsp;&nbsp;
                  <div class="form-group"><span class="label label-default" style="font-size: medium">Urine Test (Protein)</span>&nbsp;<input type="number" class="form-control" name="quantity" min="0" max="140" style="width: 70px;"></div>&nbsp;&nbsp;

                </form>
          </div>
        </div>
      </c:if>
      <%--@elvariable id="findVisit" type="java.lang.String"--%>
      <c:if test="${not empty findVisit}">
        <div class="panel">
          <div class="panel-body">findVisit</div>
        </div>
      </c:if>
      <%--@elvariable id="viewVisit" type="java.lang.String"--%>
      <c:if test="${not empty viewVisit}">
        viewVisit
      </c:if>
    </div>
  </div>
</div>

<%@ include file="common/footer.jsp" %>
