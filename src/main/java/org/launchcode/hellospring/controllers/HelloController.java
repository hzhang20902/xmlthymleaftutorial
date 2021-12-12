package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

//@RequestMapping("hello")
public class HelloController {

    //handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "The Rural Juror";
//    }

    //after adding requestmapping up there, this now lives at /hello/goodbye
//    @GetMapping("goodbye")
//    @ResponseBody
//    public String goodbye(){
//        return "Ruby Tuesday";
//    }

    //Handles requests of the form /hello?name=LaunchCode
    //after adding requestmapping up there, this now lives at /hello/hello
    @RequestMapping(value = "hello" ,method = {RequestMethod.GET, RequestMethod.POST})

    public String helloWithQueryParam(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "WHAMPOWW!";
        model.addAttribute("greetingsEarther", greeting);
        return "hello";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")

    public String helloWithPathParam(@PathVariable String name, Model model){
        String greeting="Hello " + name + " Wazzzupp!";
        //can be done without initializing greeting, directly putting it below in the param
        model.addAttribute("greetingsEarther", greeting);
        return "hello";
    }

    //after adding requestmapping up there, this now lives at /hello/form
    @GetMapping("form")

    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")w
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Animals As Leaders");
        names.add("Curtis Mayfield's great-nephew");
        //like above, the attributeName and second arg, value, don't have to be the same;
        //first one just needs to be the name being referenced in hello-list inside;
        //dollarsign{}, and second one is just the var above this with list of names;
        model.addAttribute("names", names);
        return "hello-list";
    }
}
