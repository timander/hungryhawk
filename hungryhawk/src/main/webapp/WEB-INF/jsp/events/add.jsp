<%@ include file="/WEB-INF/jsp/include.jsp" %>

<h1>Add/Edit Event</h1>

<c:url var="url" value="save"/>
<form:form action="${url}" commandName="eventForm">
    <fieldset>
        <div>
          <label for="name">Name</label>
          <form:input path="name"/>
        </div>
        <div>
          <label for="date">Date</label>
          <form:input path="date"/>
        </div>
        <div>
          <input name="submit" type="submit" value="save"/>
        </div>
    </fieldset>
</form:form>