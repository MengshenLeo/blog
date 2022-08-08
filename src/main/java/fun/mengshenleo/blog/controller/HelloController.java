package fun.mengshenleo.blog.controller;

import fun.mengshenleo.blog.domain.ResultInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mengshen
 * @date 2022/7/23 17:36
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public ResultInfo helloController(){
        return ResultInfo.ok("hello,blog");
    }
}
