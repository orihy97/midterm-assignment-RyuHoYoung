package com.ohgiraffers.midtermassignmentryuhoyoung;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class BoardDTO {
    private String id;
    private String title;
    private String content;

    private String singleFileDescription;
    public BoardDTO(){}
    public BoardDTO(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSingleFileDescription(String singleFileDescription) {
        this.singleFileDescription = singleFileDescription;
    }

    public String getSingleFileDescription() {
        return singleFileDescription;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", singleFileDescription='" + singleFileDescription + '\'' +
                '}';
    }
}
