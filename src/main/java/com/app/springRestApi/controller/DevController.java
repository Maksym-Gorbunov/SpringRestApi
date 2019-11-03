package com.app.springRestApi.controller;

import com.app.springRestApi.model.DevRepo;
import com.app.springRestApi.model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DevController {

  @Autowired
  private DevRepo repo;

  @GetMapping("developers")
  public List<Developer> getDevelopers(){
    return repo.findAll();
  }

  @PostMapping("developers")
  public String addDeveloper(Developer dev){
    repo.save(dev);
    return "New developer was added successfully." + dev;
  }

}
