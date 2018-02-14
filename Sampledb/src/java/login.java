/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ragiri Rajasekhar
 */
public class login extends HttpServlet {
    
   Connection con=null;
   String idn=null;
   String pass=null;
   
    public void init()
    {
        try{
        Mydb db = new Mydb();
        con = (Connection) db.getCon();
        }
        catch(Exception e)
        {
            System.out.println("Error while loading");
        }
    }
    
   @Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
    {
        try(PrintWriter out = response.getWriter()){
           idn= request.getParameter("id");
           pass= request.getParameter("pswd");
           
            String q = "select * from registrations where id='"+idn+"'";
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery(q);
            String idno=null;
            String password=null;
            while(rs.next())
            {
                idno= rs.getString(3); //ID in database
                password= rs.getString(4);  // password in database
            }
            if(idno.equals(idn) && password.equals(pass))
            {
                response.sendRedirect("home.html");
            }
            else
            {
                out.println("Login failure !"); 
            }
        }
        catch(Exception e)
        {
        }
    }
}
