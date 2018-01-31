/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rgukt
 */
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        String code=request.getParameter("code");
      
        String cpassword=request.getParameter("cpassword");
        if(password.equals(cpassword)&& code.equals("0000"))
        {
        
            
            
         String str=encryptText(userName+"::"+password);
        try {
                FileWriter fw=new FileWriter("input",true);
                BufferedWriter bw=new BufferedWriter(fw);
                bw.write(str+"\n");
                bw.close();
                fw.close();
                try{
                File d=new File("userdata/");
                if(!d.exists())
                    d.mkdir();
                File fr=new File("userdata/"+userName);
                fr.createNewFile();          
            }
            catch(Exception Ex) {         
            }
                
            }
            catch(Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(null,"File Processing Error","ERROR 404", javax.swing.JOptionPane.ERROR_MESSAGE);

            }   
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             
            out.println("<script type=\"text/javascript\">");
   out.println("alert('Registration Successfull!!');");
   out.println("location='index.html';");
   out.println("</script>");
        }
        }
        else
        {
            if(!password.equals(cpassword))
            {
                 response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             
            out.println("<script type=\"text/javascript\">");
   out.println("alert('Confirm password not matched');");
   out.println("location='Registration.html';");
   out.println("</script>");
        }
            }
            else
            {
                 response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             
            out.println("<script type=\"text/javascript\">");
   out.println("alert('Invalid Access Code');");
   out.println("location='Registration.html';");
   out.println("</script>");
        }
            
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
     public static String encryptText(String str)
	{
		int key=90+(int)(Math.random()*2147483147);
		String encrypedText=key+"+";
		for(int i=0;i<str.length();i++)
		{
			encrypedText=encrypedText+(str.charAt(i)+key)+"+";
		}
		encrypedText=encrypedText+key;
		return(encrypedText);
	} 
    
    
}