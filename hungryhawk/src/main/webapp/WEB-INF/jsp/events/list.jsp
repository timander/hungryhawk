<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/></p>
    <h3>Restaurant Schedule</h3>
    <table>
      <tr>
        <th>Name</th>
        <th>Date</th>
      </tr>
      <c:forEach items="${events}" var="event">
        <tr>
          <td><c:out value="${event.name}"/></td>
          <td><i><fmt:formatDate value="${event.date}" type="date" pattern="EEEEE, MMMMM dd, yyyy"/></i></td>
        </tr>
      </c:forEach>
    </table>
    <br>
    <a href="<c:url value="events/add"/>">Add Event</a>
    <br>
  </body>
</html>