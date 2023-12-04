package hongik.yazo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Getter
public class Work {

    @Id
    @Column(name = "work_id")
    private Integer id;

    @Column(name = "work_artist")
    private String name;

    @Column(name = "work_title")
    private String title;

    @Column(name = "work_ingredient")
    private String ingredient;

    @Column(name = "work_size")
    private String size;

    @Column(name = "work_text", columnDefinition = "TEXT")
    private String text;
}
