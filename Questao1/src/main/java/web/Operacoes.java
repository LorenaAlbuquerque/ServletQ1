package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Operacoes")
public class Operacoes extends HttpServlet {
	private static final long serialVersionUID = 1;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter writer = response.getWriter();
			String num1String = request.getParameter("numero1");
			String num2String = request.getParameter("numero2");
			if (num1String.isEmpty() || num2String.isEmpty()) {
				writer.append("Algum dos números ou ambos números não foram inseridos");
			}
			int num1 = Integer.parseInt(num1String);
			int num2 = Integer.parseInt(num2String);

			writer.append(" <HTML>  <BODY> ");
			writer.append("Primeiro número:" + num1 + "<br>Segundo número:" + num2);
			writer.append("<br>Soma dos números: " + (num1 + num2));
			writer.append("<br>Subtração dos números: " + (num1 - num2));
			writer.append("<br>Multiplição dos números: " + (num1 * num2));
			if (num2 != 0) {
				writer.append("<br>Divisão dos números: " + ((double) num1 / num2));
				writer.append("<br>Resto da divisão inteira: " + (num1 % num2));
			} else {
				writer.append("Não é possível dividir por zero.<br>");
			}
			writer.append("</BODY>  </HTML>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
