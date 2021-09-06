package AllClass.ClassLibrary;

public class SimpleBooks extends Books {

    public SimpleBooks(String name, String dateEdition, String author, String description, String genre, int numberPags, double clas) {
        super(name, dateEdition, author, description, genre, numberPags, clas);
    }

    public SimpleBooks() {
        super("Sem nome", "dd/mm/aaaa", "Desconhecido", "Sem descrição", "Sem gênero", 0, 0.0);
    }    
}
