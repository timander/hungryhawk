<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>Reservations</h3>
    <c:forEach items="${reservations}" var="reservation">
      <c:out value="${reservation.name}"/> <i>(<c:out value="${reservation.guests}"/> guests)</i><br><br>
    </c:forEach>
    <br>
    <a href="<c:url value="reservations.do"/>">Reservations</a>
    <br>
  </body>
</html>