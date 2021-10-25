public class Book {
    private  int id;
    private String bookName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public static void main(String[] args) {
        Book book = new Book();
        System.out.println(book.id);
    }
}
