package com.ifortex.bookservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import com.ifortex.bookservice.model.Book;

public class BookRepository {

    @Autowired
    private EntityManger entityManager;

    public getBooksCountByGenre() {

        String sql = "SELECT genre, COUNT(*) as count FROM books GROUP BY genre";
        Query query = em.createNativeQuery(sql);
        rs = query.getResultList();


        Map<String, Long> books = new Map <Book>();

        while(rs.next()) {
           Book book = new Book();
           book.setBookdId(rs.getString("BookId"));
           book.setTitle(rs.getString("title"));
           book.setDescription(rs.getString("description"));
           book.setAuthor(rs.getString("author"));
           book.setGenre(rs.getString("genre"));
           books.add(book);
        }

        return books;
    }

    public getBooksByCriteria(searchCriteria) {
        String sql = "SELECT * FROM books
                      WHERE title like '% . searchCriteria .%'
                        OR description like '% . searchCriteria .%'
                        OR author like '% . searchCriteria .%'
                        OR genre like '% . searchCriteria .%'
                        ORDER BY publication_date";
        Query query = em.createNativeQuery(sql);

        rs = query.getResultList();


        List<Book> books = new ArrayList<Book>();

        while(rs.next()) {
            Book book = new Book();
            book.setBookdId(rs.getString("BookId"));
            book.setTitle(rs.getString("title"));
            book.setDescription(rs.getString("description"));
            book.setAuthor(rs.getString("author"));
            book.setGenre(rs.getString("genre"));
            books.add(book);
        }

        return books;
    }

    public getAllBooks() {
         String sql = "SELECT * FROM books ORDER BY publication_date";
         Query query = em.createNativeQuery(sql);
         rs =  query.getResultList();

         List<Book> books = new ArrayList<Book>();

                while(rs.next()) {
                    Book book = new Book();
                    book.setBookdId(rs.getString("BookId"));
                    book.setTitle(rs.getString("title"));
                    book.setDescription(rs.getString("description"));
                    book.setAuthor(rs.getString("author"));
                    book.setGenre(rs.getString("genre"));
                    books.add(book);
                }

        return books;

    }

}