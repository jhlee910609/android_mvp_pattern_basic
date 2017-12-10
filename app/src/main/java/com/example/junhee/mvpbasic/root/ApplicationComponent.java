package com.example.junhee.mvpbasic.root;

import com.example.junhee.mvpbasic.LoginActivity;
import com.example.junhee.mvpbasic.LoginModel;
import com.example.junhee.mvpbasic.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JunHee on 2017. 12. 10..
 */
@Singleton
@Component (modules = {ApplicationModule.class, LoginModule.class})
// @Component annotation에 정의된 class(module)만 injection이 가능하다.
public interface ApplicationComponent {
    void inject(LoginActivity loginActivity);
}
