package com.example.demo.Servise;

import com.example.demo.Model.Series;
import com.example.demo.Repository.SeriesJpaRepository;
import com.example.demo.Repository.SeriesJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;



@Service
public class SeriesService implements ISeriesService{
    private SeriesJpaRepository seriesJpaRepository;

    public void setSeriesJpaRepository(SeriesJpaRepository seriesJpaRepository) {
        this.seriesJpaRepository = seriesJpaRepository;
    }

    @Override
    @Transactional
    public void addSeries(Series series) {
        this.seriesJpaRepository.addSeries(series);
    }

    @Override
    @Transactional
    public void updateSeries(Series series) {
        this.seriesJpaRepository.updateSeries(series);
    }

    @Override
    @Transactional
    public void removeSeries(int id) {
        this.seriesJpaRepository.removeSeries(id);
    }

    @Override
    @Transactional
    public Series getSeriesById(int id) {
        return this.seriesJpaRepository.getSeriesById(id);
    }

    @Override
    @Transactional
    public List<Series> listSeries() {
        return this.seriesJpaRepository.listSeries();
    }
}