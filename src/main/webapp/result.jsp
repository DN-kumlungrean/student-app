<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Result</title></head>
<body>

  <div style="float:right; width:260px; text-align:left;">
    <h2 style="margin:0 0 8px 0;">Student List</h2>
    <%@ include file="all.jsp" %>
    <p style="margin-top:6px;"><a href="form.jsp">Back to Add Student</a></p>
  </div>

  <h2 style="margin-top:0;">Result</h2>
  <%
    com.example.studentapp.model.Student added =
      (com.example.studentapp.model.Student) request.getAttribute("added");
    if (added != null) {
  %>
    <div style="line-height:1.6;">
      Id: <%= added.getStudentId() %><br>
      Name: <%= added.getStudentName() %><br>
      Gpa: <%= added.getGpa() %><br>
      is added
    </div>
  <% } %>

  <div style="clear:both;"></div>
</body>
</html>
