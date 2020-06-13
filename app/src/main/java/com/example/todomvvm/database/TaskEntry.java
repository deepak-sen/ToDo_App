package com.example.todomvvm.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "task")
public class TaskEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String description;
    private int priority;


    private String taskd, taskt;
    @ColumnInfo(name="updated_at")
    private Date updatedAt;

    @Ignore
    public TaskEntry(String description, int priority, String taskd, String taskt, Date updatedAt) {
        this.description = description;
        this.priority = priority;
        this.taskd = taskd;
        this.taskt = taskt;
        this.updatedAt = updatedAt;

    }

    public TaskEntry(int id, String description, int priority, String taskd, String taskt, Date updatedAt) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.taskd = taskd;
        this.taskt = taskt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTaskd() {
        return taskd;
    }

    public void setTaskd(String taskd) {
        this.taskd = taskd;
    }

    public String getTaskt() {
        return taskt;
    }

    public void setTaskt(String taskt) {
        this.taskt = taskt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
