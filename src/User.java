public class User {
    private String id;
    private String pw;
    private String name;
    private String accountCount; // 계좌번호 개수
    private String accountNums; // 계좌번호

    /**
     * 회원가입용 생성자
     * 
     * @param newId
     * @param newPw
     * @param newName
     */
    public User(String newId, String newPw, String newName) {
        id = newId;
        pw = newPw;
        name = newName;
        accountCount = "0";
        accountNums = null;
    }

    /**
     * 상세페이지용 생성자
     * 
     * @param newId
     * @param newPw
     * @param newName
     * @param newAccountCount
     * @param newAccountNums
     */
    public User(String newId, String newPw, String newName, String newAccountCount, String newAccountNums) {
        id = newId;
        pw = newPw;
        name = newName;
        accountCount = newAccountCount;
        accountNums = newAccountNums;
    }

    /**
     * 로그인용 생성자
     * 
     * @param newId
     * @param newPw
     */
    public User(String newId, String newPw) {
        id = newId;
        pw = newPw;
        name = null;
        accountCount = "0";
        accountNums = null;
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
