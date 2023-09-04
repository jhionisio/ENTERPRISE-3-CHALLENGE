package com.feedback.plusSoft.services;

import java.util.List;

import com.feedback.plusSoft.models.Feedback;

public interface FeedbackService {
    void create(Feedback feedback);

    List<Feedback> findAll();

    Feedback findById(Long id);

    void update(Long id, Feedback feedback);

    void deleteById(Long id);
}
