package com.ensas.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensas.models.Client;
import com.ensas.services.ClientService;
import com.ensas.services.ClientServiceImpl;

/**
 * Servlet Filter implementation class RestrictionFilter
 */
public class RestrictionFilter implements Filter {


	private ServletContext context;
	private ClientService clientService;
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("RestrictionFilter est initialise: "+new Date());
		clientService=new ClientServiceImpl();
	}
	

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session=request.getSession();
        
        /**
         * La journalisation
         */
        this.context.log("La machine distanter du client "+request.getRemoteHost());
        this.context.log("adresse ip du client "+request.getRemoteAddr());
        this.context.log("le port du client "+request.getRemotePort());
        this.context.log("le nom du client distant "+request.getRemoteUser());
        this.context.log("--------------------------------------------------------");
        
        String nom=request.getParameter("login");
        String mdp=request.getParameter("mdp");
        
        /*
         * Verification de l'authentification
         */
        if(nom!=null && mdp!=null) {
        	Client client=clientService.login(nom, mdp);
        	if(client!=null) {
        		session.setAttribute("client", client);
        		chain.doFilter(request, response);
        	}
        	else {
        		response.sendRedirect(request.getContextPath()+"/public/erreurAuthentification.jsp");
        	}
        }
        /*
         * Verification de la session
         */
       
        else if(session.getAttribute("client")!=null) {
        	chain.doFilter(request, response);
        }
        else {
        	response.sendRedirect(request.getContextPath()+"/public/login.jsp");
        }
	}


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
