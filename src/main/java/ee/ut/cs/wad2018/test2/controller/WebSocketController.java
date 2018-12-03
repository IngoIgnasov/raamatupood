package ee.ut.cs.wad2018.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSocketController {

    @GetMapping("/websocket-example")
    public String getWebsocketExamplePage() {
        return "websocket";
    }

}
