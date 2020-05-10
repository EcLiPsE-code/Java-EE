package models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="readers")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="lastName")
    private String lastName;
    @Column(name="age")
    private int age;

    @OneToMany(mappedBy = "reader", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    public Reader(String name, String surname, String lastName, int age) {
        this.lastName = lastName;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Reader() {

    }

    public void setId(int id) throws IllegalArgumentException{
        if (id < 0){
            throw new IllegalArgumentException("Uncorrect reader id");
        }
        this.id = id;
    }
    public void setName(String name) throws IllegalArgumentException{
        if (name.length() < 2){
            throw new IllegalArgumentException("Uncorrect name reader");
        }
        this.name = name;
    }
    public void setLastName(String lastName) throws IllegalArgumentException{
        if (lastName.length() < 3){
            throw new IllegalArgumentException("Uncorrect reader lastName");
        }
        this.lastName = lastName;
    }
    public void setSurname(String surname) throws IllegalArgumentException{
        if (surname.length() < 3){
            throw new IllegalArgumentException("Uncorrect surname reader");
        }
        this.surname = surname;
    }
    public void setAge(int age) throws IllegalArgumentException{
        if (age < 0){
            throw new IllegalArgumentException("Uncorrect reader age");
        }
        this.age = age;
    }

    public int getId(){return this.id;}
    public int getAge(){return this.age;}
    public String getName(){return this.name;}
    public String getLastName(){return this.lastName;}
    public String getSurname(){return this.surname;}

    public void addOrder(Order order){
        order.setReader(this);
        orders.add(order);
    }
    public void setOrders(List<Order> orders){
        this.orders = orders;
    }
    public List<Order> getOrders(){return this.orders;}

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
