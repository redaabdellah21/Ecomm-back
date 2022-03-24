package org.pharmacie.appecommerce.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

// equivalent à une table dans la base de donnée
@Data
@Entity
public class Employee  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String Phone;
    private String photoName;
}