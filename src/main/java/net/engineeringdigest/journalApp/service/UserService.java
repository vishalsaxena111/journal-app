package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entry.JournalEntry;
import net.engineeringdigest.journalApp.entry.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> getAll() {
      try {
          return  userRepo.findAll();
      }catch (Exception e) {
          return Collections.emptyList();
      }
    }

    public void createEntry(User entry) {
        userRepo.save(entry);
    }

    public User findById(Long myId) {
        Optional<User> data= userRepo.findById(myId);
        if(data.isPresent())
            return data.get();
        else
            return null;
    }

    public boolean deleteById(Long myId) {
        userRepo.deleteById(myId);
       return true;

    }

    public User update(User entry) {
       return userRepo.save(entry);
    }

    public User updateUserByUserName(String useraName, User newUser){
       User user = userRepo.findBYUserName(useraName);
       user.setUsername(newUser.getUsername());
       user.setPassword(newUser.getPassword());
       return userRepo.save(user);
    }
}
