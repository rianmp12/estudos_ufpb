package Interface;

import java.util.List;
import AllClass.ClassLibrary.Books;
import AllClass.ClassLibrary.Magazines;
import AllClass.ClassException.*;

public interface ManagementLibrary {

    boolean registerBook(Books prood) throws AlreadyExists;
    List<Books> researchBooks(String name) throws NotExistsException;
    List<Books> listTopBooks() throws NotExistsException;
    List<Magazines> listTopMagazines() throws NotExistsException;
    boolean registerMagazine(Magazines prod) throws AlreadyExists; 
    List<Magazines> researchMagazines(String name) throws NotExistsException;
    List<Magazines> searchMagazinesByGenrer(String genrer) throws NotExistsException;
    List<Books> searchBookByGenrer(String genrer) throws NotExistsException;
}
