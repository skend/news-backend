package com.skend.news.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class SearchController {

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public String search(@RequestParam("filter") String filter, @RequestParam("skip") long skip, @RequestParam("limit") long limit) {

    }

}
