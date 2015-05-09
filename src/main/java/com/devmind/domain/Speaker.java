package com.devmind.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Speaker {
    @GeneratedValue
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private String urlimage;
    private String url;
    @ManyToOne
    private Talk talk;

    public Talk getTalk() {
        return talk;
    }

    public Speaker setTalk(Talk talk) {
        this.talk = talk;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Speaker setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Speaker setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Speaker setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public Speaker setUrlimage(String urlimage) {
        this.urlimage = urlimage;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Speaker setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speaker speaker = (Speaker) o;

        if (firstname != null ? !firstname.equals(speaker.firstname) : speaker.firstname != null) return false;
        if (id != null ? !id.equals(speaker.id) : speaker.id != null) return false;
        if (lastname != null ? !lastname.equals(speaker.lastname) : speaker.lastname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}
