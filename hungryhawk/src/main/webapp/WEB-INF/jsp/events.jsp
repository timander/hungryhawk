<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/></p>
    <h3>Events</h3>
    <c:forEach items="${events}" var="event">
      <c:out value="${event.name}"/> <i><c:out value="${event.date}"/></i><br><br>
    </c:forEach>
    <br>
    <a href="<c:url value="addEvent.do"/>">Add Event</a>
    <br>
  </body>
</html>