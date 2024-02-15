
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import config.FactoryConfiguration;
import entity.*;

import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

/*        Author jak=new Author("A1","jak","India",null);
        Author jeny=new Author("A2","jeny","Australia",null);
        Author Nowly=new Author("A3","Nowly","England",null);
        Author josh=new Author("A4","josh","USA",null);
        Author Mog=new Author("A5","Mog","Japan",null);


        Book book1=new Book("B1","Java",2022,1000.0,jak);
        Book book2=new Book("B2","Python",2010,2000.0,jeny);
        Book book3=new Book("B3","C++",2020,3000.0,jak);
        Book book4=new Book("B4","C#",2021,4000.0,josh);
        Book book5=new Book("B5","C",2005,5000.0,Nowly);


        List<Book> books=List.of(book1,book3);
        jak.setBooks(books);
        jeny.setBooks(List.of(book2));
        josh.setBooks(List.of(book4));
        Nowly.setBooks(List.of(book5));

        session.save(jak);
        session.save(jeny);
        session.save(josh);
        session.save(Nowly);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);*/

        // (01)

   /*     Query query=session.createQuery("select tittle from Book where publishYear>=2010");
        List result=query.getResultList();
        System.out.println(result.toString());*/

        //(02)
/*        Query query= session.createQuery("update Book b set b.price=b.price*1.1 where b.author.id=:authorId");
        query.setParameter("authorId","A1");
        int result= query.executeUpdate();
        System.out.println("Result: "+result);*/

        //(03)

        //(04)

    /*    Query query= session.createQuery("select avg (price) from Book");
         Double avg= (Double) query.getSingleResult();
        System.out.println(avg);*/

        //(05)

      /*  Query query= session.createQuery("select a.id,count (b.id)from Author a join Book b on a.id=b.author.id group by a.id");
        List<Object[]> result=query.getResultList();
        for (Object[] objects : result) {
            System.out.println(objects[0]+" "+objects[1]);
        }*/

        //(06)

/*        Query query= session.createQuery("select b.tittle from Book b join Author a on b.author.id=a.id where a.country=:countryName");
        query.setParameter("countryName","India");
        List result=query.getResultList();
        for (Object o : result) {
            System.out.println(o);
        }*/


        //(07)


        //(10)

        Query query = session.createQuery("SELECT a.name FROM Author a WHERE ( SELECT COUNT(b.id) FROM Book b WHERE a.id = b.author.id ) > ( SELECT AVG(authorBookCount) FROM ( SELECT COUNT(b.id) AS authorBookCount FROM Book b GROUP BY b.author.id ))");
        List<String> resultList = query.getResultList();

        for (String s : resultList) {
            System.out.println(s);
        }


        transaction.commit();
        session.close();
    }
}
