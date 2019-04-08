package com.lzy.controller;

import com.lzy.entity.MenuVO;
import com.lzy.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page")int page,@RequestParam("limit")int limit){
        int index = (page-1)*limit;
        return menuFeign.findAll(index,limit);
    }


}
