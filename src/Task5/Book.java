package Task5;

import Helpers.Helpers;

public class Book {
    private int pages;
    private int releaseYear;
    private Author author;
    private String title;
    private String genre;
    private String publisher;

    public Book(int pages, int releaseYear, Author author, String title, String genre, String publisher) {
        this.pages = pages;
        this.releaseYear = releaseYear;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
    }
    public Book() {
        this(0, 0, null, null, null, null);
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void fillInfo() {
        setTitle(Helpers.getStringInputByLength("\n Enter title: ", 5));
        setGenre(Helpers.getStringInputByLength("\n Enter genre: ", 4));
        setPublisher(Helpers.getStringInputByLength("\n Enter publisher: ", 4));

        setAuthor(Author.getAuthorBio());

        setPages(Helpers.getIntegerInput("\n Enter amount of pages: "));
        setReleaseYear(Helpers.getIntegerInput("\n Enter release year: "));
    }

    @Override
    public String toString() {
        return String.format("\n Book title: %s\n Genre: %s\n Author: %s\n Publisher: %s\n Pages: %s\n Publish year: %s\n",
                getTitle(),
                getGenre(),
                getAuthor(),
                getPublisher(),
                getPages(),
                getReleaseYear());
    }
}
