package org.launchcode.hellospring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {


//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodBoy(){
        return "Goodbye, Spring!";
    }

//    @GetMapping("hello")
    //live in /hello/hello
    //handles request of the form  at /hello?name=LaunchCode
    @RequestMapping(method= { RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //handles requests of the form  at /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //lives in hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greeting!'>"+
                "</form>" +
                "</body>" +
                "</html>" ;
    }



}
