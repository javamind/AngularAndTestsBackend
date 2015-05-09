package com.devmind.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Talk {
    @GeneratedValue
    @Id
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String summary;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String language;
    @Column(columnDefinition = "TEXT")
    private String ideaForNow;
    private String format;
    private String level;
    private String start;
    private String end;
    private String room;
    @OneToMany(targetEntity=Speaker.class, mappedBy="talk")
    private List<Speaker> speakers = new ArrayList<>();
    @OneToMany(targetEntity=Interest.class, mappedBy="talk")
    private List<Interest> interests= new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Talk setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Talk setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Talk setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Talk setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Talk setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getIdeaForNow() {
        return ideaForNow;
    }

    public Talk setIdeaForNow(String ideaForNow) {
        this.ideaForNow = ideaForNow;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public Talk setFormat(String format) {
        this.format = format;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public Talk setLevel(String level) {
        this.level = level;
        return this;
    }

    public String getStart() {
        return start;
    }

    public Talk setStart(String start) {
        this.start = start;
        return this;
    }

    public String getEnd() {
        return end;
    }

    public Talk setEnd(String end) {
        this.end = end;
        return this;
    }

    public String getRoom() {
        return room;
    }

    public Talk setRoom(String room) {
        this.room = room;
        return this;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public Talk addSpeaker(Speaker speaker) {
        this.speakers.add(speaker);
        speaker.setTalk(this);
        return this;
    }

    public Talk clearSpeakers() {
        this.speakers.clear();
        return this;
    }

    public Talk addAllSpeakers(List<Speaker> speakers) {
        for(Speaker speaker : speakers){
            addSpeaker(speaker);
        }
        return this;
    }

    public Talk removeSpeaker(Speaker speaker) {
        this.speakers.remove(speaker);
        return this;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public Talk addInterest(Interest interest) {
        this.interests.add(interest);
        interest.setTalk(this);
        return this;
    }
    public Talk clearInterests() {
        this.interests.clear();
        return this;
    }

    public Talk addAllInterests(List<Interest> interests) {
        for(Interest interest : interests){
            addInterest(interest);
        }
        return this;
    }
    public Talk removeInterest(Interest interest) {
        this.interests.remove(interest);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Talk talk = (Talk) o;

        if (id != null ? !id.equals(talk.id) : talk.id != null) return false;
        if (interests != null ? !interests.equals(talk.interests) : talk.interests != null) return false;
        if (title != null ? !title.equals(talk.title) : talk.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
