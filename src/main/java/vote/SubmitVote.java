package vote;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/submitvote")
public class SubmitVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SubmitVote() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String otp1=request.getParameter("otp");
		ServletContext sc=getServletContext();
		Connection con=(Connection) sc.getAttribute("oracle");
		int otp=(int) sc.getAttribute("otp");
		String otp2 =String.valueOf(otp);
		UserDetails ud=(UserDetails) sc.getAttribute("usrdetails");
		String votename=(String) sc.getAttribute("vote");
		if (otp2.equals(otp1)) {
			if(votename.equals("abhishek")) {
				try {
					String query1="select contestantname,votes from votecount where contestantname='ABHISHEK MALLHAN'";
					PreparedStatement pstmt=con.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ResultSet rs=pstmt.executeQuery();
					if(rs.next()) {
						int vote=Integer.parseInt(rs.getString(2));
						int newvote =vote+1;
						rs.updateInt(2, newvote);
						rs.updateRow();
						response.sendRedirect("successful.html");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(votename.equals("manisha")) {
				try {
					String query1="select contestantname,votes from votecount where contestantname='MANISH RANI'";
					PreparedStatement pstmt=con.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ResultSet rs=pstmt.executeQuery();
					if(rs.next()) {
						int vote=Integer.parseInt(rs.getString(2));
						int newvote =vote+1;
						rs.updateInt(2, newvote);
						rs.updateRow();
						response.sendRedirect("successful.html");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(votename.equals("elvish")) {
				try {
					String query1="select contestantname,votes from votecount where contestantname='ELVISH YADAV'";
					PreparedStatement pstmt=con.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ResultSet rs=pstmt.executeQuery();
					if(rs.next()) {
						int vote=Integer.parseInt(rs.getString(2));
						int newvote =vote+1;
						rs.updateInt(2, newvote);
						rs.updateRow();
						response.sendRedirect("successful.html");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(votename.equals("bebika")) {
				try {
					String query1="select contestantname,votes from votecount where contestantname='BEBIKA DHRUVE'";
					PreparedStatement pstmt=con.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ResultSet rs=pstmt.executeQuery();
					if(rs.next()) {
						int vote=Integer.parseInt(rs.getString(2));
						int newvote =vote+1;
						rs.updateInt(2, newvote);
						rs.updateRow();
						response.sendRedirect("successful.html");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(votename.equals("pooja")) {
				try {
					String query1="select contestantname,votes from votecount where contestantname='POOJA BHATTA'";
					PreparedStatement pstmt=con.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ResultSet rs=pstmt.executeQuery();
					if(rs.next()) {
						int vote=Integer.parseInt(rs.getString(2));
						int newvote =vote+1;
						rs.updateInt(2, newvote);
						rs.updateRow();
						response.sendRedirect("successful.html");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			pw.println("SRY OTP DID NOT MATCHED PLEASE CHECK THE OTP ONCE.");
		}
		
	}

}
