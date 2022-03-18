package models.dao;

import models.pojos.News;

import java.util.List;

public interface newsDao {
    //post new news object
    void add(News news);

    //get allNewsObjects
    List<News> getAllNews();

    //get news by Id
    News findById(int id);

    //get news by depart
    List<News> findNewsByDepart(int departId);
}
