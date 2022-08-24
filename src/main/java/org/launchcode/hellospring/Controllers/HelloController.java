package org.launchcode.hellospring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {


//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    ///////lives at /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodBoy(){
        return "Goodbye, Spring!";
    }

    ////live in /hello/hello
    /////handles request of the form  at /hello?name=LaunchCode

    @RequestMapping(value = "hello", method= { RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    @RequestMapping( value = "hello", method = RequestMethod.POST)
    @ResponseBody
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

        return greeting + " " + n + " !";
    }

    ////////handles requests of the form  at /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    //lives in hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }


    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Java");
        names.add("React");
        names.add("C+");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
