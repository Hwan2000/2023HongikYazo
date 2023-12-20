package hongik.yazo.service;

import hongik.yazo.domain.Photo;
import hongik.yazo.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@RequiredArgsConstructor
@Service
public class PhotoService {

    private final Map<Character, String> metaURL = new HashMap<Character, String>();

    @PostConstruct
    public void init(){
        metaURL.put('P',"https://i.postimg.cc");
        metaURL.put('C',"https://i.ibb.co");
    }

    private final PhotoRepository photoRepository;

    public String[] photoList(Integer workId){

        List<Photo> byWorkId = photoRepository.findByWorkId(workId);
        if(byWorkId.isEmpty()){
            return null;
        }

        String[] photoList = new String[byWorkId.size()];

        byWorkId.sort(Comparator.comparingInt(Photo::getDetail));

        int index = 0;
        for (Photo photo : byWorkId) {
            photoList[index++] = String.format("%s%s", metaURL.get(photo.getMeta()), photo.getUrl());
        }

        return photoList;
    }
}
