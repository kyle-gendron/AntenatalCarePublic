<%--
  Created by IntelliJ IDEA.
  User: aaron
  Date: 4/29/2016
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn"
           uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="common/header.jsp" %>



        <div class="col-md-5">
          <h3>Welcome.</h3>
          <button class="btn btn-default" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Choose a patient
          </button>
            <ul class="dropdown-menu">

            </ul>
        </div>



<%@ include file="common/footer.jsp" %>
