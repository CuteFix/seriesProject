package com.example.demo.Repository;

import com.example.demo.Model.Series;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SeriesJpaRepositoryImp implements SeriesJpaRepository{

    private static final Logger logger = LoggerFactory.getLogger(SeriesJpaRepositoryImp.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSeries(Series series) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(series);
        logger.info("Series saved" + series);
    }

    @Override
    public void updateSeries(Series series) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(series);
        logger.info("Series update" + series);
    }

    @Override
    public void removeSeries(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Series series = (Series) session.load(Series.class, id);
        if (series!=null){
            session.delete(series);
        }
        logger.info("Series remove" + series);
    }

    @Override
    public Series getSeriesById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Series series = (Series) session.load(Series.class, id);
        logger.info("Series load" + series);
        return series;
    }

    @Override

    @SuppressWarnings("unchecked")
    public List<Series> listSeries() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Series> seriesList = session.createQuery("from Series").list();
        for(Series series: seriesList){
            logger.info("Series list: " + series);
        }
        return seriesList;
    }
}
