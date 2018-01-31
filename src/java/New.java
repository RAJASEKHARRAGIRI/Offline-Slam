/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rgukt
 */
public class New extends HttpServlet {

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
         if(new File("stack").exists())
       {
       
       }
       else
       {
            response.sendRedirect("index.html");
       }
        
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String gender=request.getParameter("gender");
        String phone=request.getParameter("phone");
        String mail=request.getParameter("mail");
        String address=request.getParameter("address")+"#";
        String tempAddress="";
        String[] array=address.split("\n");
        for(int i=0;i<array.length;i++)
        {
            tempAddress=tempAddress+array[i].substring(0, array[i].length()-1)+";;;";
        }
        String data=fname+" "+lname+"::"+gender+"::"+phone+"::"+mail+"::"+tempAddress;          
        String encryptedData=encrypt(data,10);
        intoFile("userdata/data",encryptedData);         
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())          
        {
            FileReader fr=new FileReader("stack");
            BufferedReader br=new BufferedReader(fr);
            String strr=br.readLine();
            intoFile("userdata/"+strr,encryptedData);  
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Contact Added Successfully');");
            out.println("location='Home';");
            out.println("</script>");
            
            
            
            //response.sendRedirect("TryAgain.html");
        }
    }
    
    public void intoFile(String str,String data) throws IOException
    {
          FileWriter fw=new FileWriter(str+"",true);
          BufferedWriter bw=new BufferedWriter(fw);
          bw.write(data+"\n");
          bw.close();
          fw.close();
        
    }
    
    public String encrypt(String str,int key)
    {
		int ch;
		key=key%26;
		String text="";
		for(int i=0;i<str.length();i++)
		{
			ch=str.charAt(i);
			if(str.charAt(i)>='a'&&str.charAt(i)<='z')
			{
				ch=ch+key;
				if(ch>'z')
					ch='a'+(ch-'z')-1;	
			}
			else if(str.charAt(i)>='A'&&str.charAt(i)<='Z')
			{
				ch=ch+key;
				if(ch>'Z')
					ch='A'+(ch-'Z')-1;	
			}
			text=text+(char)ch;
		}
		return text;
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