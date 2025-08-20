package com.backend.portfolio.Models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_icons")
@NoArgsConstructor
public class UserIcons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;


    public UserIcons(String label, String url, User user) {
        this.label = label;
        this.url = url;
        this.user = user;
    }
}
