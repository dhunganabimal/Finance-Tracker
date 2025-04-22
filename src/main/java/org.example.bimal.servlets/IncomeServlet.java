package org.example.bimal.servlets;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class IncomeServlet extends HttpServlet{
    private static final String DB_URL = "jdbc:mysql://localhost/login_db?useSSL=false";
    private static final String DB_USER = "root1";
    private static final String DB_PASSWORD = "rootpass";
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String date = req.getParameter("idate");
        String time = req.getParameter("itime");
        String dateTime = date + " " + time;
        String id=req.getParameter("iid");
       String incomeSource=req.getParameter("isource");
       String amount=req.getParameter("iamount");
//        PrintWriter out=res.getWriter();
//        out.println(date);
//        out.print(time);
//        out.println(dateTime);
//        out.println(incomeSource);
//        out.println(amount);
        RequestDispatcher dispatcher=null;
        Connection conn;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            String url = "jdbc:mysql://localhost/login_db?useSSL=false";
            String user ="root1";
            String pass="rootpass";
            conn = DriverManager.getConnection(url,user,pass);
           String query="Insert into incomeData (idate,isource,iamount,register_id) values(?,?,?,?)";
            PreparedStatement stmt=conn.prepareStatement(query);
            stmt.setString(1,dateTime);
            stmt.setString(2,incomeSource);
            stmt.setString(3,amount);
            stmt.setString(4,id);
            int rowCount=stmt.executeUpdate();
            dispatcher=req.getRequestDispatcher("income.jsp");
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

