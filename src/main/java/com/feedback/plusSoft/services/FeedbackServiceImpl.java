package com.feedback.plusSoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.plusSoft.models.Feedback;
import com.feedback.plusSoft.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    @Override
    public void create(Feedback feedback) {
        repository.save(feedback);
    }

    @Override
    public List<Feedback> findAll() {
        return repository.findAll();
    }

    @Override
    public Feedback findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, Feedback feedback) {
        feedback.setId(id);
        repository.save(feedback);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
