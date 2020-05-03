package extend;

import java.time.LocalDate;

public class tag_columns {
	
		private String isbn13;
		private String tag_names;
		private String title;
		private String author;
		private LocalDate publishDate;	// Date of publish to the website
		
		private double price;
		
		private byte[] content;
		
		// Constructor used when no date is specified
		public tag_columns(String isbn, String title, String author, byte[] content) {
			this.isbn13 = isbn;
			this.title = title;
			this.author = author;
			this.publishDate = LocalDate.now();
			this.content = content;
		}
		
		// Constructor used when a date is specified
		public tag_columns(String isbn, String title, String author, byte[] content, LocalDate publishDate) {
			this.isbn13 = isbn;
			this.title = title;
			this.author = author;
			this.publishDate = publishDate;
			this.content = content;
		}
		
		
		// Default Constructor
		public tag_columns() {
			this.isbn13 = null;
			this.title = null;
			this.author = null;
			this.tag_names = null;
			this.publishDate = LocalDate.now();
			this.content = null;
		}
		
		public String getTag_names() {
			return tag_names;
		}
		public void setTagnames(String tag_names) {
			this.tag_names = tag_names;
		}
		
		public String getIsbn13() {
			return isbn13;
		}

		public void setIsbn13(String isbn13) {
			this.isbn13 = isbn13;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public LocalDate getPublishDate() {
			return publishDate;
		}

		public void setPublishDate(LocalDate publishDate) {
			this.publishDate = publishDate;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public byte[] getContent() {
			return content;
		}

		public void setContent(byte[] content) {
			this.content = content;
		}
		
		
	}


