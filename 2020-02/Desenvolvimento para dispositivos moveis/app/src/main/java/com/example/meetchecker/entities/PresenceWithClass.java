package com.example.meetchecker.entities;

import androidx.room.Embedded;
import androidx.room.Relation;
import androidx.room.Transaction;

import java.util.List;

public class PresenceWithClass {
    @Embedded
    public Presence presence;

    @Relation(parentColumn = "classId", entityColumn = "guidId", entity = Class.class)
    public Class _class;
}
