package AllClass.ClassLibrary;

public abstract class Books {
    
    private String name;
    private String dateEdition;
    private String author;
    private String description;
    private String genreStyle;
    private int numberPags;
    private double classification;

    public Books(String name, String dateEdition, String author, String description, String genre, int numberPags, double clas) {
        this.name = name;
        this.dateEdition = dateEdition;
        this.author = author;
        this.description = description;
        this.genreStyle = genre;
        this.numberPags = numberPags;
        this.classification = clas;
    }

    public Books() {
        this("Sem nome", "dd/mm/aaaa", "Desconhecido", "Sem descrição", "Sem gênero", 0, 0.0);
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public String getgenreStyle() {
        return this.genreStyle;
    }

    public int getNumberPags() {
        return this.numberPags;
    }

    public void setNumberPags(int newPags) {
        this.numberPags = newPags;
    }

    public String getGenreStyle() {
        return this.genreStyle;
    }

    public void setGenreStyle(String genreStyle) {
        this.genreStyle = genreStyle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(String dateEdition) {
        this.dateEdition = dateEdition;
    }

    public double getClassification() {
        return classification;
    }

    public void setClassification(double classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Nome: "+this.name+" / D. Edição: "+this.dateEdition+" / Autor: "
        +this.author+" / Gênero: "+this.genreStyle+"\nNº Páginas: "+this.numberPags+" / Avaliação do Livro: "+this.classification+
        "\nDescrição do Livro: "+this.description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        long temp;
        temp = Double.doubleToLongBits(classification);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((dateEdition == null) ? 0 : dateEdition.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((genreStyle == null) ? 0 : genreStyle.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + numberPags;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Books other = (Books) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (Double.doubleToLongBits(classification) != Double.doubleToLongBits(other.classification))
            return false;
        if (dateEdition == null) {
            if (other.dateEdition != null)
                return false;
        } else if (!dateEdition.equals(other.dateEdition))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (genreStyle == null) {
            if (other.genreStyle != null)
                return false;
        } else if (!genreStyle.equals(other.genreStyle))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (numberPags != other.numberPags)
            return false;
        return true;
    }
}
