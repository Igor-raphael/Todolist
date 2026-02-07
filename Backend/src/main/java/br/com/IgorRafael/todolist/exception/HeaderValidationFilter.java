package br.com.IgorRafael.todolist.exception;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class HeaderValidationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException{
		
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		
		 String path = httpRequest.getRequestURI();

		    // Rotas que NÃO exigem X-Client-Id
		    if (path.startsWith("/todos/cron")
		        || path.startsWith("/swagger-ui")
		        || path.startsWith("/v3/api-docs")) {
		      chain.doFilter(req, res);
		      return;
		    }
		
		
		
		
		String customHeader = httpRequest.getHeader("X-Client-Id");
		
		if (customHeader == null || customHeader.isBlank()) {
			   HttpServletResponse httpResponse = (HttpServletResponse) res;
			   httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Header obrigatório ausente" );
			   return;
			}
		
		chain.doFilter(req, res);
		
	}

}
