package models.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="dateOfIssue")
    private Date dateOfIssue; //дата выдачи книги
    @Column(name="countDay")
    private int countDay; //количество дней на которое выдана книга
    @Column(name="dateOfCompletion")
    private Date dateOfCompletion; //дата сдачи книги
    @Column(name="typeOfIssue")
    private Boolean typeOfIssue; //тип выдачи(true - абонемент, false - читальный зал)

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "readerId")
    private Reader reader;

    public Order(Date dateOfIssue, int countDay, Date dateOfCompletion, Boolean typeOfIssue){
        this.dateOfIssue = dateOfIssue;
        this.countDay = countDay;
        this.dateOfCompletion = dateOfCompletion;
        this.typeOfIssue = typeOfIssue;
        this.books = new ArrayList<Book>();
    }

    public Order(Date dateOfIssue, int countDay, Date dateOfCompletion, Boolean typeOfIssue, Reader reader, Book book) {
        this.dateOfIssue = dateOfIssue;
        this.countDay = countDay;
        this.dateOfCompletion = dateOfCompletion;
        this.typeOfIssue = typeOfIssue;
        this.books = new ArrayList<Book>();
        setReader(reader);
        addBook(book);
    }

    public Order() {
        this.books = new ArrayList<Book>();
    }

    public void setId(int id) throws IllegalArgumentException{
        if (id < 0){
            throw new IllegalArgumentException("Uncorrect order id");
        }
        this.id = id;
    }
    public void setDateOfIssue(Date dateOfIssue){
        this.dateOfIssue = dateOfIssue;
    }
    public void setCountDay(int countDay) throws IllegalArgumentException{
        if (countDay < 0){
            throw new IllegalArgumentException("Uncorrect count day");
        }
        this.countDay = countDay;
    }
    public void setDateOfCompletion(Date dateOfCompletion){
        this.dateOfCompletion = dateOfCompletion;
    }
    public void setTypeOfIssue(boolean typeOfIssue){
        this.typeOfIssue = typeOfIssue;
    }


    public int getId(){return this.id;}
    public int getCountDay(){return this.countDay;}
    public Date getDateOfIssue(){return this.dateOfIssue;}
    public Date getDateOfCompletion(){return this.dateOfCompletion;}
    public boolean getTypeOfIssue(){return this.typeOfIssue;}

    public void addBook(Book book){
        book.setOrder(this);
        this.books.add(book);
    }
    public void removeBook(Book book){
        this.books.remove(book);
    }
    public List<Book> getBooks(){
        return this.books;
    }
    public void setBooks(List<Book> books){
        this.books = books;
    }

    public void setReader(Reader reader){
        this.reader = reader;
    }
    public Reader getReader(){return this.reader;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (countDay != order.countDay) return false;
        if (dateOfIssue != null ? !dateOfIssue.equals(order.dateOfIssue) : order.dateOfIssue != null) return false;
        if (dateOfCompletion != null ? !dateOfCompletion.equals(order.dateOfCompletion) : order.dateOfCompletion != null)
            return false;
        return typeOfIssue != null ? typeOfIssue.equals(order.typeOfIssue) : order.typeOfIssue == null;
    }

    @Override
    public int hashCode() {
        int result = id;
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
                ", dateOfIssue=" + dateOfIssue +
                ", countDay=" + countDay +
                ", dateOfCompletion=" + dateOfCompletion +
                ", typeOfIssue=" + typeOfIssue +
                ", books=" + books +
                ", reader=" + reader +
                '}';
    }
}
