package com.example.junhee.mvpbasic;

/**
 * Created by JunHee on 2017. 12. 10..
 */

public class MemoryRepository implements LoginRepository {

    private User user;

    @Override
    public User getUser() {
        if (user == null){
            User user = new User("Junhee", "Lee");
            user.setId(0);
            return user;
        } else {
            return user;
        }
    }

    @Override
    public void saveUser(User user) {
        if (user == null)
            user = getUser();

        this.user = user;
    }
}
