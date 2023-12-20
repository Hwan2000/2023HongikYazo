package hongik.yazo.service;

import hongik.yazo.domain.Photo;
import hongik.yazo.repository.PhotoRepository;
import hongik.yazo.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PhotoService {

    private final Map<Character, String> metaURL = new HashMap<Character, String>();

    @PostConstruct
    public void init(){
        metaURL.put('P',"https://i.postimg.cc");
        metaURL.put('I',"https://i.ibb.co");
    }

    private final PhotoRepository photoRepository;
    private final WorkRepository workRepository;

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

    public List<String> thumbnailList() {
        List<Photo> findThumbnail = photoRepository.findByDetail(1);

        findThumbnail.sort(Comparator.comparing(photo -> photo.getWork().getId()));

        long count = workRepository.count();

        String[] thumbnailArray = new String[(int) count];

        for(Photo photo : findThumbnail){
            thumbnailArray[photo.getWork().getId()-1] = String.format("%s%s", metaURL.get(photo.getMeta()), photo.getUrl());
        }

        return Arrays.asList(thumbnailArray);

//        return findThumbnail.stream()
//                .map(photo -> String.format("%s%s", metaURL.get(photo.getMeta()), photo.getUrl()))
//                .collect(Collectors.toList());
    }
}
