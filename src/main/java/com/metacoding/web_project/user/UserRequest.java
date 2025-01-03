package com.metacoding.web_project.user;


import com.metacoding.web_project.useraccount.UserAccount;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRequest {



    @Data
    public static class JoinDTO{
        private Integer id;
        @NotBlank
        @Size(min = 1, max = 20)
        private String username;
        @NotBlank
        @Size(min = 8, max = 20)
        private String password;
        @NotBlank
        @Size(min = 10, max = 15)
        private String tel;
        @NotBlank
        @Size(min = 1, max = 20)
        private String name;
        @Size(min = 5, max = 5)
        @NotBlank
        private String postNum;
        @NotBlank
        private String addr;
        @NotBlank
        private String addrDetail;
        @NotBlank
        private String birth;
        private String role;


        //UserAccount
        private Integer score;
        private Integer hasPrice;
        private String account;
        private User user;

        public User toEntity(PasswordEncoder passwordEncoder){
            String encpw = passwordEncoder.encode(password);
            return User.builder()
                .id(null).username(username).password(encpw).name(name).tel(tel)
                .postNum(postNum).addr(addr).addrDetail(addrDetail).birth(birth).role(role)
                .build();
        }

        public UserAccount toEntity(User user){
            return UserAccount.builder()
                .score(score)
                .hasPrice(hasPrice)
                .account(account)
                .user(user)
                .build();

        }
    }

    @Data
    public static class FindUserDTO {
        @NotBlank
        private String name;
        @NotBlank
        private String tel;
    }

    @Data
    public static class UpdateDTO {
        private String tel;
        private String postNum;
        private String addr;
        private String addrDetail;
        private String account;


    }

    @Data
    public static class UpdateUserAccountDTO{
        private String account;
    }

    @Data
    public static class ChangePwDTO {
        private String password;
        private String newPassword;
    }

    @Data
    public static class CheckIdDTO{
        private String username;
    }

    @Data
    public static class FindPwDTO{
        private String username;
        private String name;
        private String tel;
    }

    @Data
    public static class ChPwDTO{
        private String password;
    }

    @Data
    public static class WithdrawDTO{
        private Integer hasPrice;
        private Integer outMoney;
        private String outAccount;
    }

    @Data
    public static class ChargeDTO{
        private Integer hasPrice;
        private Integer inMoney;
    }

    @Data
    public static class CheckAccountDTO {
        private String bankCode;
        private String bankNum;
    }
}