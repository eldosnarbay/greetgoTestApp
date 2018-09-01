package kz.eldos.eSchoolGreetgo.model;

import java.util.Objects;

public class Class {
    /*
     * Fields
     */
    private Integer id;
    private String name;

    /*
     * Entity basics
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Class)) return false;
        Class aClass = (Class) o;
        return Objects.equals(getId(), aClass.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    /*
     * Getters &setters
     */
    public Integer getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
