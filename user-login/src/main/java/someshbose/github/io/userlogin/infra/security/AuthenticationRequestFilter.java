package someshbose.github.io.userlogin.infra.security;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class AuthenticationRequestFilter extends OncePerRequestFilter {

    private List<AuthenticationHandler> authenticationHandler;

    public AuthenticationRequestFilter(List<AuthenticationHandler> authenticationHandler){
        this.authenticationHandler=authenticationHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String header= httpServletRequest.getHeader("Authorization");

        Optional<AuthenticationHandler> handler=authenticationHandler.stream().filter(h->h.canHandle(header)).findAny();

        if(!handler.isPresent()){
            httpServletResponse.addHeader("WWW-Authenticate","Basic");
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter writer = httpServletResponse.getWriter();
            log.warn("Http Status 401 -"+"Authorization header must use Basic token.");
            writer.println("Http Status 401 -"+"Authorization header must use Basic token.");
            return;
        }else{
            Optional<String> username =handler.get().authenticate(httpServletRequest,httpServletResponse);
            if (username.isPresent()){
                filterChain.doFilter(new AuthenticationRequestWrapper(username.orElse(StringUtils.EMPTY),httpServletRequest),httpServletResponse);
            }else{
                return;
            }
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return super.shouldNotFilter(request);
    }
}
