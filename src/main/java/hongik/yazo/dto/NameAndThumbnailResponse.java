package hongik.yazo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NameAndThumbnailResponse {
    private List<String> nameList;
    private List<String> titleList;
    private List<String> thumbnailList;
}
