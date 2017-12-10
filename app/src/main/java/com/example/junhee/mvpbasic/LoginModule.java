package com.example.junhee.mvpbasic;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JunHee on 2017. 12. 10..
 */

@Module
public class LoginModule {

    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model){
        return new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(LoginRepository repository){
        return new LoginModel(repository);
    }

    @Provides
    public LoginRepository provideLoginRepository(){
        return new MemoryRepository();
    }
}
