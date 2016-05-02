package edu.usm.cos420.antenatal;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by aaron on 5/2/2016.
 */
@WebFilter(urlPatterns = { "/*" })
public class Filter implements javax.servlet.Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    servletRequest.setAttribute("siteName", "Antenatal Care");
    servletRequest.setAttribute("pageTitle","Index");

    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {

  }
}
