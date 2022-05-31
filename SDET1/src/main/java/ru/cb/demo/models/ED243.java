package ru.cb.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Table(name="ed243")
@Entity
public class ED243 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long edno;

    @Column(name = "edDate")
    private int edDate;
    @Column(name = "edAuthor")
    private int edAuthor;
    @Column(name = "edReceiver")
    private int edReceiver;
    @Column(name = "requestCode")
    private int requestCode;

    @Column(name = "anAnswer")
    private boolean anAnswer;

    public ED243(int edDate, int edAuthor, int edReceiver, int requestCode, boolean AnAnswer) {
        this.edDate      = edDate;
        this.edAuthor    = edAuthor;
        this.edReceiver  = edReceiver;
        this.requestCode = requestCode;
        this.anAnswer  =   anAnswer;
    }

    public ED243() {

    }
}
