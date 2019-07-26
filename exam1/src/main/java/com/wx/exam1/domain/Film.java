package com.wx.exam1.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
@Repository
@Table(name = "film")
public class Film implements Serializable {
    private static final long serialVersionUID = -198962343409447L;
    @Id
    @GeneratedValue
    private Short film_id;
    @NotBlank(message = "电影title不能为空")
    private String title;
    private String description;
    private Short language_id;

    public Short getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Short film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(Short language_id) {
        this.language_id = language_id;
    }
}
