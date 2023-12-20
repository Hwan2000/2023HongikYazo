package hongik.yazo.service;

import hongik.yazo.domain.Movie;
import hongik.yazo.domain.Photo;
import hongik.yazo.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final Map<Character, String> metaURL = new HashMap<Character, String>();

    @PostConstruct
    public void init(){
        metaURL.put('V', "https://player.vimeo.com/video");
    }

    private final MovieRepository movieRepository;

    public String[] movieList(Integer workId){
        List<Movie> byWorkId = movieRepository.findByWorkId(workId);
        if(byWorkId.isEmpty()){
            return null;
        }

        String[] movieList = new String[byWorkId.size()];

        byWorkId.sort(Comparator.comparingInt(Movie::getDetail));

        int index = 0;
        for (Movie movie : byWorkId) {
            movieList[index++] = String.format("%s%s", metaURL.get(movie.getMeta()), movie.getUrl());
        }

        return movieList;
    }
}
