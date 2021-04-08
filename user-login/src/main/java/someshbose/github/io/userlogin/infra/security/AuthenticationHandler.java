package someshbose.github.io.userlogin.infra.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public interface AuthenticationHandler {

   boolean canHandle(String header);

   Optional<String> authenticate(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws IOException,ServletException;

   default void unauthorized(HttpServletResponse httpServletResponse,String message, String authType) throws IOException{
       httpServletResponse.addHeader("WWW-Authenticate",authType);
       httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
       PrintWriter writer = httpServletResponse.getWriter();
       writer.println("Http Status 401 -"+message);
   }
}
