package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entry.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {
}
