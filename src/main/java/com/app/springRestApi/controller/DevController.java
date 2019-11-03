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

  // http://localhost:9090/developers
  @GetMapping("developers")
  public List<Developer> getDevelopers(){
    return repo.findAll();
  }

  // http://localhost:9090/developers + data
  @PostMapping("developers")
  public String addDeveloper(Developer dev){
    repo.save(dev);
    String message = "New developer was successfully added.  " + dev;
    return message;
  }

  // http://localhost:9090/developers + data
  @PutMapping("developers")
  public String editDeveloper(Developer dev){
    repo.save(dev);
    String message = "Developer was successfully updated.  " + dev;
    return message;
  }

  // http://localhost:9090/developer/4
  @DeleteMapping("developers/{id}")
  public String deleteDeveloper(@PathVariable("id") int id){
    Developer dev = repo.getOne(id);
    String message = "Developer was successfully deleted.  " + dev;
    repo.delete(dev);
    return message;
  }

  // http://localhost:9090/developer/4
  @GetMapping("developer/{id}")
  public Developer getDeveloperById(@PathVariable("id") int id){
    Developer dev = repo.findById(id).orElse(new Developer());
    return dev;
  }

  // http://localhost:9090/developers/lang/Java
  @GetMapping("developers/lang/{lang}")
  public List<Developer> findByLangDeveloper(@PathVariable("lang") String lang){
    List<Developer> result = repo.findByLang(lang);
    return result;
  }

  // http://localhost:9090/developers/above
  @RequestMapping("developers/above/{id}")
  public List<Developer> findAllWithIdGreaterThan(@PathVariable("id") int id){
    List<Developer> result = repo.findByIdGreaterThan(id);
    return result;
  }




}
