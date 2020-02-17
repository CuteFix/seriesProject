package com.example.demo.Controller;

import com.example.demo.Model.Series;
import com.example.demo.Servise.ISeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SeriesController {
    private ISeriesService service;

    @Autowired(required = true)
    @Qualifier(value = "service")
    public void setService(ISeriesService service) {
        this.service = service;
    }

    @RequestMapping(value = "/seriess", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("series", new Series());
        model.addAttribute("listSeries", this.service.listSeries());
        return "seriess";
    }

    @RequestMapping(value = "/seriess/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("series") Series series){
        if(series.getId() == 0){
            this.service.addSeries(series);
        }else {
            this.service.updateSeries(series);
        }

        return "redirect:/seriess";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.service.removeSeries(id);

        return "redirect:/seriess";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("series", this.service.getSeriesById(id));
        model.addAttribute("listSeries", this.service.listSeries());

        return "seriess";
    }

    @RequestMapping("seriesdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.service.getSeriesById(id));

        return "seriesdata";
    }
    /*
    public SeriesController(){
    }
    @GetMapping(value = "/AddQuery")
    public String select() {
        return this.service.print(this.service.AddQuery());
    }

    @GetMapping("/FindAll")
    public String findAll() {
        return this.service.print(this.service.FindAll());
    }

    @GetMapping("/FindById")
    public Optional<Series> findById(@RequestParam("id") Long id) {
        return this.service.findById(id);
    }

    @PostMapping("/")

    @RequestMapping("/Edit")
    public String editBook(@PathVariable("id") long id, Model model){
        model.addAttribute("Series", this.serviceI.getSeriesById(id));
        model.addAttribute("listSeries", this.serviceI.listSeries());
        return "series";
    }

    @DeleteMapping("/DeleteByCharInName")
    public String deleteByName(@RequestParam("char") char abs) {
        return this.service.print(this.service.deleteByCharInName(abs));
    }

    @DeleteMapping("/DeleteById")
    public String deleteSeries(@RequestParam("id") Long id) {

        return this.service.print(this.service.deleteById(id));
    }

}
*/
}
