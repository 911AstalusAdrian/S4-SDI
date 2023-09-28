package ro.ubb.xml;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            var documentBuilder = documentBuilderFactory.newDocumentBuilder();
            var document = documentBuilder.parse("./data/bookstore.xml");
            var documentRoot = document.getDocumentElement();

            var bookList = getBookList(documentRoot);
            for (var book : bookList) {
                System.out.println(book);
            }


            addBookToXML();

            //System.out.println(document.getDocumentElement().getTagName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addBookToXML() {
        var book = new Book("t1", "c1", "a1", 1990, 20.01f);

        try {
            var documentBuilderFactory = DocumentBuilderFactory.newInstance();
            var documentBuilder = documentBuilderFactory.newDocumentBuilder();
            var document = documentBuilder.parse("./data/bookstore.xml");
            var documentRoot = document.getDocumentElement();

            var bookElement = document.createElement("book");
            documentRoot.appendChild(bookElement);
            bookElement.setAttribute("category", book.getCategory());

            // title
            Element titleElement = document.createElement("title");
            titleElement.setTextContent(book.getTitle());
            bookElement.appendChild(titleElement);

            // author
            Element authorElement = document.createElement("author");
            authorElement.setTextContent(book.getAuthor());
            bookElement.appendChild(authorElement);

            // year
            Element yearElement = document.createElement("year");
            yearElement.setTextContent(Integer.toString(book.getYear()));
            bookElement.appendChild(yearElement);

            // price
            Element priceElement = document.createElement("price");
            priceElement.setTextContent(Float.toString(book.getPrice()));
            bookElement.appendChild(priceElement);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream("./data/bookstore2.xml")));

        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static List<Book> getBookList(Element documentRoot) {
        var nodeList = documentRoot.getChildNodes();

        var bookList = new ArrayList<Book>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            var node = nodeList.item(i);
            if (node instanceof Element) {
                var bookElement = (Element) node;
                var category = bookElement.getAttribute("category");

                var title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                var author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                var year = Integer.parseInt(
                        bookElement.getElementsByTagName("year").item(0).getTextContent());
                var price = Float.parseFloat(
                        bookElement.getElementsByTagName("price").item(0).getTextContent());

                bookList.add(new Book(title, category, author, year, price));
            }

        }
        return bookList;
    }
}
