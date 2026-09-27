package com.springRev.MyfirstProject.controller;

import com.springRev.MyfirstProject.entity.JournalEntry;
import com.springRev.MyfirstProject.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

@Autowired
private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
      journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry findbyId(@PathVariable ObjectId myId){
       return journalEntryService.findById(myId).orElse(null);
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateId(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findById(myId).orElse(null);
        if (old != null){
          old.setTitle(newEntry.getTitle() !=null && !newEntry.getTitle().equals(" ")? newEntry.getTitle() : old.getTitle());
          old.setContent(newEntry.getContent() !=null && !newEntry.getContent().equals(" ")? newEntry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteId(@PathVariable ObjectId myId){
       journalEntryService.deleteById(myId);
       return true;
    }
}
