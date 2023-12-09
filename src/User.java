public class User {
    private String id;
    private String pw;
    private String name;
    private String accountCount; // 계좌번호 개수
    private String accountNums; // 계좌번호

    public User(String newId, String newPw, String newName) {
        id = newId;
        pw = newPw;
        name = newName;
        accountCount = "0";
        accountNums = null;
    }

    public User(String newId, String newPw, String newName, String newAccountCount, String newAccountNums) {
        id = newId;
        pw = newPw;
        name = newName;
        accountCount = newAccountCount;
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

    public String getAccountCount() {
        return accountCount;
    }

    public String toString() {
        String str = getId() + " " + getPw() + " " + getName() + " " + getAccountCount() + " " + getAccountNums();
        return str;
    }
}
