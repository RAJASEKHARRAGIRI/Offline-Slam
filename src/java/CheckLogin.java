/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
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
public class CheckLogin extends HttpServlet {
  
    //public static String userName;
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
            boolean status=checkCreditals(userName+"::"+password);  
            if(status==false) {
        response.setContentType("text/html;charset=UTF-8");
        try (
                PrintWriter out = response.getWriter())          
        {
            
            out.println("<script type=\"text/javascript\">");
   out.println("alert('Invalid Login');");
   out.println("location='index.html';");
   out.println("</script>");
            
            
            
            //response.sendRedirect("TryAgain.html");
        } }
            else
            {
                File temp=new File("stack");
                if(temp.exists())
                {
                    temp.delete();
                    temp.createNewFile();
                }
                else
                {
                    temp.createNewFile();
                }
                FileWriter frr=new FileWriter("stack");
                BufferedWriter brr=new BufferedWriter(frr);
                brr.write(userName);
              /*   File fp=new File("userdata/"+userName);
                File fppre=new File("userdata/data");
                fppre.delete();
                fp.renameTo(fppre); */
                brr.close();
                frr.close(); 
                FileReader fr=new FileReader("userdata/"+userName);
               BufferedReader br=new BufferedReader(fr);
                FileWriter fw=new FileWriter("userdata/data");
               BufferedWriter bw=new BufferedWriter(fw);
            String dataa;
            while((dataa=br.readLine())!=null)
            {
                bw.write(dataa+"\n");
            }
            bw.close();
            fw.close();
                
                
                
                
                
                
                
                
                response.sendRedirect("Home");
                
            }
    }
    private boolean checkCreditals(String userInput) {
        try {   
                FileReader fr=new FileReader("input");
                BufferedReader br = new BufferedReader(fr);
                String str;
                String encrypedText="";
                String getKey="";
                int key;
                while((str=br.readLine())!=null) {
                    getKey="";
                    encrypedText="";
                    for(int i=0;str.charAt(i)!='+';i++) {
			getKey=getKey+str.charAt(i);
                    }
                    key=Integer.parseInt(getKey);
                    encrypedText=key+"+";
                    for(int i=0;i<userInput.length();i++) {
			encrypedText=encrypedText+(userInput.charAt(i)+key)+"+";
                    }
                    encrypedText=encrypedText+key;
                    if(str.equals(encrypedText))
			return true;
                }   
        }
        catch(Exception ex) {
               javax.swing.JOptionPane.showMessageDialog(null,"Passwords file not found","ERROR 404", javax.swing.JOptionPane.ERROR_MESSAGE);
               System.exit(0);
        }
        return false;
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

}