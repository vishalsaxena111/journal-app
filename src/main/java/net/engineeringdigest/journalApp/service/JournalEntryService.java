package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entry.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalRepo;

    public List<JournalEntry> getAll() {
      try {
          return  journalRepo.findAll();
      }catch (Exception e) {
          return Collections.emptyList();
      }
    }

    public void createEntry(JournalEntry entry) {
        journalRepo.save(entry);
    }

    public JournalEntry findById(Long myId) {
        Optional<JournalEntry> data= journalRepo.findById(myId);
        if(data.isPresent())
            return data.get();
        else
            return null;
    }

    public boolean deleteById(Long myId) {
        journalRepo.deleteById(myId);
       return true;

    }

    public JournalEntry update(JournalEntry entry) {
       return journalRepo.save(entry);
    }
}
