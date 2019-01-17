package com.ajs.seeonsite.seeonsite.filter;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.ajs.seeonsite.seeonsite.ApplicationConstants;
import com.ajs.seeonsite.seeonsite.model.User;
import com.ajs.seeonsite.seeonsite.repository.UserRepository;

@Component
@Order(1)
@WebFilter()
public class UserAuthenticationFilter implements Filter {

	private static AntPathMatcher pathMatcher = new AntPathMatcher();

	@Autowired
	UserRepository userRepository;

	private static Logger LOG = Logger
			.getLogger(UserAuthenticationFilter.class.getName());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		LOG.info("URL : " + req.getServletPath());
		if (shouldNotFilter(req)) {
			LOG.info("Authentication skipped");
			chain.doFilter(request, response);
		} else {
			LOG.info("Authenticating");
			User user = (User) req.getSession().getAttribute("user");
			if (user == null) {
				LOG.info("Authentication failed");
			} else {
				Optional<User> exisitingUser = userRepository
						.findById(user.getUserId());
				if (!exisitingUser.isPresent()) {
					LOG.info("Authentication failed");
				}
			}
		}
	}

	private boolean shouldNotFilter(HttpServletRequest request)
			throws ServletException {
		return ApplicationConstants.EXCLUDED_URL_PATTERN.stream().anyMatch(
				path -> pathMatcher.match(path, request.getServletPath()));
	}

}
