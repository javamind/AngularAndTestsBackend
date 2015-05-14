package com.devmind.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
public class Interest {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String url;
    @ManyToOne
    private Talk talk;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Talk getTalk() {
        return talk;
    }

    public Interest setTalk(Talk talk) {
        this.talk = talk;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Interest setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Interest setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interest interest = (Interest) o;

        if (!id.equals(interest.id)) return false;
        if (!name.equals(interest.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
