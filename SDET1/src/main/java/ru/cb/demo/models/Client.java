package ru.cb.demo.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Table(name="clients")
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

      @Column(name = "name")
      private String name;
      @Column(name = "INN")
      private int INN;
      @Column(name = "PS")
      private int PS;
      @Column(name = "BIK")
      private int BIK;
      @Column(name = "edReceiver")
      private int edReceiver;

      public Client(String name, int INN, int PS, int BIK, int edReceiver) {
          this.name = name;
          this.INN = INN;
          this.BIK=BIK;
          this.edReceiver=edReceiver;
      }

      public Client() {

      }
}
