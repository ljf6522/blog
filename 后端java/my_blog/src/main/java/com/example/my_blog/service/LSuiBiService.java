package com.example.my_blog.service;

import com.example.my_blog.model.LSuibi;

import java.util.List;

public interface LSuiBiService {
    boolean addSuiBi(LSuibi lSuibi);

    boolean deleteSuiBi(Integer id);

    boolean updateSuiBi(LSuibi lSuibi);

    List<LSuibi> getAll(String search);
}
