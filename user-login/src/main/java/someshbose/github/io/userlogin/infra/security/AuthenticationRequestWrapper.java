package someshbose.github.io.userlogin.infra.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;

public class AuthenticationRequestWrapper extends HttpServletRequestWrapper {

    private final String user;
    private final HttpServletRequest request;

    public AuthenticationRequestWrapper(String user,HttpServletRequest request) {
        super(request);
        this.user=user;
        this.request=request;
    }

    @Override
    public Principal getUserPrincipal() {
        return ()->user;
    }
}
