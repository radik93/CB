package ru.cb.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Table(name="ed244")
@Entity
public class ED244 {

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
    @Column(name = "EDDefineRequestCode")
    private int EDDefineRequestCode;

    @OneToMany(targetEntity=ED108.class,
            fetch = FetchType.EAGER)
    @JoinColumn(name="ed244_edho")
    private List<ED108> ED108s;

    public ED244(int edDate, int EDDefineRequestCode, ED243 ed243) {
        this.edDate              = edDate;
        this.EDDefineRequestCode = EDDefineRequestCode;
        this.requestCode         = ed243.getRequestCode();
        this.edAuthor            = ed243.getEdAuthor();
        this.edReceiver          = ed243.getEdReceiver();
    }

    public ED244(int edDate, int EDDefineRequestCode, int edReceiver, int edAuthor) {
        this.edDate              = edDate;
        this.edAuthor            = edAuthor;
        this.EDDefineRequestCode = EDDefineRequestCode;
        this.edReceiver          = edReceiver;
    }

    public ED244() {

    }
}
