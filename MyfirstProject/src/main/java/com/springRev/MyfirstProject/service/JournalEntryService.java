package com.springRev.MyfirstProject.service;

import com.springRev.MyfirstProject.entity.JournalEntry;
import com.springRev.MyfirstProject.repo.JournalEntryRepositroy;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

@Autowired
    private JournalEntryRepositroy journalEntryRepositroy;

public void saveEntry (JournalEntry journalEntry){
  journalEntryRepositroy.save(journalEntry);
 }

 public List<JournalEntry>getAll(){
    return journalEntryRepositroy.findAll();
 }

 public Optional<JournalEntry>findById(ObjectId id){
   return   journalEntryRepositroy.findById(id);
 }
 public void deleteById(ObjectId id){
    journalEntryRepositroy.deleteById(id);
 }
}
