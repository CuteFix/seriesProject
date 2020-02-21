package com.example.demo.Servise;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.Model.Series;
import com.example.demo.Repository.SeriesJpaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeriesServiceTest {
    @Autowired
    SeriesService seriesService;
    @MockBean
    private SeriesJpaRepository seriesRep;
    public SeriesServiceTest(){
    }

    @Test
    public void checkGetseries(){
        List<Series> seriess = new ArrayList();
        seriess.add(new Series(1L,"Проповедник",43,91, "«Пропове́дник» — американский телесериал, производством которого занимаются Эван Голдберг, Сет Роген и Сэм Кэтлин по заказу телеканала AMC. Пилотный эпизод был заказан телеканалом AMC 7 февраля 2014 года."));
        seriess.add(new Series(2L,"Во все тяжки",62,96, "«Во все тяжкие» — американская телевизионная криминальная драма, транслировавшаяся с 20 января 2008 года по 29 сентября 2013 года по кабельному каналу AMC. На протяжении пяти сезонов, состоящих из 62 эпизодов, показана история Уолтера Уайта, школьного учителя, у которого диагностировали неоперабельный рак лёгких."));
        Mockito.doReturn(seriess).when(seriesRep).findAll();
        List<Series> seriesList = seriesService.getSeries();
        Assert.assertTrue(seriess.containsAll(seriesList));
        Mockito.verify(seriesRep, Mockito.times(1)).findAll();
        Mockito.verify(seriesRep, Mockito.never()).count();
    }

    @Test
    public void checkGetSetseries(){
        List<Series> seriess = new ArrayList();
        Mockito.doReturn(seriess).when(seriesRep).findAll();
        List<Series> seriesList = seriesService.getSetSeries();
        Mockito.verify(seriesRep, Mockito.times(3)).findAll();
        List<Series> result = new ArrayList();
        result.add(new Series(1L,"Проповедник",43,91, "«Пропове́дник» — американский телесериал, производством которого занимаются Эван Голдберг, Сет Роген и Сэм Кэтлин по заказу телеканала AMC. Пилотный эпизод был заказан телеканалом AMC 7 февраля 2014 года."));
        result.add(new Series(2L,"Во все тяжки",62,96, "«Во все тяжкие» — американская телевизионная криминальная драма, транслировавшаяся с 20 января 2008 года по 29 сентября 2013 года по кабельному каналу AMC. На протяжении пяти сезонов, состоящих из 62 эпизодов, показана история Уолтера Уайта, школьного учителя, у которого диагностировали неоперабельный рак лёгких."));
    }
    @Test
    public void checkAddseries(){
        List<Series> seriess = new ArrayList();
        seriess.add(new Series(1L,"Проповедник",43,91, "«Пропове́дник» — американский телесериал, производством которого занимаются Эван Голдберг, Сет Роген и Сэм Кэтлин по заказу телеканала AMC. Пилотный эпизод был заказан телеканалом AMC 7 февраля 2014 года."));
        seriess.add(new Series(2L,"Во все тяжки",62,96, "«Во все тяжкие» — американская телевизионная криминальная драма, транслировавшаяся с 20 января 2008 года по 29 сентября 2013 года по кабельному каналу AMC. На протяжении пяти сезонов, состоящих из 62 эпизодов, показана история Уолтера Уайта, школьного учителя, у которого диагностировали неоперабельный рак лёгких."));
        int i;
        for(i = 0; i < seriess.size(); ++i) {
            this.seriesRep.save(seriess.get(i));
        }
        for(i = 0; i < 3; ++i) {
        Mockito.verify(this.seriesRep, Mockito.times(1)).save(seriess.get(i));
        }
    }

    @Test
    public void checkDeleteseriesByIndex(){
        List<Series> seriess = new ArrayList();
        seriess.add(new Series(1L,"Проповедник",43,91, "«Пропове́дник» — американский телесериал, производством которого занимаются Эван Голдберг, Сет Роген и Сэм Кэтлин по заказу телеканала AMC. Пилотный эпизод был заказан телеканалом AMC 7 февраля 2014 года."));
        seriess.add(new Series(2L,"Во все тяжки",62,96, "«Во все тяжкие» — американская телевизионная криминальная драма, транслировавшаяся с 20 января 2008 года по 29 сентября 2013 года по кабельному каналу AMC. На протяжении пяти сезонов, состоящих из 62 эпизодов, показана история Уолтера Уайта, школьного учителя, у которого диагностировали неоперабельный рак лёгких."));
        Mockito.doReturn(seriess).when(seriesRep).findAll();
        List<Series> seriesList = seriesService.deleteByCharInName('D');
        Mockito.verify(seriesRep, Mockito.times(1)).deleteById(1L);
        Mockito.verify(seriesRep, Mockito.times(17)).findAll();
        List<Series> result = new ArrayList<>();
        result.add(new Series(1L,"Проповедник",43,91, "«Пропове́дник» — американский телесериал, производством которого занимаются Эван Голдберг, Сет Роген и Сэм Кэтлин по заказу телеканала AMC. Пилотный эпизод был заказан телеканалом AMC 7 февраля 2014 года."));
        result.add(new Series(2L,"Во все тяжки",62,96, "«Во все тяжкие» — американская телевизионная криминальная драма, транслировавшаяся с 20 января 2008 года по 29 сентября 2013 года по кабельному каналу AMC. На протяжении пяти сезонов, состоящих из 62 эпизодов, показана история Уолтера Уайта, школьного учителя, у которого диагностировали неоперабельный рак лёгких."));
    }

    @Test
    public void checkDeleteseriesById(){
        List<Series> seriess = new ArrayList();
        seriess.add(new Series(1L,"Проповедник",43,91, "«Пропове́дник» — американский телесериал, производством которого занимаются Эван Голдберг, Сет Роген и Сэм Кэтлин по заказу телеканала AMC. Пилотный эпизод был заказан телеканалом AMC 7 февраля 2014 года."));
        seriess.add(new Series(2L,"Во все тяжки",62,96, "«Во все тяжкие» — американская телевизионная криминальная драма, транслировавшаяся с 20 января 2008 года по 29 сентября 2013 года по кабельному каналу AMC. На протяжении пяти сезонов, состоящих из 62 эпизодов, показана история Уолтера Уайта, школьного учителя, у которого диагностировали неоперабельный рак лёгких."));
        Mockito.doReturn(seriess).when(seriesRep).findAll();
        List<Series> seriesList = seriesService.deleteById(1L);
        Mockito.verify(seriesRep, Mockito.times(1)).deleteById(1L);
        Assert.assertTrue(seriess.containsAll(seriesList));
    }
    @Test
    public void checkPrint()
    {
        List<Series> seriess = new ArrayList();
        seriess.add(new Series(1L,"Проповедник",43,91, "«Пропове́дник» — американский телесериал, производством которого занимаются Эван Голдберг, Сет Роген и Сэм Кэтлин по заказу телеканала AMC. Пилотный эпизод был заказан телеканалом AMC 7 февраля 2014 года."));
        seriess.add(new Series(2L,"Во все тяжки",62,96, "«Во все тяжкие» — американская телевизионная криминальная драма, транслировавшаяся с 20 января 2008 года по 29 сентября 2013 года по кабельному каналу AMC. На протяжении пяти сезонов, состоящих из 62 эпизодов, показана история Уолтера Уайта, школьного учителя, у которого диагностировали неоперабельный рак лёгких."));
        Mockito.doReturn(seriess).when(seriesRep).findAll();
        String resTest = seriesService.print(seriess);
        System.out.println(resTest);
        Mockito.verify(seriesRep, Mockito.times(0)).findAll();
        Mockito.verify(seriesRep, Mockito.never()).findById(4L);
        String res = "ID:1,Имя:Проповедник,Возраст:43\nID:2,Имя:Во все тяжки,Возраст:96;\n";
        System.out.println(res);
        Assert.assertTrue(res.equals(resTest));
    }
    @Test
    public void checkFindAll() {
        List<Series> seriess = new ArrayList();
        seriess.add(new Series(1L,"Проповедник",43,91, "«Пропове́дник» — американский телесериал, производством которого занимаются Эван Голдберг, Сет Роген и Сэм Кэтлин по заказу телеканала AMC. Пилотный эпизод был заказан телеканалом AMC 7 февраля 2014 года."));
        seriess.add(new Series(2L,"Во все тяжки",62,96, "«Во все тяжкие» — американская телевизионная криминальная драма, транслировавшаяся с 20 января 2008 года по 29 сентября 2013 года по кабельному каналу AMC. На протяжении пяти сезонов, состоящих из 62 эпизодов, показана история Уолтера Уайта, школьного учителя, у которого диагностировали неоперабельный рак лёгких."));
        Mockito.doReturn(seriess).when(seriesRep).findAll();
        List<Series> seriessList = seriesService.FindAll();
        Assert.assertTrue(seriess.containsAll(seriessList));
        Mockito.verify(seriesRep, Mockito.times(1)).findAll();;
}
    @Test
    public void checkAddQuery(){
        List<Series> seriess = new ArrayList();
        seriess.add(new Series(1L,"Проповедник",43,91, "«Пропове́дник» — американский телесериал, производством которого занимаются Эван Голдберг, Сет Роген и Сэм Кэтлин по заказу телеканала AMC. Пилотный эпизод был заказан телеканалом AMC 7 февраля 2014 года."));
        seriess.add(new Series(2L,"Во все тяжки",62,96, "«Во все тяжкие» — американская телевизионная криминальная драма, транслировавшаяся с 20 января 2008 года по 29 сентября 2013 года по кабельному каналу AMC. На протяжении пяти сезонов, состоящих из 62 эпизодов, показана история Уолтера Уайта, школьного учителя, у которого диагностировали неоперабельный рак лёгких."));
        Mockito.doReturn(seriess).when(seriesRep).findAll();
        List<Series> seriessList = seriesService.AddQuery();
        Mockito.verify(seriesRep, Mockito.times(11)).findAll();
        Assert.assertTrue(seriess.equals(seriessList));
    }

}