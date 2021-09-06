package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import AllClass.ClassLibrary.*;
import AllClass.ClassTheUsers.*;
import DataBase.DataRecorder;
import AllClass.ClassException.*;

public class MainProgram {

    public static void allBooks(MyLibrary library) {
        List<Books> list;
        try {
            list = library.getBooks();
            for(Books u : list) {
                JOptionPane.showMessageDialog(null, u.toString());
            }
        } catch (NotExistsException e) {
            JOptionPane.showMessageDialog(null, "Nenhum livro encontrado.");
            e.getMessage();
            e.printStackTrace();
        }
    }

    public static void allMagazines(MyLibrary library) {
        List<Magazines> list;
        try {
            list = library.getMagazines();
            for(Magazines m: list) {
                JOptionPane.showMessageDialog(null, m.toString());
            }
        } catch (NotExistsException e) {
            JOptionPane.showMessageDialog(null, "Nenhuma revista encontrada.");
            e.getMessage();
            e.printStackTrace();
        }
    }

    public static void allUsers(LibrarySecurity l) {
        List<UsersLibrary> usu;
        try {
            usu = l.getUsers();
            for(UsersLibrary u: usu) {
                JOptionPane.showMessageDialog(null, u.toString());
            }
        } catch (NotExistsException e) {
            JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado.");
            e.getMessage();
            e.printStackTrace();
        }

    }

