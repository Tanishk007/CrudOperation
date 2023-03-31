package com.Testing.CrudOperations1.Repository;

import java.awt.print.Book;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Testing.CrudOperations1.Modal.Books;



@Repository
public interface BooksRepository extends CrudRepository<Books,Integer> {
	

    @Query(value="SELECT *  FROM books u WHERE u.bookname=?1", nativeQuery =true)
	public List<Books> getnamess(String name);
    
    @Query(value="SELECT *  FROM books u WHERE u.bookid=?1", nativeQuery =true)
	public List<Books> getids(int id);
    
    @Query(value="SELECT * FROM books u WHERE u.price=?1",nativeQuery=true)
    public List<Books> getbookprice(int price);

	

}

