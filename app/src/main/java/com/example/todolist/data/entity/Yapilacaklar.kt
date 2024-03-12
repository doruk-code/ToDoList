package com.example.todolist.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable


@Entity(tableName = "todolist")
data class Yapilacaklar(@PrimaryKey(autoGenerate = true)
            @ColumnInfo(name = "todo_id") @NotNull var todo_id: Int,
            @ColumnInfo(name = "todo_text") @NotNull var todo_text: String) : Serializable {




}