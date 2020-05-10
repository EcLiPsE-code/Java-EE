package models.entities;

import javax.persistence.*;


@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "countPages")
    private int countPages;
    @Column(name = "countCopies")
    private int countCopies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderId")
    private Order order;

    public Book(){}
    public Book(String name, String author, int countPages, int countCopies){
        this.name = name;
        this.author = author;
        this.countPages = countPages;
        this.countCopies = countCopies;
    }

    public void setId(int id) throws IllegalArgumentException{
        if (id < 0){
            throw new IllegalArgumentException("Uncorrect book id");
        }
        this.id = id;
    }
    public void setName(String name) throws IllegalArgumentException{
        if (name.length() < 2){
            throw new IllegalArgumentException("Uncorrect name book");
        }
        this.name = name;
    }
    public void setAuthor(String author){
        if (author.length() < 2){
            throw new IllegalArgumentException("Uncorrect author book");
        }
    }
    public void setCountPages(int countPages) throws IllegalArgumentException{
        if (countPages < 0){
            throw new IllegalArgumentException("Uncorrect count pages in the book");
        }
    }
    public void setCountCopies(int countCopies) throws IllegalArgumentException{
        if (countCopies < 0){
            throw new IllegalArgumentException("Uncorrect count copies book");
        }
    }
    public void setOrder(Order order){
        this.order = order;
    }

    public int getId(){return this.id;}
    public int getCountCopies(){return this.countCopies;}
    public int getCountPages(){return this.countPages;}
    public String getName(){return this.name;}
    public String getAuthor(){return this.author;}
    public Order getOrder(){return this.order;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (countPages != book.countPages) return false;
        if (countCopies != book.countCopies) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        return author != null ? author.equals(book.author) : book.author == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + countPages;
        result = 31 * result + countCopies;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", countPages=" + countPages +
                ", countCopies=" + countCopies +
                '}';
    }
}
