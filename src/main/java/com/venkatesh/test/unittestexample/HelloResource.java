package com.venkatesh.test.unittestexample;

import net.sf.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloResource {




    @GetMapping
    public String helloWorld() {
        return "Hello venaktesh";
    }


    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public  JSONObject json() {//Hello

        JSONObject obj = new JSONObject();
        obj.put("title","Greetings");
        obj.put("value","Hello World");
       // return new Hello("Greetings", "Hello World");
        return obj;
    }

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Hello post(@RequestBody Hello hello) {
        return hello;
    }

    public static class Hello {

        private String title;
        private String value;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Hello(String title, String value) {
            this.title = title;
            this.value = value;
        }

        public Hello() {
        }
    }
}
