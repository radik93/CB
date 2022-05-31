package ru.cb.demo.models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Table(name="ed201")
@Entity
public class ED201 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long edno;

   @Column(name = "edDate")
   private int edDate;
   @Column(name = "edAuthor")
   private int edAuthor;
   @Column(name = "edReceiver")
    private int edReceiver;
    @Column(name = "ctrlCode")
    private int ctrlCode;

   // @Column(name = "isRelevant")
   // private int isRelevant;

    public ED201(int edDate, int ctrlCode, ED243 ed243) {
        this.edDate = edDate;
        this.ctrlCode=ctrlCode;
        this.edAuthor=ed243.getEdAuthor();
        this.edReceiver=ed243.getEdReceiver();
    }
    public ED201(int edDate, int ctrlCode, ED244 ed244) {
        this.edDate = edDate;
        this.ctrlCode=ctrlCode;
        this.edAuthor=ed244.getEdAuthor();
        this.edReceiver=ed244.getEdReceiver();
    }
}
