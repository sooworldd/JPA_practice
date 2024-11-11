package com.react.prac.DTO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Data
public class UsersDTO {

    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(max = 50, message = "아이디는 50자를 초과할 수 없습니다.")
    private String userId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, max = 255, message = "비밀번호는 8자 이상 255자 이하로 입력해주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{8,255}$", message = "비밀번호는 영문, 숫자, 특수문자를 포함해야 합니다.")
    private String password;

    @NotBlank(message = "성명을 입력해주세요.")
    @Size(max = 100, message = "사용자 이름은 100자를 초과할 수 없습니다.")
    private String username;

    @NotNull(message = "생년월일은 필수 입력 사항입니다.")
    private String birthDate;

    @NotBlank(message = "주소를 입력해주세요.")
    @Size(max = 255, message = "주소는 255자를 초과할 수 없습니다.")
    private String address;

    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "잘못된 이메일 형식입니다.")
    @Size(max = 100, message = "이메일은 100자를 초과할 수 없습니다.")
    private String email;

    @NotBlank(message = "전화번호를 입력해주세요.")
    @Pattern(regexp = "^\\d{11}$", message = "전화번호는 11자리 숫자만 입력해주세요.")
    private String phone;

    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;

}