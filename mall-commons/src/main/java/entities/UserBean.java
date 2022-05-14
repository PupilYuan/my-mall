package entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {
    private int uid;
    private String userName;
    private String introduce;
    private String email;
    private String password;


    public UserBean(String userName, String introduce, String email,String password) {
        this.userName = userName;
        this.introduce = introduce;
        this.email = email;
        this.password = password;
    }
}
