package sreeni.digitallibrary.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @GetMapping("/test")
    public String sayHelloTest() {
        System.out.println("inside");
        return "Testing hiii";
    }
}
