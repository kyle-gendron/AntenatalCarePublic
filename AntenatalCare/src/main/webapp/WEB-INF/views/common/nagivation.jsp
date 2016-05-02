<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
              aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">COS420</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li><a href="<c:url value="/"/>">Consulting Register</a></li>
        <li><a href="<c:url value="/familyplanning"/>">Family Planning</a></li>
        <li><a href="<c:url value="/antenatal"/>">Antenatal Care</a></li>
        <li><a href="<c:url value="/births"/>">Births & Deliveries</a></li>
        <li><a href="<c:url value="/immunizations"/>">Immunizations</a></li>
        <li><a href="<c:url value="/disease"/>">Disease Surveillance</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
          <a href="#">
            <span class="glyphicon glyphicon-user"></span> NURSE123
          </a>
        </li>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>

