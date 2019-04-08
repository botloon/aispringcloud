package com.lzy.feign;

import com.lzy.entity.Menu;
import com.lzy.entity.MenuVO;
import com.lzy.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index")int index,@PathVariable("limit")int limit);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id")long id);

    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id")long id);

    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();

    @PostMapping("/menu/save")
    public void save(Menu menu);

    @PutMapping("/menu/update")
    public void update(Menu menu);




}
