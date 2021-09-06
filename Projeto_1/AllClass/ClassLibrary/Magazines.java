package AllClass.ClassLibrary;

public class Magazines {

    private String name;
    private String dateEdition;
    private String nameEditor;
    private String genreStyle;
    private double classification;
    private int numberPags;
    
    public Magazines(String name, String dateEdition, String genreStyle, String nameEditor, double classification, int numberPags) {
        this.name = name;
        this.dateEdition = dateEdition;
        this.nameEditor = nameEditor;
        this.genreStyle = genreStyle;
        this.classification = classification;
        this.numberPags = numberPags;
    }

    public Magazines() {
        this("Sem nome", "dd/mm/aaaa","Sem gênero", "Sem editora", 0.0, 0);
    }

    public String getGenreStyle() {
        return this.genreStyle;
    }

    public String getNameEditor() {
        return this.nameEditor;
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

    public void setNameEditor(String nameEditor) {
        this.nameEditor = nameEditor;
    }

    public void setGenreStyle(String genreStyle) {
        this.genreStyle = genreStyle;
    }

    public double getClassification() {
        return classification;
    }

    public void setClassification(double classification) {
        this.classification = classification;
    }

    public int getNumberPags() {
        return numberPags;
    }

    public void setNumberPags(int numberPags) {
        this.numberPags = numberPags;
    }

    public String toString() {
        return "Nome: "+this.name+" / D. Edição: "+this.dateEdition
        +"\nGênero: "+this.genreStyle+"\nNº Páginas: "+this.numberPags+" / Avaliação da Revista: "+this.classification+
        "\nEditora: "+this.nameEditor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(classification);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((dateEdition == null) ? 0 : dateEdition.hashCode());
        result = prime * result + ((genreStyle == null) ? 0 : genreStyle.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((nameEditor == null) ? 0 : nameEditor.hashCode());
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
        Magazines other = (Magazines) obj;
        if (Double.doubleToLongBits(classification) != Double.doubleToLongBits(other.classification))
            return false;
        if (dateEdition == null) {
            if (other.dateEdition != null)
                return false;
        } else if (!dateEdition.equals(other.dateEdition))
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
        if (nameEditor == null) {
            if (other.nameEditor != null)
                return false;
        } else if (!nameEditor.equals(other.nameEditor))
            return false;
        if (numberPags != other.numberPags)
            return false;
        return true;
    }
}
