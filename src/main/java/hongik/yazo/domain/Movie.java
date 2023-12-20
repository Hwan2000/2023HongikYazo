package hongik.yazo.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Movie {

    @Id
    @Column(name = "movie_url")
    private String url;

    @Column(name = "movie_meta")
    private Character meta;

    @Column(name = "movie_detail")
    private Integer detail;

    @ManyToOne
    @JoinColumn(name = "work_id")
    private Work work;
}
