//package com.app.springRestApi.model;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface DevRepo extends JpaRepository<Developer, Integer> {
//
//  //existing methods + field name for auto methods
//
//  List<Developer> findByLang(String lang);
//
//  List<Developer> findByIdGreaterThan(int id);
//
//  //make own query method, learn JPQL
//  @Query("from Developer where lang=?1 order by name")
//  List<Developer> findByLangSorted(String lang);
//}
