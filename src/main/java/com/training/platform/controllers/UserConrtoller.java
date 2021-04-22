package com.training.platform.controllers;


import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserConrtoller {
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public List<User> index(){
        return userService.findAll();
    }

    @GetMapping(value = "/findAll" )
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/findById" )
    public Optional<User> findById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @GetMapping(value = "/findAllByQuery" )
    public List<User> findAllByQuery(){
        return userService.findAllByQuery();
    }

    @GetMapping(value = "/findAllByLimit" )
    public Page<User> findAllByLimit(@RequestParam Integer start, Integer limit, String field){
        return userService.findAllByLimit(start, limit, field);
    }

    @GetMapping(value = "/findByCityAndActiveAndAge" )
    public List<User> findByCityAndActiveAndAge(@RequestParam String city, Integer active, Integer age){
        return userService.findByCityAndActiveAndAge(city, active, age);
    }

    @GetMapping(value = "/findByAgeIn" )
    public List<User> findByAgeIn(@RequestParam List<Integer> ages){
        return userService.findByAgeIn(ages);
    }

    @GetMapping(value = "/findAllByParamsQuery" )
    public List<User> findAllByParamsQuery(@RequestParam Integer active, String city){
        return userService.findAllByParamsQuery(active, city);
    }

    @GetMapping(value = "/findAllByJpqlQuery" )
    public List<User> findAllByJpqlQuery(){
        return userService.findAllByJpqlQuery();
    }

    @GetMapping(value = "/findAllByJpqlParamsQuery" )
    public List<User> findAllByJpqlParamsQuery(@RequestParam Integer active, String city){
        return userService.findAllByJpqlParamsQuery(active, city);
    }


}
