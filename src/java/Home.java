/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rgukt
 */
public class Home extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(new File("stack").exists())
       {
       
       }
       else
       {
            response.sendRedirect("index.html");
       }
        response.setContentType("text/html;charset=UTF-8");
        try (
                PrintWriter out = response.getWriter()) {
           /*  TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Home</title>");
            out.println("<link href=\"css/stylee.css\" rel='stylesheet' type='text/css' />");
            out.println("</head>");
            out.println("<body>");           
            out.print("<div id=\"container\">");
            out.print("<div id=\"container\">");
            out.print("	<div id=\"header\">");
            out.print("    	<h1><a href=\"#\"> .......SLAM BOOK.........</a></h1>");
            out.print("       ");
            out.print("        <div class=\"clear\"></div>");
            out.print("    </div>");
            //out.print("<img class =\"image\" src=\"css/Data3.png\" height=\"80px\" width=\"70px\" >");
            out.printf("<div id=\"menu\">");
            out.print("    <div id=\"nav\">");
out.print("    	<ul>");
out.print("        	<li class=\"selected\"><a href=\"Home\">Home</a></li>");
out.print("            <li class=\"selected1\"><a href=\"add.html\">Add Friend</a></li>");
out.print("            <li class=\"selected2\"><a href=\"del\">Remove Friend</a></li>");
out.print("            <li class=\"selected3\"><a href=\"Logout\">Logout</a></li>");
out.print("            <li id=\"search-li\"><form method=\"POST\" class=\"searchform\" action=\"Search\">");
out.print("                                <p>");
out.print("                                    <input class=\"field\" size=\"20\" placeHolder=\"Enter name to search\"  name=\"key\" class=\"s\" type=\"text\">");
out.print("                                    <input class=\"searchsubmit formbutton\" value=\"Search\" type=\"submit\">");
out.print("                                </p>");
out.print("                            </form>	</li>");
out.print("        </ul>");
                out.print("</div>");
out.print("    </div>");
out.print("    </div>");
out.print("    <div id=\"body\">");
out.print("		<div id=\"content\">		 ");
out.print("                    <table cellspacing=\"0\" >");
out.print("                <tbody><tr>");
out.print("                    <th>Name</th>");
out.print("                    <th>Gender</th>");
out.print("                    <th>Phone</th>");
out.print("                    <th>Details</th>");
out.print("                     <th>Hobbies</th>");
out.print("                </tr>");
LinkedList obj=new LinkedList();
LinkedList objs=new LinkedList();
objs.readFile();
objs.sort();
objs.intoFile();
int count=1;
FileReader fr=new FileReader("userdata/data");
            BufferedReader br=new BufferedReader(fr);
            String str;          
            int i=0;          
        FIO fobj=new FIO();
     	String name,gender,phone,mail,address,s;
	while((s=br.readLine())!=null)
	{
		StringTokenizer st=new StringTokenizer(s,"::");
                name=fobj.decrypt(st.nextToken(),10);
                gender=fobj.decrypt(st.nextToken(),10);
                phone=fobj.decrypt(st.nextToken(),10);
                mail=fobj.decrypt(st.nextToken(),10);
                address=fobj.decrypt(st.nextToken(),10);
                
                out.print("                <tr class=\"rows\" >                    ");
out.print("                    <td class =\"row\"><pre>"+name +"</td>");
out.print("                    <td class =\"row\"><pre>"+gender +"</td>");
out.print("                    <td class =\"row\"><pre>"+phone +"</td>");
out.print("                    <td class =\"row\"><pre>"+mail +"</td>");
out.print("                    <td class =\"row\"> <pre>"+address.replace(";;;","\n") +"</td>");
out.print("                </tr>");


        }              
/*
  <tr> 
           <td>
               <form name="f2" action="javascript:select();" >
                <input id="edit" type="submit" name="edit" value="Edit" />
               </form>
           </td>
      </tr>       
        
        */            
            
            
            
            
            
              
out.print("            </tbody></table>");   
out.print("                       </div>");  
out.print("         		<div class=\"sidebar\">");
out.print("            <ul>                ");
out.print("            </ul> ");
out.print("        </div>");
out.print("    	<div class=\"clear\"></div>");
out.print("    </div>");
out.print("    <div id=\"footer\">");
out.print("        <div class=\"footer-content\">");
out.print("            <div class=\"footer-box\">                ");
out.print("        <div id=\"footer-links\">");
out.print("        </div>  ");
out.print("</div>");
out.print("    </div>");


            
            
          
            out.println("</body>");
            out.println("</html>"); 
            
         

        }
        
        
        
    }
    /*    
    
    
    
    
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
/*
   /*
FIO fobj=new FIO();
		Person current=first;
		 while(current!=null)
		{
                        out.println("<h2>"+current+"</h2>");
			String arr[]=((current.toString()).split("::"));
                        name=arr[0];
                        gender=arr[1];
                        phone=arr[2];
                        mail=arr[4];
                        address=arr[5].replace(";;;", "\n");
			current=current.next;
out.print("                <tr>                    ");
out.print("                    <td>"+name +"</td>");
out.print("                    <td>"+gender +"</td>");
out.print("                    <td>"+phone +"</td>");
out.print("                    <td>"+mail +"</td>");
out.print("                    <td>"+address +"</td>");
out.print("                </tr>");
out.print("                <tr>                    ");
		}  
    
    
    
    
    */
}