package vote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/verifybyotp")
public class VerifyByOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int otp;
       
   
    public VerifyByOtp() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        PrintWriter pw=response.getWriter();
        otp = 100000 + random.nextInt(900000);
        ServletContext sc=getServletContext();
        UserDetails ud=(UserDetails) sc.getAttribute("userdetails");
        String votename=request.getParameter("vt");
        sc.setAttribute("vote", votename);
        String numbers = ud.getMobile();
        Connection con=(Connection) sc.getAttribute("oracle");
        try {
            String url ="https://www.fast2sms.com/dev/bulkV2?authorization=TXyspVMlC7EutdkD05mhRQZfSU21avrjPocnJWN8exKBLOIiAqtdo4NQJfgrmYeHnIh2GZLwvK5p0O6M&route=otp&variables_values="+otp+"&flash=0&numbers="+numbers;
            
           
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            
           
            connection.setRequestMethod("GET");
            
           
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response1 = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response1.append(inputLine);
            }
            in.close();
            
         
            System.out.println("Response: " + response1.toString());
            sc.setAttribute("otp", otp);
            response.sendRedirect("verify.html");
      
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	}
