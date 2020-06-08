package by.gstu.model.enities;

import java.io.Serializable;

public class Reader implements Serializable {

    private int id;
    private String name;
    private String surname;
    private String lastName;
    private int age;

    public Reader(int id, String name, String surname, String lastName, int age){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.age = age;
    }

    public Reader(String name, String surname, String lastName, int age){
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.age = age;
    }

    public Reader(){}

    public int getId(){return this.id;}
    public int getAge() {return this.age;}
    public String getName(){return this.name;}
    public String getSurname() {return this.surname;}
    public String getLastName() {return this.lastName;}

    public void setId(int id) throws IllegalArgumentException{
        if (id < 0){
            throw new IllegalArgumentException("Некорректный id");
        }
        this.id = id;
    }
    public void setName(String name) throws IllegalArgumentException{
        if (name.length() < 3){
            throw new IllegalArgumentException("Некорректное имя");
        }
        this.name = name;
    }
    public void setSurname(String surname) throws IllegalArgumentException{
        this.surname = surname;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setAge(int age) throws IllegalArgumentException{
        if (age < 0 || age > 100) throw new IllegalArgumentException("Некорректный возраст");
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        if (id != reader.id) return false;
        if (age != reader.age) return false;
        if (name != null ? !name.equals(reader.name) : reader.name != null) return false;
        if (surname != null ? !surname.equals(reader.surname) : reader.surname != null) return false;
        return lastName != null ? lastName.equals(reader.lastName) : reader.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
