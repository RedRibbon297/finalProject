package by.mysite.constants;

public class DbConstant {
    public static final String ID_COL = "id";
    public static final String LOGIN_COL = "login";
    public static final String NAME_COL = "name";
    public static final String PASSWORD_COL = "password";
    public static final String EMAIL_COL = "email";

    public static final String SELECT_USER_BY_CREDENTIAL =
            "SELECT id, name, email FROM user WHERE login = ? AND password = ?";


}
