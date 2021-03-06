package org.pharmacie.appecommerce.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

// equivalent à une table dans la base de donnée
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Category implements Serializable {
    @Id @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    @OneToMany (mappedBy = "category")
    @JsonManagedReference
    private Collection<Product> products;

}