    public static void searchBookbyName(MyLibrary library) {
        String searchBookName = JOptionPane.showInputDialog("Digite o nome do livro:");
        try {
            List<Books> list = library.researchBooks(searchBookName);
            for(Books u: list) {
                JOptionPane.showMessageDialog(null, u.toString());
            }
        } catch (NotExistsException e) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado.");
            e.getMessage();
            e.printStackTrace();
        }
    }

    public static void searchBookinGenrer(MyLibrary library) {
        String searchBookGenrer = JOptionPane.showInputDialog("Digite o gênero do livro:");
        try {
            List<Books> list = library.searchBookByGenrer(searchBookGenrer);
            for(Books u: list) {
                JOptionPane.showMessageDialog(null, u.toString());
            }
        } catch (NotExistsException e) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado.");
            e.getMessage();
            e.printStackTrace();
        }
    }

    public static void searchMagazinesinGenrer(MyLibrary library) {
        String searchMagazinesGenrer = JOptionPane.showInputDialog("Digite o gênero da revista:");
        try {
            List<Magazines> list = library.searchMagazinesByGenrer(searchMagazinesGenrer);
            for(Magazines m: list) {
                JOptionPane.showMessageDialog(null, m.toString());
            }
        } catch (NotExistsException e) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado.");
            e.getMessage();
            e.printStackTrace();
        }

    }

    public static void searchMagazinesinName(MyLibrary library) {
        String searchMagazines = JOptionPane.showInputDialog("Digite o nome da revista:");
        List<Magazines> list;
        try {
            list = library.researchMagazines(searchMagazines);
            for(Magazines m: list) {
                JOptionPane.showMessageDialog(null, m.toString());
            }
        } catch (NotExistsException e) {
            JOptionPane.showMessageDialog(null, "Nenhuma revista encontrada.");
            e.getMessage();
            e.printStackTrace();
        }
    }
    
    public static void registerU(LibrarySecurity users) {
        String newName = JOptionPane.showInputDialog("Digite o nome do usuário:");
        String newLogin = JOptionPane.showInputDialog("Digite o login:");
        String confirmLogin = JOptionPane.showInputDialog("Confirme o login:");
        if(newLogin.equals(confirmLogin)) {
            String newPassword = JOptionPane.showInputDialog("Digite a senha:");
            String confirmPassword = JOptionPane.showInputDialog("Confirme a senha:");
            if(newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
                users.registerUsers(new UsersLibrary(newLogin, newPassword, newName));
            } else {
                JOptionPane.showMessageDialog(null, "A confirmação de senha está incorreta. Tente novamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "A confirmação de login está incorreta. Tente novamente.");
        }  
    }

    public static void topBooks(MyLibrary library) {
        List<Books> tops;
        try {
            tops = library.listTopBooks();
            for(Books b: tops) {
                JOptionPane.showMessageDialog(null, b.toString()); ;
            }
        } catch (NotExistsException e) {
            JOptionPane.showMessageDialog(null, "Nenhum livro encontrado.");
            e.getMessage();
            e.printStackTrace();
        }
    }

    public static void topMagazines(MyLibrary library) {
        List<Magazines> tops;
        try {
            tops = library.listTopMagazines();
            for(Magazines b: tops) {
                JOptionPane.showMessageDialog(null, b.toString()); ;
            }
        } catch (NotExistsException e) {
            JOptionPane.showMessageDialog(null, "Nenhuma revista encontrada.");
            e.getMessage();
            e.printStackTrace();
        }
    }
    
    public static void registerB(MyLibrary library) {
        String newNameBook = JOptionPane.showInputDialog("Digite o nome do livro:");
        String newDateEdition = JOptionPane.showInputDialog("Digite a data de edição do livro:");
        String newAuthor = JOptionPane.showInputDialog("Digite o nome do autor do livro:");
        String newDescription = JOptionPane.showInputDialog("Digite uma descrição do livro");
        String newGenrer = JOptionPane.showInputDialog("Digite o gênero do livro: ");
        int newPags = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de páginas do livro:"));
        double newClassification = Double.parseDouble(JOptionPane.showInputDialog("Digite a classificação do livro:"));
        try {
            library.registerBook(new SimpleBooks(newNameBook, newDateEdition, newAuthor,newDescription, newGenrer, newPags, newClassification));
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso.");
        } catch (AlreadyExists e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar revista. Verifique se já existe uma revista com esse nome.");
            e.getMessage();
            e.printStackTrace();
        }
    }
    
    public static void registerM(MyLibrary library) {
        String newName = JOptionPane.showInputDialog("Digite o nome da revista:");
        String newEdition = JOptionPane.showInputDialog("Digite a data de edição da revista:");
        String newNameEditor = JOptionPane.showInputDialog("Digite o nome da editora da revista:");
        String newGenrer = JOptionPane.showInputDialog("Digite o gênero da revista:");
        int newPags = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de páginas da revista:"));
        double newClassification = Double.parseDouble(JOptionPane.showInputDialog("Digite a classificação da revista:"));
        try {
            library.registerMagazine(new Magazines(newName, newEdition, newGenrer, newNameEditor, newClassification, newPags));
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
        } catch (AlreadyExists e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar revista. Verifique se já existe uma revista com esse nome.");
            e.getMessage();
            e.printStackTrace();
        }
    }

    public static void searchUsersName(LibrarySecurity users) {
        String searchU = JOptionPane.showInputDialog("Digite o nome do usuário:");
        List<UsersLibrary> list;
        try {
            list = users.searchUsers(searchU);
            for(UsersLibrary m: list) {
                JOptionPane.showMessageDialog(null, m.toString());
            }
        } catch (NotExistsException e) {
            JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado.");
            e.getMessage();
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        DataRecorder recorder = new DataRecorder();
        List<Books> bk = new ArrayList<>();
        LibrarySecurity users = new LibrarySecurity();
        List<Magazines> mg = new ArrayList<>();
        try {
            List<UsersLibrary> u = recorder.dataRecoverUsersInArchives();
            users = new LibrarySecurity(u);
            bk = recorder.dataRecoverBooksInArchives();
            mg = recorder.dataRecoverMagazinesInArchives();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler dados.");
            e.getMessage();
            e.printStackTrace();
        }

        MyLibrary library = new MyLibrary("UFPB", "Rio Tinto - Campus IV.","444", bk, mg);
        JOptionPane.showMessageDialog(null, "Bem-vindo(a) à biblioteca "+library.getName()+"!");
        boolean noActived = true;
        while(noActived) {
            int choice = Integer.parseInt(JOptionPane.showInputDialog("1.Fazer login.\n2.Endereço.\n3.Sair"));
            switch (choice) {
                case 1:
                    boolean notActived = true;
                    while(notActived) {
                        String login = JOptionPane.showInputDialog("Usuário: ");
                        String password = JOptionPane.showInputDialog("Senha:");
                        if(login.equals(UsersLibrary.LOGIN_ADM)) {
                            if(password.equals(UsersLibrary.PASSWORD_ADM)) {
                                boolean finished = false;
                                while(!finished) {
                                    int options = Integer.parseInt(JOptionPane.showInputDialog("1.Cadastrar usuário.\n2.Listar Usuários.\n3.Pesquisa Usuário por nome.\n4.Cadastrar Livros.\n5.Listar Livros.\n6.Cadastrar Revista.\n7.Listar Revistas\n8.Salvar dados.\n9.Finalizar sessão."));
                                    switch (options) {
                                        case 1:
                                            registerU(users);    
                                            break;
                                        case 2:
                                            allUsers(users);
                                            break;         
                                        case 3:
                                            searchUsersName(users);
                                            break;   
                                        case 4:
                                            registerB(library);
                                            break;
                                        case 5:
                                            allBooks(library);
                                            break;
                                        case 6:
                                            registerM(library);
                                            break;
                                        case 7:
                                            allMagazines(library);
                                            break;
                                        case 8:
                                            try {
                                                recorder.recordBooksInArchives(library.getBooks());
                                                recorder.recordMagazinesInArchives(library.getMagazines());
                                                recorder.recordUserInArchives(users.getUsers());
                                                JOptionPane.showMessageDialog(null, "Dados salvos com sucesso");
                                            } catch (IOException e) {
                                                e.getMessage();
                                                e.printStackTrace();
                                            } catch (NotExistsException e) {
                                                JOptionPane.showMessageDialog(null, "Nenhum elemento encontrado");
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 9:
                                            JOptionPane.showMessageDialog(null, "Até logo! Volte sempre!");
                                            finished = true;
                                            notActived = false;
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Opção inválida. Tente Novamente.");
                                            break;
                                    }
                                }
                            }
                        } else if(users.accessUsers(login, password)) {
                            boolean access = true;
                            while(access) {
                                int options = Integer.parseInt(JOptionPane.showInputDialog("1.Listar Livros.\n2.Listar Revistas\n3.Pesquisar livro por nome.\n4.Pesquisa livro por gênero.\n5.Pesquisar revista por nome.\n6.Pesquisa revista por gênero.\n7.Lista os melhores livros.\n8.Lista as melhores revistas.\n9.Finalizar sessão."));
                                switch (options) {
                                    case 1:
                                        allBooks(library);
                                        break;
                                    case 2:
                                        allBooks(library);
                                        break;
                                    case 3:
                                        searchBookbyName(library);
                                        break;
                                    case 4:
                                        searchBookinGenrer(library);
                                        break;
                                    case 5:
                                        searchMagazinesinName(library);
                                        break;
                                    case 6:
                                        searchMagazinesinGenrer(library);
                                        break;
                                    case 7:
                                        topBooks(library);
                                        break;
                                    case 8:
                                        topMagazines(library);
                                        break;
                                    case 9:
                                        JOptionPane.showMessageDialog(null, "Até logo! Volte sempre!");
                                        access = false;
                                        notActived = false;
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente Novamente.");
                                        break;
                                }
                            }
                        } else {
                        JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado.");
                        }
                    }           
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, library.getAddress());
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Sistema finalizado.");
                    noActived = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}