package org.launchcode.hellospring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@ResponseBody
public class HelloController {


//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    ///////lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodBoy(){
        return "Goodbye, Spring!";
    }

//    @GetMapping("hello")
    //////live in /hello/hello
    ///////handles request of the form  at /hello?name=LaunchCode

//    @RequestMapping(method= { RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }

    @RequestMapping( value = "hello", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("cantonese")) {
            greeting = "Nay Hoh";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("Mandarin")) {
            greeting = "Ni Hau";
        }

        return greeting + " " + n;
    }

    ////////handles requests of the form  at /hello/LaunchCode
//    @GetMapping("hello/{name}")
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }

    //lives in hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='english' selected> English </option>" +
                "<option value='french'> French </option>" +
                "<option value='cantonese'> Cantonese </option>"  +
                "<option value='spanish'> Spanish </option>"  +
                "<option value='mandarin'> Mandarin </option>" +
                "</select>"  +
                "<input type='submit' value='Greeting!'>"+
                "</form>" +
                "</body>" +
                "</html>" ;
    }



}
