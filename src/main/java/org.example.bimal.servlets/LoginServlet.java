package org.example.bimal.servlets;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost/login_db?useSSL=false";
    private static final String DB_USER = "root1";
    private static final String DB_PASSWORD = "rootpass";

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email").trim();
        String pwd = req.getParameter("pass").trim();

        HttpSession session = req.getSession();
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Attempting login with email: '" + email + "' and password: '" + pwd + "'");
            String sql = "SELECT name, email FROM registerData WHERE email = ? AND pass = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, pwd);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                session.setAttribute("name", rs.getString("name"));
                session.setAttribute("email", rs.getString("email"));
                res.sendRedirect("index.jsp");
            } else {
                req.setAttribute("status", "failed");
                req.getRequestDispatcher("login.jsp").forward(req, res);
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
