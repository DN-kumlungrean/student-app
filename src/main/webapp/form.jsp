<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Add Student</title></head>
<body>
  <h2>Add Student</h2>
  <form action="student" method="post" accept-charset="UTF-8">
    <label>ID: <input type="text" name="studentId" required></label><br>
    <label>Name: <input type="text" name="studentName" required></label><br>
    <label>GPA: <input type="text" name="gpa" required></label><br>
    <button type="submit">Submit</button>
  </form>
</body>
</html>
