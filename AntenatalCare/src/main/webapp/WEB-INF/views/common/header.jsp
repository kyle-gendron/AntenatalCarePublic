<!DOCTYPE html>
<html lang="en">
<head>

  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
  <%--<link rel="shortcut icon" href="/static/img/todolist.ico"/>--%>

  <title>Todolist MVC</title>

  <!-- Le styles -->
  <link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
  <%--<link href="<c:url value="/static/css/datepicker.css"/>" rel="stylesheet">--%>
  <style type="text/css">
    body {
      padding-top: 60px;
      /* 60px to make the container go all the way to the bottom of the topbar */
    }
  </style>

  <!-- Le javascript -->
  <script src="<c:url value="/static/js/jquery-2.2.3.min.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/static/js/bootstrap.min.js"/>" type="text/javascript"></script>
  <%--<script src="<c:url value="/static/js/bootstrap-datepicker.js"/>" type="text/javascript"></script>--%>

</head>

<body>
<%@ include file="nagivation.jsp" %>

<div class="container-fluid">
  <div class="row">
    <div class="col-md-10 well col-md-offset-1">
      <div class="row">
