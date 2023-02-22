package com.wesley.rest.webservices.restfulwebservices.helloworld;

//Expose a rest API in this controller. We also want to give a url to this controller. return a view/something


import org.springframework.web.bind.annotation.*;

//REST Controller API
@RestController
public class HelloWorldController {

    @RequestMapping(method=RequestMethod.GET, path = "/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping(path = "/get-mapping")
    public String getMappingHelloWorld() {
        return "Get mapping Hello World";
    }

    @GetMapping(path = "/get-mapping-bean")
    public HelloWorldBean getMappingHelloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-worlds/{name}") //What ever is between the {} needs to match what is passed in the method. IE name
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        // Pathvariable is what allows us to capture and store variable that have been passed through the url.
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
