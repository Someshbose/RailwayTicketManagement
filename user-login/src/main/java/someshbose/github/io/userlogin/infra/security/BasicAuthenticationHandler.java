package someshbose.github.io.userlogin.infra.security;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

public class BasicAuthenticationHandler implements AuthenticationHandler{

    @Override
    public boolean canHandle(String header) {
        return StringUtils.isNoneBlank(header);
    }

    @Override
    public Optional<String> authenticate(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        String []tokens;

        try {
            tokens =extractAndDecodeHeader(httpServletRequest.getHeader("Authorization"));
        }catch (BadCredentialException ex){
            unauthorized(httpServletResponse,ex.getMessage(),"Basic realm");
            return Optional.empty();
        }
        String username = tokens[0];

        if(!isUserAuthorized(username,tokens[1])){
            unauthorized(httpServletResponse,"Wrong credentials, please check the provided credentials","Basic realm");
            return Optional.empty();
        }

        return Optional.ofNullable(username);
    }

    private String[] extractAndDecodeHeader(String header) {
        byte[] decoded;
        String token;
        try {
            byte[] base64token = header.substring("Basic".length()).getBytes(StandardCharsets.UTF_8);
            decoded= Base64.getMimeDecoder().decode(base64token);
            token=StringUtils.trim(new String(decoded,StandardCharsets.UTF_8));
        }catch (IllegalArgumentException e){
            throw new BadCredentialException("Failed to decode basic authentication token");
        }

        int delim = token.indexOf(':');

        if (delim == -1 || delim == 0){
            throw new BadCredentialException("Invalid basic authentication token");
        }

        return new String[]{token.substring(0,delim),token.substring(delim+1)};
    }

    private boolean isUserAuthorized(String username,String receivedPwd){
        return true;
    }
}
