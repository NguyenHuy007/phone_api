package com.example.phone.models;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String module_name;
    @Column
    private Integer year_manufacture;

    public Phone(){
        super();
    }

    public Phone(long id, String name, String module_name, Integer year_manufacture) {
        super();
        this.id = id;
        this.name = name;
        this.module_name = module_name;
        this.year_manufacture = year_manufacture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public Integer getYear_manufacture() {
        return year_manufacture;
    }

    public void setYear_manufacture(Integer year_manufacture) {
        this.year_manufacture = year_manufacture;
    }
}
