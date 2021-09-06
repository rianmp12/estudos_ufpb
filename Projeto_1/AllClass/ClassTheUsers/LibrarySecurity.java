package AllClass.ClassTheUsers;

import java.util.ArrayList;
import java.util.List;
import AllClass.ClassException.*;

public class LibrarySecurity {

    private List<UsersLibrary> users = new ArrayList<>();

    public LibrarySecurity(List<UsersLibrary> usu) {
        this.users = usu;
    }

    public LibrarySecurity(ArrayList<UsersLibrary> newUsers) {
        this.users = newUsers;
    }

    public LibrarySecurity() {
        this.users = new ArrayList<UsersLibrary>();
    }

    public boolean registerUsers(UsersLibrary xx) {
        for(UsersLibrary u: this.users) {
            if(u.getLogin().equals(xx.getLogin())) {
                return false;
            }
        }
        users.add(xx);
        return true;
    }

    public boolean accessUsers(String login, String password) {
        for(UsersLibrary u: users) {
            if(u.getLogin().equals(login) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public List<UsersLibrary> searchUsers(String name) throws NotExistsException {
        List<UsersLibrary> uss = new ArrayList<>();
        for(UsersLibrary u: users) {
            if(u.getName().equals(name)) {
                uss.add(u);
            }
        }
        if(uss.size() == 0) {
            throw new NotExistsException("Lista vazia");
        }
        return uss;
    }

    public List<UsersLibrary> getUsers() throws NotExistsException {
        if(this.users.size() == 0) {
            throw new NotExistsException("Lista vazia");
        }
        return this.users;
    }

    public void setUsers(ArrayList<UsersLibrary> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "LibrarySecurity [users=" + users + "]";
    }
}
