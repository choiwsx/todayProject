package com.example.demo.controller;

import com.example.demo.domain.Fortune;
import com.example.demo.exception.FortuneNotFoundException;
import com.example.demo.service.FortuneService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {
    private final FortuneService fortuneService;

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    public HomeController(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @GetMapping("/fortunes")
    @ApiOperation(value="운세가지고 오기", notes = "저장되어 있는 모든 운세를 반환한다.")
    List<Fortune> getAll(@RequestHeader HttpHeaders httpHeaders) throws FortuneNotFoundException, IOException {
        log.info(httpHeaders.toSingleValueMap().toString());
        return fortuneService.getAll();
    }

    @PutMapping("/fortunes")
    public void addFortune(@RequestBody Fortune fortune) {
        fortuneService.addFortune(fortune);
    }

    @DeleteMapping("/fortunes")
    public void deleteFortune(@RequestBody Long id)
    {

    }


    @GetMapping("/fortune")
    Fortune randomOne() throws FortuneNotFoundException {
        return fortuneService.getRandom().orElseThrow(() -> new FortuneNotFoundException());
    }

}
