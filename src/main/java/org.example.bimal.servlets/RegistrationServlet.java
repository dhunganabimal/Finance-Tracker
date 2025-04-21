package org.example.bimal.servlets;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
        PrintWriter pw = res.getWriter();
        String uname = req.getParameter("name");
        String uemail = req.getParameter("email");
        String upwd = req.getParameter("pass");
        String umobile = req.getParameter("contact");
        RequestDispatcher dispatcher=null;
        Connection conn;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            String url = "jdbc:mysql://localhost/login_db?useSSL=false";
            String user ="root1";
            String pass="rootpass";
            conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement stmt=conn.prepareStatement("Insert into registerData (name,email,pass,contact) Values(?,?,?,?)");
            stmt.setString(1,uname);
            stmt.setString(2,uemail);
            stmt.setString(3,upwd);
            stmt.setString(4,umobile);
            int rowCount=stmt.executeUpdate();
            dispatcher=req.getRequestDispatcher("signup.jsp");
            if(rowCount>0){
                req.setAttribute("status","success");

            }
            else{
                req.setAttribute("status","failed");
            }
            dispatcher.forward(req,res);

            conn.close();
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
