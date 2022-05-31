package ru.cb.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name="ed108")
@Entity
public class ED108 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ecno")
    private int ecno;

    @Column(name = "INN")
    private int INN;
    @Column(name = "PS")
    private int PS;
    @Column(name = "BIK")
    private int BIK;

    @Column(name = "SUM")
    private int SUM;

    @ManyToOne(targetEntity=ED244.class)
    @JoinColumn(name="ed244_edho")
    ED244 ed244;

    public ED108() {

    }

    public ED108(int ecno,int BIK, int INN, int PS, int SUM) {
        this.ecno = ecno;
        this.BIK = BIK;
        this.INN = INN;
        this.PS = PS;
        this.SUM = SUM;
    }
}
