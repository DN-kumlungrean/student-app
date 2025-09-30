<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Error</title></head>
<body>

  <div style="float:right; width:260px; text-align:left;">
    <h2 style="margin:0 0 8px 0;">Student List</h2>
    <%@ include file="all.jsp" %>
    <p style="margin-top:6px;"><a href="form.jsp">Back to Add Student</a></p>
  </div>

  <h2 style="color:red; margin-top:0;">There is an existing student with this ID</h2>

  <div style="clear:both;"></div>
</body>
</html>
