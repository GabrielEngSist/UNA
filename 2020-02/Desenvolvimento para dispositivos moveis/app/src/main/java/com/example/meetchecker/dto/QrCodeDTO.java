package com.example.meetchecker.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class QrCodeDTO implements Serializable {
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getClassId() {
        return this.classId;
    }
    public void setClassId(String classId) {
        this.classId = classId;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getFinishDate() {
        return finishDate;
    }
    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }
    public void setSequenceNumber(Integer sequenceNumber) { this.sequenceNumber = sequenceNumber; }
    protected String id;
    protected String classId;
    protected String className;
    protected LocalDateTime startDate;
    protected LocalDateTime finishDate;
    protected Integer sequenceNumber;
}
