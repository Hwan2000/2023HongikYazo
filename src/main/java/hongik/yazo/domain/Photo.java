package hongik.yazo.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Photo {

    @Id
    @Column(name = "photo_url")
    private String url;

    @Column(name = "photo_meta")
    private Character meta;

    @Column(name = "photo_detail")
    private Integer detail;

    @ManyToOne
    @JoinColumn(name = "work_id")
    private Work work;
}
