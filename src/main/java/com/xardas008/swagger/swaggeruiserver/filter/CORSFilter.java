package com.xardas008.swagger.swaggeruiserver.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Request filter for enabling cors requests.
 *
 * @author Daniel Kreuter
 * @since 1.0
 */
@Configuration
public class CORSFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");

        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "Origin, Authorization, Accept, Content-Type, api_key");
        httpServletResponse.addHeader("Access-Control-Max-Age", "100");

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
