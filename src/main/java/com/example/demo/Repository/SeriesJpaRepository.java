package com.example.demo.Repository;

import com.example.demo.Model.Series;

import java.util.List;

public interface SeriesJpaRepository {

    public void addSeries(Series series);

    public void updateSeries(Series series);

    public void removeSeries(int id);

    public Series getSeriesById(int id);

    public List<Series> listSeries();
}
