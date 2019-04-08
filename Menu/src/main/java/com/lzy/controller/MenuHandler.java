package com.lzy.controller;

import com.lzy.entity.Menu;
import com.lzy.entity.MenuVO;
import com.lzy.entity.Type;
import com.lzy.repository.MenuRepository;
import com.lzy.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index")int index,@PathVariable("limit")int limit){
        return new MenuVO(0," ",menuRepository.count(),menuRepository.findAll(index,limit));
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id")long id){
        return menuRepository.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")long id){
        menuRepository.deleteById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuRepository.save(menu);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuRepository.update(menu);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return typeRepository.findAll();
    }




}
