package com.example.junhee.mvpbasic;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PresenterTest {

    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockView;
    LoginActivityPresenter presenter;
    User user;


    @Before
    public void setUp(){
        mockLoginModel = mock(LoginActivityMVP.Model.class);
        user = new User("Fox", "Mulder");
        mockView = mock(LoginActivityMVP.View.class);
        presenter = new LoginActivityPresenter(mockLoginModel);
        presenter.setView(mockView);
    }

    @Test
    public void loadTheUserFromTheRespositoryWhenValidUserIsPresent(){
        when(mockLoginModel.getUser()).thenReturn(user);
        presenter.getCurrentUser();

        //verify model interactions
        // times(number that i expect method to be called)
        verify(mockLoginModel, times(1)).getUser();

        // verify view interactions
        verify(mockView, times(1)).setFirstName("Fox");
        verify(mockView, times(1)).setLastName("Mulder");
        verify(mockView, never()).showInputError();

    }

    @Test
    public void shouldShowErrorMsgWhenUserIsNull(){
        when(mockLoginModel.getUser()).thenReturn(null);
        presenter.getCurrentUser();

        //verify model interactions
        verify(mockLoginModel, times(1)).getUser();

        verify(mockView, never()).setFirstName("Fox");
        verify(mockView, never()).setLastName("Mulder");
        verify(mockView, times(1)).showInputError();
    }

    @Test
    public void shouldCreateErrorMsgIfFieldAreEmpty(){
        when(mockView.getFirstName()).thenReturn("");
        presenter.saveUser();

        verify(mockView, times(1)).getFirstName();
        verify(mockView, never()).getLastName();
        verify(mockView, times(1)).showInputError();

        when(mockView.getFirstName()).thenReturn("Dana");
        when(mockView.getLastName()).thenReturn("");

        presenter.saveUser();

        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(1)).getLastName();
        verify(mockView, times(2)).showInputError();


    }
}
