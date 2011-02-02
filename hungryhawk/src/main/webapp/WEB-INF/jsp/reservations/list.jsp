<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/></p>
    <h3>Reservations</h3>
    <table>
      <tr>
        <th>Restaurant</th>
        <th>Date</th>
        <th>Name</th>
        <th>Guests</th>
      </tr>
      <c:forEach items="${reservations}" var="reservation">
        <tr>
          <td><c:out value="${reservation.event.name}"/></td>
          <td><i><fmt:formatDate value="${reservation.event.date}" type="date" pattern="EEEEE, MMMMM dd, yyyy"/></i></td>
          <td><c:out value="${reservation.name}"/></td>
          <td><c:out value="${reservation.guests}"/></td>
        </tr>
      </c:forEach>
    </table>
    <br>
    <a href="<c:url value="reservations/add"/>">Make Reservation</a>
  </body>
</html>