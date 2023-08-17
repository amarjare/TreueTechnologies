package vote;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ballot")
public class VotingBallot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public VotingBallot() {
        super();
       
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		pw.println("<html><head><link rel=stylesheet href=ballot.css></head><body><div><table>");
		pw.println("<form >");
		pw.println("<tr><th>SR NO</th><th>NAME</th><th>PHOTO</th><th>ACTION</th></tr>");
		pw.println("<tr><td>1</td><td>ABHISHEK MALLHAN</td><td><img src=\"images/abhishekmalhan.jpg\" alt=\"Image 1\"></td><td><input type=checkbox name='vt' value='abhishek'/></td></tr>");
		pw.println("<tr><td>2</td><td>MANISHA RANI</td><td> <img src=\"images/manisha rani.jpg\" alt=\"Image 2\"></td><td><input type=checkbox name='vt'  value='manisha'/></td></tr>");
		pw.println("<tr><td>3</td><td>ELVISH YADAV</td><td> <img src=\"images/Elvishyadav.jpg\" alt=\"Image 3\"></td><td><input type=checkbox name='vt'  value='elvish'/></td></tr>");
		pw.println("<tr><td>4</td><td>BEBIKA DHRUVE</td><td><img src=\"images/bebika Druve.png\" alt=\"Image 4\"></td><td><input type=checkbox name='vt' value='bebika'/></td></tr>");
		pw.println("<tr><td>5</td><td>POOJA BHATTA</td><td><img src=\"images/poojabhatt.jpg\" alt=\"Image 5\"></td><td><input type=checkbox name='vt'  value='pooja'/></td></tr>");
		pw.println("</form></table></div></body></html>");
		
	}

}
