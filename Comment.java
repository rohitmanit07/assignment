package ImageHoster.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {

    @Column(name = "id")
    private Integer id;

    private String text;

    @Column(name = "date")
    private Date createdDate;

    @ManyToOne(fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'images' table referring the primary key in 'users' table will be 'user_id'
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();


}
