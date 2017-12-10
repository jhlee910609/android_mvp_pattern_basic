package com.example.junhee.mvpbasic;

/**
 * Created by JunHee on 2017. 12. 10..
 */

public interface LoginRepository {

    User getUser();
    void saveUser(User user);
}
