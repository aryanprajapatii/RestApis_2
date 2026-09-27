package com.springRev.MyfirstProject.repo;

import com.springRev.MyfirstProject.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepositroy extends MongoRepository<JournalEntry, ObjectId> {
}
