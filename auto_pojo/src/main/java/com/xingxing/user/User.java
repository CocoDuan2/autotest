package com.xingxing.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_user")
public class User implements Serializable {


    @Id
    private String id;
    private String mobile;
    private String username;
    private String password;
    private String sex;
    private String birthday;
    private String email;
    private String regdate;
    private String updatedate;
    private String lastdate;
    private String online;



}
