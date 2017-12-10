package com.example.junhee.mvpbasic;

/**
 * Created by JunHee on 2017. 12. 10..
 */

public class LoginModel implements LoginActivityMVP.Model {

    private LoginRepository repository;

    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String firstName, String lastName) {
        repository.saveUser(new User(firstName,lastName));

    }

    @Override
    public User getUser() {
        return repository.getUser() ;
    }
}
