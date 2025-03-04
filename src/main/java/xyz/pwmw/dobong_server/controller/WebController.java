package xyz.pwmw.dobong_server.controller;

import org.springframework.stereotype.Controller;

@Controller
public class WebController {

    // index.html
    public  String index() {
        return "index";
    }
}
