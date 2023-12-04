package hongik.yazo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private String name;
    private String title;
    private String ing;
    private String size;
    private String text;
    private String[] photoList;
    private String[] movieList;
}
