package com.kathe.springboot.app.controllers;

import com.kathe.springboot.app.models.dto.ParamDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.kathe.springboot.app.controllers.PathVariableController.getParamDTO;

@RestController
@RequestMapping("api/v1/params")
public class RequestParamsContoller {
    @GetMapping("/unique")
    public ParamDTO foo(@RequestParam(required = false, defaultValue = "undefined") String message){
        ParamDTO param = new ParamDTO();
        param.setMessage(message);

        return param;
    }

    @GetMapping("/multiparam")
    public ParamDTO multiFoo(
            @RequestParam(required = false, defaultValue = "undefined") String message,
            @RequestParam Integer value
    ){
        ParamDTO param = new ParamDTO();
        param.setMessage(message);
        param.setValue(value);

        return param;
    }

    @GetMapping("/multiparaminjected")
    public ParamDTO multiInjectedFoo(HttpServletRequest request) {
        ParamDTO param = new ParamDTO();
        String message = request.getParameter("message");
        String value = request.getParameter("value");

        return getParamDTO(message, value, param);
    }

}
