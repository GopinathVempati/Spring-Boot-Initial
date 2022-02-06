package com.example.springboot;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/weather")
    public String getWeather() throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://weatherapi-com.p.rapidapi.com/forecast.json?q=Hyderabad&days=3")
                .header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
                .header("x-rapidapi-key", "ca1338890dmshfea44fac1b3aa50p1943a3jsndebab1febe30")
                .asString();
        return response.getBody();
    }

    @GetMapping("/weather/{cityName}/{noOfDays}")
    public String weatherApiWithParam(@PathVariable("cityName") String cityName, @PathVariable("noOfDays") Integer noOfDays) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://weatherapi-com.p.rapidapi.com/forecast.json?q=" + cityName + "&days=" + noOfDays)
                .header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
                .header("x-rapidapi-key", "ca1338890dmshfea44fac1b3aa50p1943a3jsndebab1febe30")
                .asString();
        return response.getBody();
    }

    @GetMapping("/getAllLanguageCodes")
    public String getAllLanguages() throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://google-translate1.p.rapidapi.com/language/translate/v2/languages")
                .header("accept-encoding", "application/gzip")
                .header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
                .header("x-rapidapi-key", "ca1338890dmshfea44fac1b3aa50p1943a3jsndebab1febe30")
                .asString();
        return response.getBody();
    }

    @PostMapping("/translateData/{data}/{src}/{dest}")
    public String translateData(@PathVariable("data") String data, @PathVariable("src") String src,
                                @PathVariable("dest") String dest) throws UnirestException {
        HttpResponse<String> response = Unirest.post("https://google-translate1.p.rapidapi.com/language/translate/v2")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("accept-encoding", "application/gzip")
                .header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
                .header("x-rapidapi-key", "ca1338890dmshfea44fac1b3aa50p1943a3jsndebab1febe30")
                .body("q=" + data + "&target=" + dest +  "&source=" + src)
                .asString();
        return response.getBody();
    }

}
