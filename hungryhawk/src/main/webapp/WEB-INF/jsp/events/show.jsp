<%@ include file="/WEB-INF/jsp/include.jsp" %>

<h1>Show Event</h1>

<c:url var="url" value="/events/edit"/>
<form:form action="${url}" commandName="command">
    <fieldset>
        <div>
          <label for="name">Name</label>
          <c:out value="${event.name}"/>
        </div>
        <div>
          <label for="date">Date</label>
          <fmt:formatDate value="${event.date}" type="date" pattern="EEEEE, MMMMM dd, yyyy"/>
        </div>
        <div>
          <input name="submit" type="submit" value="edit"/>
        </div>
    </fieldset>
</form:form>