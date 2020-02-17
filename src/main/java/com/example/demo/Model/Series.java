package com.example.demo.Model;



import javax.persistence.*;


@Entity
@Table(name = "seriess")
public class Series {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "SERIES_NAME")
    private String seriesName;

    @Column(name = "SERIES_OS")
    private String seriesOS;

    @Column(name = "SERIES_RATE")
    private int rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String bookTitle) {
        this.seriesName = bookTitle;
    }

    public String getSeriesOS() {
        return seriesOS;
    }

    public void setSeriesOS(String bookAuthor) {
        this.seriesOS = bookAuthor;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int price) {
        this.rate = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", SeriesName='" + seriesName + '\'' +
                ", SeriesOS='" + seriesOS + '\'' +
                ", rate=" + rate +
                '}';
    }
}

