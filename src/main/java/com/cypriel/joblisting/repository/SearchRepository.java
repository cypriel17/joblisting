package com.cypriel.joblisting.repository;

import com.cypriel.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);
}
