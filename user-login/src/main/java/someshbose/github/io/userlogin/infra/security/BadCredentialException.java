package someshbose.github.io.userlogin.infra.security;

public class BadCredentialException extends RuntimeException{

    public BadCredentialException(String message){
        super(message);
    }

    public BadCredentialException(String msg,Throwable t){
        super(msg,t);
    }
}
