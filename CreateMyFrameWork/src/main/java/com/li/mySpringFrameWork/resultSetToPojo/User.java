package com.li.mySpringFrameWork.resultSetToPojo;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * <pre name="code" class="java">
 */
@Entity
public class User {
    @Column(name="uid")
    private int id;
    @Column(name="username")
    private String name;
    @Column(name="password")
    private String password;
    @Column(name="description")
    private String desc;
    @Column(name="roles")
    private String roles;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", desc='" + desc + '\'' +
                ", roles='" + roles + '\'' +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
