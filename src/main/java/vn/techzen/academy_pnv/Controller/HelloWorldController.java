package vn.techzen.academy_pnv.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class    HelloWorldController {
    @RequestMapping("/greeting")
    public  String greeting(@RequestParam(defaultValue = "my name is tan") String name,
                            @RequestParam(defaultValue = "I live in Da Nang ") String address){
        return "Helloword"+" " + name +","+ address;
    }

}
