package filtres;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.esprit.nids.labo.recherche.persistence.Administrateur;
import tn.esprit.nids.labo.recherche.presentation.mbeans.AuthentificationBean;

@WebFilter(urlPatterns = "/admin/*")
public class AdminFiltre implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		AuthentificationBean authentificationBean = (AuthentificationBean) req.getSession()
				.getAttribute("authentificationBean");

		if (authentificationBean.getLoggedInEmploye() instanceof Administrateur) {
			chain.doFilter(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login.jsf");

		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
