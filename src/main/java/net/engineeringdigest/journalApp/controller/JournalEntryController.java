package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entry.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping ("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalService;

    @GetMapping()
    public ResponseEntity< List<JournalEntry> >getAll(){
        return new ResponseEntity<>(journalService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createEntry(@RequestBody JournalEntry entry){
        journalService.createEntry(entry);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping ("/id/{myId}")
    public ResponseEntity<JournalEntry>  getJournalEntryById(@PathVariable Long myId) {
       try{
            JournalEntry res = journalService.findById(myId);
            return new ResponseEntity<>(res, HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>( HttpStatus.NOT_FOUND);
       }

    }

    @DeleteMapping ("/id/{myId}")
    public ResponseEntity deleteJournalEntryById(@PathVariable Long myId){
         journalService.deleteById(myId);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/id/{myId}")
    public ResponseEntity<JournalEntry>  updateJournalById(@PathVariable Long myId, @RequestBody JournalEntry entry){
        JournalEntry res = journalService.update(entry);
        if(res!=null)
            return new ResponseEntity<>(res, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
