package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entry.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping ("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalService;

    Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping()
    public List<JournalEntry> getAll(){
        return  journalService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry){
        journalService.createEntry(entry);
        return true;
    }

    @GetMapping ("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId) {
        return journalService.findById(myId);
    }

    @DeleteMapping ("/id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable Long myId){
        return journalService.deleteById(myId);
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateJournalById(@PathVariable Long myId, @RequestBody JournalEntry entry){
        return journalService.update(entry);

    }

}
