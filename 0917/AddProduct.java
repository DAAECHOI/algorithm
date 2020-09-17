package com.ssafy.ws;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ParseConversionEvent;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		int stock = Integer.parseInt(request.getParameter("stock"));
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ko\">");
		out.println("<head>");
		out.println("  <title>상품정보</title>");
		out.println("  <meta charset=\"utf-8\">");
		out.println("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">");
		out.println("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
		out.println("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>");
		out.println("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>");
		out.println("	<script type=\"text/javascript\">");
		out.println("	$(document).ready(function() {");
		out.println("		$(\"#AddProduct\").click(function() {");
		out.println("			$(location).attr(\"href\", \"/backend/hwAddProduct.jsp\");");
		out.println("		});");
		out.println("	});");
		out.println("	</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("");
		out.println("<div class=\"container\" align=\"center\">");
		out.println("	<button type=\"button\" id=\"AddProduct\" class=\"btn btn-info mb-2 mt-2\">상품등록</button></td>");
		out.println("	<table class=\"table table-bordered\">");
		out.println("		<tbody>");
		out.println("			<thead>");
		out.println("				<tr>");
		out.println("					<th>" + "상품번호" + "</th>");
		out.println("					<th>" + "상품명" + "</th>");
		out.println("					<th>" + "상품가격" + "</th>");
		out.println("					<th>" + "상품설명" + "</th>");
		out.println("					<th>" + "상품재고" + "</th>");
		out.println("				</tr>");
		out.println("			</thead>");
		out.println("			<tr>");
		out.println("				<td>" + pid + "</td>");
		out.println("				<td>" + pname + "</td>");
		out.println("				<td>" + price + "</td>");
		out.println("				<td>" + description + "</td>");
		out.println("				<td>" + stock + "</td>");
		out.println("			</tr>");
		out.println("		</tbody>");
		out.println("	</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
