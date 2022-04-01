package com.injeong.blog.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    private String title;
    @Lob
    private String content;
    @ColumnDefault("0")
    private int count;

    @ManyToOne(fetch = FetchType.EAGER) //many = board, user = one 하나의 유저는 여러개의 게시글을 작성 할 수 있다.
    //ManyToOne의 기본 전략은 FetchType.EAGER => user가 하나만 있으니까 무조건 들거온다.
    @JoinColumn(name="userId")
    private User user; //DB는 object 저장 불가, FK, 자바는 object 저장 가능 -> 충돌

    //oneToMany의 기본 전략은 FetchType.LAZY => 상황에 따라 달라짐
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //mappedBy = 연관관계의 주인이 아니다(FK가 아니다) -> DB에 컬럼을 만들지 않음
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;

}
