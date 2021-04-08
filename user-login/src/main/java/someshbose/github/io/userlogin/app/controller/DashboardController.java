package someshbose.github.io.userlogin.app.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello World";
    }
}
