package com.readyidu.mapper;

import com.readyidu.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 123 on 2017/9/18.
 */
@Component
public interface MovieMapper
{
    List<Movie> selectAllMovie();
    List<Movie> selcetAllMovieToSourceId();
    List<Movie> selectAllTrailer();
}
