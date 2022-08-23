package java8;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * 8/16/22 15:29
 * aiguoxin 
 * 说明:
 */
public class StreamTest {

    class Library {
        public Book getBook() {
            return book;
        }

        public void setBook(Book book) {
            this.book = book;
        }

        Book book;

    }

    private class Book {
        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        Author author;
    }

    private class Author {
        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        int age;
    }

    @Test
    public void testLibrary() {
        List<Library> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Author author = new Author();
            author.setAge(20+i);
            Book book = new Book();
            book.setAuthor(author);
            Library library = new Library();
            library.setBook(book);
            list.add(library);
        }

       Integer count = list.stream()
                .map(book->book.getBook())
                .map(author->author.getAuthor())
                .filter(user->user.getAge() >= 50)
                .distinct()
                .limit(2)
                .map(Author::getAge)
               //用于统计总和
                .reduce(0,Integer::sum);
        System.out.println(count);
    }
}
