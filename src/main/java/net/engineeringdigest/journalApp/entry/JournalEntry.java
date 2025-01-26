package net.engineeringdigest.journalApp.entry;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="journal_entry")
@Data
public class JournalEntry {

    @Id
    private long id;

    private String title;
    private String content;


}
