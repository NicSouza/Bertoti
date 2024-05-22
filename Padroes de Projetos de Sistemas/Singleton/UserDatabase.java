public class UserDatabase {

    private static UserDatabase instance;

    private List<String> users;

    private UserDatabase() {
        users = new ArrayList<>();
    }

    public static synchronized UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }

    public void addUser(String user) {
        users.add(user);
    }

    public List<String> getUsers() {
        return users;
    }

    public void printUsers() {
        for (String user : users) {
            System.out.println("Usuário: " + user);
        }
    }
}
