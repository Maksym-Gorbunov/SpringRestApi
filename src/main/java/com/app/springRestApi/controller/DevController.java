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
    String message = "New developer was successfully added.  " + dev;
    return message;
  }

  @PutMapping("developers")
  public String editDeveloper(Developer dev){
    repo.save(dev);
    String message = "Developer was successfully updated.  " + dev;
    return message;
  }

  @DeleteMapping("developers/{id}")
  public String deleteDeveloper(@PathVariable("id") int id){
    Developer dev = repo.getOne(id);
    String message = "Developer was successfully deleted.  " + dev;
    repo.delete(dev);
    return message;
  }

}
