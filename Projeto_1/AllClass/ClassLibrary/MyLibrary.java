package AllClass.ClassLibrary;

import java.util.ArrayList;
import java.util.List;
import Interface.*;
import AllClass.ClassException.*;

public class MyLibrary implements ManagementLibrary{

    private String name;
    private String address;
    private String cnpj;
    private List<Books> books = new ArrayList<>();
    private List<Magazines> magazines = new ArrayList<>();

    public MyLibrary (String name, String address, String cnpj, List<Books> newBooks, List<Magazines> newMagazines) {
        this.name = name;
        this.address = address;
        this.cnpj = cnpj;
        this.books = newBooks;
        this.magazines = newMagazines;
    }

    public MyLibrary() {
        this("S.nome", "S.Endereço", "XXXX", new ArrayList<Books>(), new ArrayList<Magazines>());
    }

    public List<Books> getBooks() throws NotExistsException{
        if(this.books.size() == 0) {
            throw new NotExistsException("Lista vazia.");
        }
        return this.books;
    }

    public void setBooks(ArrayList<Books> books) {
        this.books = books;
    }

    public List<Magazines> getMagazines() throws NotExistsException{
        if(this.magazines.size() == 0) {
            throw new NotExistsException("Lista vazia.");
        }
        return this.magazines;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public String getCNPJ() {
        return this.cnpj;
    }

    public void setCNPJ(String newCNPJ) {
        this.cnpj = newCNPJ;
    }

    @Override
    public List<Magazines> researchMagazines(String name) throws NotExistsException {
        List<Magazines> magazinesSelected = new ArrayList<>();
        for (Magazines n : this.magazines) {
            if(n.getName().equals(name)) {
                magazinesSelected.add(n);
            }
        }
        if(magazinesSelected.size() == 0) {
            throw new NotExistsException("Lista vazia.");
        }
        return magazinesSelected;
    }

    @Override
    public List<Books> researchBooks(String name) throws NotExistsException {
        List<Books> booksSelected = new ArrayList<>();
        for (Books n : this.books) {
            if(n.getName().equals(name)) {
                booksSelected.add(n);
            }
        }
        if(booksSelected.size() == 0) {
            throw new NotExistsException("Lista vazia.");
        } else {
            return booksSelected;
        }
    }

    @Override
    public List<Books> listTopBooks() throws NotExistsException{
        List<Books> top = new ArrayList<>();
        for(Books n: this.books) {
            if(n.getClassification() >=4.0) {
                top.add(n);
            }
        }
        if(top.size() == 0) {
            throw new NotExistsException("Lista vazia.");
        }
        return top;
    }

    @Override
    public List<Books> searchBookByGenrer(String genrer) throws NotExistsException  {
        List<Books> selection = new ArrayList<>();
        for(Books b: this.books) {
            if(b.getGenreStyle().equals(genrer)) {
                selection.add(b);
            }
        }
        if(selection.size() == 0) {
            throw new NotExistsException("Lista vazia.");
        }
        return selection;
    }

    @Override
    public List<Magazines> searchMagazinesByGenrer(String genrer) throws NotExistsException {
        ArrayList<Magazines> selection = new ArrayList<>();
        for(Magazines r: this.magazines) {
            if(r.getGenreStyle().equals(genrer)) {
                selection.add(r);
            }
        }
        if(selection.size() == 0) {
            throw new NotExistsException("Lista vazia");
        }
        return selection;
    }

    @Override
    public List<Magazines> listTopMagazines() throws NotExistsException {
        List<Magazines> top = new ArrayList<>();
        for(Magazines n: this.magazines) {
            if(n.getClassification() >=4.0) {
                top.add(n);
            }
        }
        if(top.size() == 0) {
            throw new NotExistsException("Nenhuma revista encontrada.");
        }
        return top;
    }

    @Override
    public boolean registerBook(Books prood) throws AlreadyExists {
        for(Books b: this.books) {
            if(b.getName().equals(prood.getName())) {
                throw new AlreadyExists("Já existe uma revista com esse nome.");
            }
        }
        this.books.add(prood);
        return true;
    }

    @Override
    public boolean registerMagazine(Magazines prod) throws AlreadyExists {
        for(Magazines b: this.magazines) {
            if(b.getName().equals(prod.getName())) {
                throw new AlreadyExists("Já existe uma revista com esse nome.");
            }
        }
        this.magazines.add(prod);
        return true;
    }
}