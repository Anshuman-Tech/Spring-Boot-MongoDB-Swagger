package com.anshuman.springbootmongo.Implmentation;

import com.anshuman.springbootmongo.model.Job;
import com.anshuman.springbootmongo.repository.SearchRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;
    @Override
    public List<Job> findByText(String text){

        final List<Job> jobs = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("Job");
        MongoCollection<Document> collection = database.getCollection("jobs");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query",text)
                                .append("path", Arrays.asList("name", "desc", "exp", "skills"))))));

        result.forEach(doc->jobs.add(mongoConverter.read(Job.class,doc)));
        return jobs;
    }
}
