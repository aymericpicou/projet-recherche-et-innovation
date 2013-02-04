/**
 * 
 * @author Sebastian Hennebrueder
 * created Mar 15, 2006
 * copyright 2006 by http://www.laliluna.de
 */
package de.laliluna.library;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * @author hennebrueder
 * 
 */
@Entity
@Table(name="book")
@SequenceGenerator(name = "book_sequence", sequenceName = "book_id_seq")
@TableGenerator(  name="book_id", table="primary_keys", pkColumnName="key", pkColumnValue="book",
		valueColumnName="value")
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7422574264557894633L;

	private Integer id;

	private String title;

	private String author;

	public Book() {
		super();
	}

	public Book(Integer id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {

		return "Book: " + getId() + " Title " + getTitle() + " Author "
				+ getAuthor();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}