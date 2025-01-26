package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entry.JournalEntry;
import net.engineeringdigest.journalApp.entry.User;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/journal")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity< List<User> >getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createEntry(@RequestBody User entry){
        userService.createEntry(entry);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping ("/id/{myId}")
    public ResponseEntity<User>  getJournalEntryById(@PathVariable Long myId) {
       try{
            User res = userService.findById(myId);
            return new ResponseEntity<>(res, HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>( HttpStatus.NOT_FOUND);
       }

    }

    @DeleteMapping ("/id/{myId}")
    public ResponseEntity deleteJournalEntryById(@PathVariable Long myId){
        userService.deleteById(myId);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/id/{myId}")
    public ResponseEntity<User>  updateJournalById(@PathVariable Long myId, @RequestBody User entry){
        User res = userService.update(entry);
        if(res!=null)
            return new ResponseEntity<>(res, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/updateUserByUserName/{userName}")
    public ResponseEntity<User> updateUserByUserName(@PathVariable String userName, @RequestBody User newUser){
        User user = userService.updateUserByUserName(userName, newUser );
        if(user!= null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
