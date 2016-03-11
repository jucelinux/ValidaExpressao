package com.jucelinux;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidadorController {
    
    @RequestMapping("/")
    public String index(@RequestParam(value="expressao", defaultValue="") String expressao) {
    	if(ValidadorUtil.validaExpressao(expressao)){
    		return "Expressão bem formada";
    	}else{
    		return "Expressão mal formada";
    	}
    }
    
}
