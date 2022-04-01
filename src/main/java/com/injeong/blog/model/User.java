package com.injeong.blog.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결 된 DB의 넘버링 전략을 따라 감
    private int id;
    @Column(nullable = false, length = 30)
    private String userId;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 50)
    private String email;
    @ColumnDefault("'user'")
    private String role;
    @CreationTimestamp
    private Timestamp createDate;
}
