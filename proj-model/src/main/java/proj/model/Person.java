package proj.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 8434078050474862363L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,
            unique = true,
            updatable = false)
    private Long id;
    @Column(length = 100,nullable = false)
    private String name;

    public Long getId(){return this.id;}
    public String getName(){return this.name;}
    public void setId(final Long id){this.id = id;}
    public void setName(final String name){this.name = name;}
}