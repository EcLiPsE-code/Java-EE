package models.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="readerId")
    private int readerId;
    @Column(name="bookId")
    private int bookId;
    @Column(name="dateOfIssue")
    private LocalDate dateOfIssue; //дата выдачи книги
    @Column(name="countDay")
    private int countDay; //количество дней на которое выдана книга
    @Column(name="dateOfCompletion")
    private LocalDate dateOfCompletion; //дата сдачи книги
    @Column(name="typeOfIssue")
    private Boolean typeOfIssue; //тип выдачи(true - абонемент, false - читальный зал)

    public Order(int id, int readerId, int bookId, LocalDate dateOfIssue, int countDay, LocalDate dateOfCompletion, Boolean typeOfIssue) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.dateOfIssue = dateOfIssue;
        this.countDay = countDay;
        this.dateOfCompletion = dateOfCompletion;
        this.typeOfIssue = typeOfIssue;
        this.id = id;
    }

    public Order(int readerId, int bookId, LocalDate dateOfIssue, int countDay, LocalDate dateOfCompletion, Boolean typeOfIssue) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.dateOfIssue = dateOfIssue;
        this.countDay = countDay;
        this.dateOfCompletion = dateOfCompletion;
        this.typeOfIssue = typeOfIssue;
    }

    public Order() {
    }

    public void setId(int id) throws IllegalArgumentException{
        if (id < 0){
            throw new IllegalArgumentException("Uncorrect order id");
        }
        this.id = id;
    }
    public void setReaderId(int id) throws IllegalArgumentException{
        if (id < 0){
            throw new IllegalArgumentException("Uncorrect reader id");
        }
        this.readerId = id;
    }
    public void setBookId(int id) throws IllegalArgumentException{
        if (id < 0){
            throw new IllegalArgumentException("Uncorrect book id");
        }
        this.bookId = id;
    }
    public void setDateOfIssue(LocalDate dateOfIssue){
        this.dateOfIssue = dateOfIssue;
    }
    public void setCountDay(int countDay) throws IllegalArgumentException{
        if (countDay < 0){
            throw new IllegalArgumentException("Uncorrect count day");
        }
        this.countDay = countDay;
    }
    public void setDateOfCompletion(LocalDate dateOfCompletion){
        this.dateOfCompletion = dateOfCompletion;
    }
    public void setTypeOfIssue(boolean typeOfIssue){
        this.typeOfIssue = typeOfIssue;
    }

    public int getId(){return this.id;}
    public int getReaderId(){return this.readerId;}
    public int getBookId(){return this.bookId;}
    public int getCountDay(){return this.countDay;}
    public LocalDate getDateOfIssue(){return this.dateOfIssue;}
    public LocalDate getDateOfCompletion(){return this.dateOfCompletion;}
    public boolean getTypeOfIssue(){return this.typeOfIssue;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (readerId != order.readerId) return false;
        if (bookId != order.bookId) return false;
        if (countDay != order.countDay) return false;
        if (dateOfIssue != null ? !dateOfIssue.equals(order.dateOfIssue) : order.dateOfIssue != null) return false;
        if (dateOfCompletion != null ? !dateOfCompletion.equals(order.dateOfCompletion) : order.dateOfCompletion != null)
            return false;
        return typeOfIssue != null ? typeOfIssue.equals(order.typeOfIssue) : order.typeOfIssue == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + readerId;
        result = 31 * result + bookId;
        result = 31 * result + (dateOfIssue != null ? dateOfIssue.hashCode() : 0);
        result = 31 * result + countDay;
        result = 31 * result + (dateOfCompletion != null ? dateOfCompletion.hashCode() : 0);
        result = 31 * result + (typeOfIssue != null ? typeOfIssue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", readerId=" + readerId +
                ", bookId=" + bookId +
                ", dateOfIssue=" + dateOfIssue +
                ", countDay=" + countDay +
                ", dateOfCompletion=" + dateOfCompletion +
                ", typeOfIssue=" + typeOfIssue +
                '}';
    }
}
