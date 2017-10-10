package com.readyidu.service;

import com.readyidu.model.Movie;

import java.util.List;

/**
 * Created by 123 on 2017/9/18.
 */
public interface MovieService {
    List<Movie> selectAllMovie();
    List<Movie> selectAllTrailer();
}
