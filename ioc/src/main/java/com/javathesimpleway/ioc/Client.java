package com.javathesimpleway.ioc;

public class Client {

	public static void main(String[] args) {
		BookService service = Container.getBookServiceInstance();
		Book book = new Book(1,"Effective Java","Joshua Bloch");
		service.save(book);

	}

}
class Book{
private int bookId;
private String name;
private String author;
Book(int bookId,String name,String author){
this.bookId=bookId;
this.name=name;
this.author=author;
}
//getters & setters
}
interface BookService{
	public void save(Book book);
	public void delete(int bookId);
	public void update(Book book);
}

class BookServiceImpl implements BookService{
    private BookDAO bookDao = Container.getBookDaoInstance();
	@Override
	public void save(Book book) {
		bookDao.save(book);
		
	}

	@Override
	public void delete(int bookId) {
		// logic
		
	}

	@Override
	public void update(Book book) {
		// logic
		
	}
	
}

interface BookDAO{
	public void save(Book book);
	public void delete(int bookId);
	public void update(Book book);
}
class JdbcImpl implements BookDAO{

	@Override
	public void save(Book book) {
		// logic
		
	}

	@Override
	public void delete(int bookId) {
		// logic
		
	}

	@Override
	public void update(Book book) {
		// logic
		
	}
	
}

class HibernateDao implements BookDAO{

	@Override
	public void save(Book book) {
		System.out.println("Book is saving into the database");
		
	}

	@Override
	public void delete(int bookId) {
		// logic
		
	}

	@Override
	public void update(Book book) {
		// logic
		
	}
	
}

class Container{
	public static BookDAO getBookDaoInstance() {
		return new HibernateDao();
	}
	public static BookService getBookServiceInstance() {
		return new BookServiceImpl();
	}
}