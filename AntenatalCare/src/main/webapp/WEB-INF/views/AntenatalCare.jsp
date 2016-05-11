


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
            <c:forEach items="${visitList}" var="currentItem">
              <div>
                <c:out value="${currentItem.id}"/>
              </div>
            </c:forEach>
          </div>
        </div>
      </c:if>
      <%--@elvariable id="newVisit" type="java.lang.String"--%>
      <c:if test="${not empty newVisit}">
        <div class="panel">
          <div class="panel-body">newVisit</div>
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
