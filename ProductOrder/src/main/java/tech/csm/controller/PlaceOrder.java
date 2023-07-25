package tech.csm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech.csm.service.ProductServiceImpl;

@WebServlet("/search")
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
//		pw.print("this is working");
		String pdName =request.getParameter("name");
		Integer pdQty =Integer.parseInt(request.getParameter("qty"));
//		Product product new Product();
		Integer res = new ProductServiceImpl().placeOrder(pdName,pdQty);
		if(res !=0)
			pw.print("order placed");
		else
			pw.print("Order not placed");

	}

}
