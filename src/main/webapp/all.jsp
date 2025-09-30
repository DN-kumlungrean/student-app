<%@ page import="java.util.*,com.example.studentapp.model.Student" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
  List<Student> students = (List<Student>) request.getAttribute("students");
%>

<style>
  table.stdlist { border-collapse: collapse; font-size:14px; }
  .stdlist th, .stdlist td { border:1px solid #000; padding:3px 6px; }
</style>

<%
  if (students == null || students.isEmpty()) {
%>
  <p>(No student data available)</p>
<%
  } else {
%>
  <table class="stdlist">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>GPA</th>
      </tr>
    </thead>
    <tbody>
    <%
      for (Student s : students) {
    %>
      <tr>
        <td><%= s.getStudentId() %></td>
        <td><%= s.getStudentName() %></td>
        <td><%= s.getGpa() %></td>
      </tr>
    <%
      }
    %>
    </tbody>
  </table>
<%
  }
%>
