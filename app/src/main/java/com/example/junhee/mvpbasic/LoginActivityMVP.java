package com.example.junhee.mvpbasic;

/**
 * Created by JunHee on 2017. 12. 10..
 */

public interface LoginActivityMVP {

    // view가 갖고 있어야 할 interface 정의
    interface View {
        String getFirstName();
        String getLastName();
        void showInputError();
        void showUserSavedMessage();
        void setFirstName(String firstName);
        void setLastName(String lastName);
    }

    // Presenter가 갖고 있어야 할 interface 정의
    interface Presenter {
        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();
    }
    // Model가 갖고 있어야 할 interface 정의
    interface Model {
        void createUser(String firstName, String LastName);
        User getUser();
    }
}
