package SFRS.SF_Replay_Sport.auth.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class demoController {

    @GetMapping("/demo")
    public String welcome(){
        return "Welcome from secure endpoint";
    }
}
