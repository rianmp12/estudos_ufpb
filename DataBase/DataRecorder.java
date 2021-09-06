package DataBase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import AllClass.ClassLibrary.Books;
import AllClass.ClassLibrary.SimpleBooks;
import AllClass.ClassLibrary.Magazines;
import AllClass.ClassTheUsers.UsersLibrary;

public class DataRecorder {
	
	public static final String FILES_USERS = "DataBase/RegisteredUsers.txt";

	public static final String FILES_BOOKS = "DataBase/RegisteredBooks.txt";

	public static final String FILES_MAGAZINES = "DataBase/RegisteredMagazines.txt";


	public List<Books> dataRecoverBooksInArchives() throws IOException {
		List<Books> dataBooks = new ArrayList<>();
		List<String> textBooks = this.textRecoverInArchives(FILES_BOOKS);
		for (String line: textBooks) {
			String [] data = line.split("#");
			int convertInt = Integer.parseInt(data[5]);
			double convertDouble = Double.parseDouble(data[6]);
			Books b = new SimpleBooks(data[0], data[1], data[2], data[3],data[4],convertInt,convertDouble);
			dataBooks.add(b);
		}
		return dataBooks;
	}

	public List<Magazines> dataRecoverMagazinesInArchives() throws IOException {
		List<Magazines> dataMagazines = new ArrayList<>();
		List<String> textMagazines = this.textRecoverInArchives(FILES_MAGAZINES);
		for (String line: textMagazines) {
			String [] data = line.split("");
			int convertInt = Integer.parseInt(data[5]);
			double convertDouble = Double.parseDouble(data[4]);
			Magazines m = new Magazines(data[0], data[1], data[2], data[3],convertDouble,convertInt);
			dataMagazines.add(m);
		}
		return dataMagazines;
	}

	public void recordMagazinesInArchives(List<Magazines> magazines) throws IOException {
		List<String> magazinesTxt = new ArrayList<>();
		for (Magazines m: magazines) {
			String line = m.getName()+"#"+m.getDateEdition()+"#"+m.getGenreStyle()+"#"+m.getNameEditor()+"#"+m.getClassification()+"#"+m.getNumberPags();
			magazinesTxt.add(line);
		}
		this.recordTextInArchives(magazinesTxt, FILES_MAGAZINES);
	}
	
	public void recordBooksInArchives(List<Books> books) throws IOException {
		List<String> booksTxt = new ArrayList<>();
		for (Books b: books) {
			String line = b.getName()+"#"+b.getDateEdition()+"#"+b.getAuthor()+"#"+b.getDescription()+"#"+b.getGenreStyle()+"#"+b.getNumberPags()+"#"+b.getClassification();
			booksTxt.add(line);
		}
		this.recordTextInArchives(booksTxt, FILES_BOOKS);
	}
	
	public List<UsersLibrary> dataRecoverUsersInArchives() throws IOException {
		List<UsersLibrary> dataUsers = new ArrayList<>();
		List<String> textUsers = this.textRecoverInArchives(FILES_USERS);
		for (String line: textUsers) {
			String [] data = line.split("#");
			UsersLibrary u = new UsersLibrary(data[0], data[1], data[2]);
			dataUsers.add(u);
		}
		return dataUsers;
	}
	
	public void recordUserInArchives(List<UsersLibrary> users) throws IOException {
		List<String> usersTxt = new ArrayList<>();
		for (UsersLibrary u: users) {
			String line = u.getLogin()+"#"+u.getPassword()+"#"+u.getName();
			usersTxt.add(line);
		}
		this.recordTextInArchives(usersTxt, FILES_USERS);
	}
	
	
	public List<String> textRecoverInArchives(String nomeArquivo) throws IOException {
		
		BufferedReader leitor = null;
		List<String> textoLido = new ArrayList<>();
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String texto = null;
			do {
				texto = leitor.readLine();
				if (texto!=null) {
					textoLido.add(texto);
				}
			} while (texto!=null);
		} finally {
			if (leitor!=null) {
				leitor.close();
			}
		}
		return textoLido;
		
	}
	
	public void recordTextInArchives(List<String> texto, String nomeArquivo)
		throws IOException{
		
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (String s: texto) {
				gravador.write(s+"\n");
			}
		} finally {
			if (gravador!=null) {
				gravador.close();
			}
		}
	}
}
