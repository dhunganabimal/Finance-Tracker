package org.example.bimal.servlets;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class ExpReportServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost/login_db?useSSL=false";
    private static final String DB_USER = "root1";
    private static final String DB_PASSWORD = "rootpass";
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        HttpSession session=req.getSession();
        String name = (String) session.getAttribute("name");
        PrintWriter out=res.getWriter();
//        out.println(name);
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt=conn.prepareStatement("Select * from expData join registerData on expData.register_id =registerData.id where registerData.name=?");
            stmt.setString(1,name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String amount=rs.getString(2);
                String dateTime=rs.getString(1);
                String incomeSource= rs.getString(3);
                out.println(amount);
                out.println(dateTime);
                out.println(incomeSource);
            } else {
                req.setAttribute("status", "failed");
                req.getRequestDispatcher("report.jsp").forward(req, res);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("status", "failed");
            req.getRequestDispatcher("login.jsp").forward(req, res);
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

