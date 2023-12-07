public class User {
    private String id;
    private String pw;
    private String name;
    private String accountNums;

    public User(String newId, String newPw, String newName) {
        id = newId;
        pw = newPw;
        name = newName;
        accountNums = null;
    }

    public User(String newId, String newPw, String newName, String newAccountNums) {
        id = newId;
        pw = newPw;
        name = newName;
        accountNums = newAccountNums;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public String getAccountNums() {
        return accountNums;
    }
}
