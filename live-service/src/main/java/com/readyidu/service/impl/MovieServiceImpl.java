package com.readyidu.service.impl;

import com.readyidu.mapper.MovieMapper;
import com.readyidu.model.Movie;
import com.readyidu.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 123 on 2017/9/18.
 */
@Service("movieService")
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;
    @Override
    public List<Movie> selectAllMovie() { return movieMapper.selectAllMovie(); }

    @Override
    public List<Movie> selectAllTrailer() {return movieMapper.selectAllTrailer();}
}
