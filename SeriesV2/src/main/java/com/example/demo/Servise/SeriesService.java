package com.example.demo.Servise;

import com.example.demo.Model.Series;
import com.example.demo.Repository.SeriesJpaRepository;
import com.example.demo.Repository.SeriesJpaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SeriesService {
    private static boolean test = false;
    private String result = "";

    private static Logger logger = Logger.getRootLogger();

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private SeriesJpaRepository seriesRep;

    public SeriesService(){
    }

    public List<Series> AddQuery() {
        try{
            logger.trace("Начало AddQuery");
            List<Series> students = this.getSetSeries();
            String studentsString = "";
            for(int i=0;i<=getSeries().size();i++){
                studentsString = studentsString + students.toString();
            }
            logger.debug("return AddQuery"+studentsString);
            logger.trace("Конец AddQuery");
            return students;

        }catch (NullPointerException ex){
            logger.error("Error NullPointerException AddQuery"+ex);
            return null;
        }
    }

    public String print(List<Series> series){
        String res = "";
        for(Series b : series){
            res+="ID:"+b.getId()+",";
            res+="Название:"+b.getName()+",";
            res+="Краткое описание:"+b.getDescription()+";\n";
        }
        return res;
    }


    public List<Series> getSeries() {
        try {
            if (!test) {
                test = true;
                this.addSeries();
            }
            Iterable<Series> iterable = this.seriesRep.findAll();
            List<Series> list = new ArrayList();
            iterable.forEach(list::add);
            return list;
        }
        catch (NullPointerException ex){
            logger.error("Error NullPointerException getStudents"+ex);
            return null;
        }
    }

    public List<Series> getSetSeries() {
        try {
            String listString = "";
            logger.trace("Начало getSetSeries");
            if (!test) {
                test = true;
                this.addSeries();
            }
            List<Series> list = this.getSeries();
            List<Series> result = list;
            for(int i=0;i<=getSeries().size();i++){
                listString = listString + result.toString();
            }
            logger.debug("return getSetSeries"+result);
            logger.trace("Конец getSetSeries");
            return result;
        }catch (NullPointerException ex){
            logger.error("Error NullPointerException getSetStudents", ex);
            return null;
        }
    }

    public void addSeries() {
        try {
            String seriessString = "";
            logger.trace("Начало addSeries");
            List<Series> seriess = new ArrayList<>();
            seriess.add(new Series("Проповедник",43,91, "«Пропове́дник» — американский телесериал, производством которого занимаются Эван Голдберг, Сет Роген и Сэм Кэтлин по заказу телеканала AMC. Пилотный эпизод был заказан телеканалом AMC 7 февраля 2014 года."));
            seriess.add(new Series("Во_все_тяжки",62,96, "«Во все тяжкие» — американская телевизионная криминальная драма, транслировавшаяся с 20 января 2008 года по 29 сентября 2013 года по кабельному каналу AMC. "));
            for(int i = 0; i < seriess.size(); ++i) {
                this.seriesRep.save(seriess.get(i));
                seriessString = seriessString + seriess.toString();

            }
            logger.debug("return addSeries"+seriessString);
            logger.trace("Конец addSeries");
        }catch (NullPointerException ex) {
            logger.error("Error NullPointerException addSeries", ex);
        }
    }

    public List<Series> FindAll(){
        try {
            //logger.trace("Начало FindAll");
            logger.debug("return FindAll");
            logger.trace("Конец FindAll");
            return this.seriesRep.findAll();
        }catch (NullPointerException ex)
        {
            logger.error("Error NullPointerException FindAll", ex);
            return null;
        }
    }

    public List<Series> deleteByCharInName(char abs){

        try{
            List<Series> list = getSeries();
            String listst = "";
           // logger.trace("Входные данные deleteByCharInName"+abs);
            for(int i=0;i<list.size();i++) {
                if (list.get(i).getName().charAt(0) == abs){
                    seriesRep.deleteById(list.get(i).getId());
                }
            }
            for(int i=0;i<=getSeries().size();i++){
                listst = listst + list.toString();
            }
            for(int i=0;i<=getSeries().size();i++){
                listst = listst + getSeries().toString();
            }
           // logger.trace("Выходные данные deleteByCharInName"+getSeries());
            //logger.debug("Debug deleteByCharInName"+listst);
            return getSeries();
        }catch (NullPointerException ex){
            //logger.error("Error NullPointerException deleteByCharInName", ex);
            return null;
        }
    }

    public List<Series> deleteById(Long id){
        try {

            //logger.trace("Входные данные delete"+id);
            this.seriesRep.deleteById(id);
            //logger.debug("return delete");
            //logger.trace("Выходные данные delete "+id+" удаление сериала с этим id");

            return getSeries();
        }catch (NullPointerException ex){
           // logger.error("Error NullPointerException delete", ex);
            return null;
        }
    }

    public Optional<Series> findById(Long id) {
        try {
           // logger.trace("Входные данные find"+id);
            //logger.trace("Выходные данные find "+id+" нахождение сериала с этим id");
            return seriesRep.findById(id);
        }catch (NullPointerException ex){
            //logger.error("Error NullPointerException find", ex);
            return null;
        }
    }
/*
    public static final String SQL_UPDATE_PROFILE =
            "update serias set id = :id, name = :name, numberOS = :numberOS, rate =:rate, description=: description where id = :id";

    public void updateSeries(Long id, String name, Integer numberOS, double rate, String description){
        //List<Series> seriess = new ArrayList<>();
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        params.addValue("name", name);
        params.addValue("numberOS", numberOS);
        params.addValue("rate", rate);
        params.addValue("description", description);
        jdbcTemplate.update(SQL_UPDATE_PROFILE, params);
    }

    public void updateProfileS(Long id, String name, Integer numberOS, double rate, String description) {
        Series series = seriesRep.getOne(id);

    }

/*
    public void createById(Long id, String name, Integer numberOS, double rate, String description){
        try {
            logger.trace("Входные данные delete"+id);
            List<Series> seriess = new ArrayList<>();



            logger.debug("return delete");
            logger.trace("Выходные данные delete "+id+" удаление сериала с этим id");

            return getSeries();
        }catch (NullPointerException ex){
            logger.error("Error NullPointerException delete", ex);
            return null;
        }
    }
*/

}