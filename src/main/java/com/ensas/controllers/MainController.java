package com.ensas.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensas.models.Client;
import com.ensas.models.Payement;
import com.ensas.services.ClientService;
import com.ensas.services.ClientServiceImpl;
import com.ensas.services.PayementService;
import com.ensas.services.PayementServiceImpl;

/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientService clientService;
	private PayementService payementService;
       
	@Override
	public void init() throws ServletException {
		clientService=new ClientServiceImpl();
		payementService=new PayementServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Client client=(Client) session.getAttribute("client");
		String action=request.getParameter("action");
		if(action!=null) {
			if(action.equals("login")) {
				if(client.getRole().equals("abonne")) {
					request.getServletContext().getRequestDispatcher("/WEB-INF/abonne.jsp").forward(request, response);
				}
				else if(client.getRole().equals("agent")) {
					List<Client> clients=clientService.getAllClient();
					request.setAttribute("clients", clients);
					request.getServletContext().getRequestDispatcher("/WEB-INF/agent.jsp").forward(request, response);
				}
				else {
					response.sendRedirect("public/login.jsp");
				}
			}
			else if (action.equals("paiement")) {
				String carte=request.getParameter("carte");
				String date=request.getParameter("date");
				String chiffre=request.getParameter("chiffre");
				String message="Merci pour votre confiance, Payement Valiser";
				if(carte.equals("0000000000000000") && date.equals("1111") && chiffre.equals("222")) {
					Payement payement=new Payement(Integer.parseInt(date), Integer.parseInt(chiffre));
					if(payementService.addPayement(payement, carte)) {
						request.setAttribute("message", message);
						request.getServletContext().getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);
					}
					else {
						message="Essayer a nouveau, une erreur est produite";
						request.setAttribute("message", message);
						request.getServletContext().getRequestDispatcher("/WEB-INF/abonne.jsp").forward(request, response);
					}
				}
				else {
					message="Veuillez choisir des donnees valides pour les champs";
					request.setAttribute("message", message);
					request.getServletContext().getRequestDispatcher("/WEB-INF/abonne.jsp").forward(request, response);
				}
			}
			else if(action.equals("deconnecter")) {
				session.getAttribute("client");
				session.invalidate();
				response.sendRedirect("public/login.jsp");
			}
		}
		else {
			if(client.getRole().equals("agent")) {
				List<Client> clients=clientService.getAllClient();
				request.setAttribute("clients", clients);
				request.getServletContext().getRequestDispatcher("/WEB-INF/agent.jsp").forward(request, response);
			}
			else if(client.getRole().equals("abonne")) {
				request.getServletContext().getRequestDispatcher("/WEB-INF/abonne.jsp").forward(request, response);
			}
		}
	}

}
