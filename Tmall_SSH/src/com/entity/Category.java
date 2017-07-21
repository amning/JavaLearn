package com.entity;

import javax.persistence.*;

/**
 * Created by 王宁 on 2017/7/21.
 * 准备Category实体类，并用Hibernate注解标示其对应的表，字段等信息。
 *  这里采用的是注解方式配置Hibernate需要的信息
 */

@Entity
@Table(name = "category")
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
int id;

String name;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
