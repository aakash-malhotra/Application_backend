package com.project.dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dev.models.serverDb;



@Repository
public interface serverDbRepo extends JpaRepository<serverDb, Integer>{

}
