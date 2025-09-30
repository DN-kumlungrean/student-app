package com.example.studentapp.web;

import com.example.studentapp.dao.StudentTable;
import com.example.studentapp.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "StudentServlet", urlPatterns = {"/student"})
public class StudentServlet extends HttpServlet {

    private final StudentTable studentTable = new StudentTable();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String id = trim(req.getParameter("studentId"));
        String name = trim(req.getParameter("studentName"));
        String gpaStr = trim(req.getParameter("gpa"));

        if (id.isEmpty() || name.isEmpty() || gpaStr.isEmpty()) {
            req.setAttribute("error", "กรุณากรอกข้อมูลให้ครบถ้วน");
            req.setAttribute("students", studentTable.listAll());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
            return;
        }

        double gpa;
        try { gpa = Double.parseDouble(gpaStr); }
        catch (NumberFormatException e) {
            req.setAttribute("error", "รูปแบบ GPA ไม่ถูกต้อง");
            req.setAttribute("students", studentTable.listAll());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
            return;
        }

        Student s = new Student(id, name, gpa);

        boolean ok = studentTable.insertIfNotExists(s);
        req.setAttribute("students", studentTable.listAll());

        if (!ok) {
            req.setAttribute("students", studentTable.listAll());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        } else {
            req.setAttribute("students", studentTable.listAll());
            req.setAttribute("added", s);
            req.getRequestDispatcher("/result.jsp").forward(req, resp);
        }
    }

    private static String trim(String s) { return s == null ? "" : s.trim(); }
}
