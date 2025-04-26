package org.example.bimal.servlets;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class ExpReportServlet extends HttpServlet {
    private  final String DB_URL = getServletContext().getInitParameter("dbUrl");
    private  final String DB_USER = getServletContext().getInitParameter("dbUser");
    private  final String DB_PASSWORD = getServletContext().getInitParameter("dbPassword");
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    HttpSession session = req.getSession();
    String name = (String) session.getAttribute("name");
    PrintWriter out = res.getWriter();
    res.setContentType("text/html");
    Connection conn = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement stmt = conn.prepareStatement("Select * from expData join registerData on expData.register_id =registerData.id where registerData.name=?");
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Expense Report</title>");
        out.println("<style>");
        out.println(".expense-entry { border: 1px solid #ddd; padding: 10px; margin-bottom: 10px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        boolean hasResults = false;
        while (rs.next()) {
            hasResults = true;
            String amount = rs.getString(3);
            String dateTime = rs.getString(1);
            String incomeSource = rs.getString(2);
            out.println("<div class='expense-entry'>");
            out.print("<h4>The amount used is </h4>" + amount);
            out.println("<br><br>");
            out.print("<h4>The Expenditure source is </h4>" + incomeSource);
            out.println("<br><br>");
            out.print("<h4>The data and time of Expense is </h4>" + dateTime);
            out.println("<br><br>");
            out.println("</div>");
        }
        out.println("</body>");
        out.println("</html>");
        
        if (!hasResults) {
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