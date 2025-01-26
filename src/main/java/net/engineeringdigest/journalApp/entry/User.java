package net.engineeringdigest.journalApp.entry;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
@Data
public class User {

    @Id
    private long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @OneToMany
    private List<JournalEntry> journalEntryList  = new ArrayList<>();


}
