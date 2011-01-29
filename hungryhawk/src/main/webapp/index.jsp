<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%-- Redirected because we can't set the welcome page to a virtual URL. --%>
<!-- c:redirect url="/hello.htm"/ -->

<p>
  <a href="<c:url value="events.do"/>">Events</a><br>
  <a href="<c:url value="reservations.do"/>">Reservations</a>
</p>