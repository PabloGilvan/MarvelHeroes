package com.piratemonkeys.marvelheroes.main;

import com.piratemonkeys.constructapp.presenter.main.MainActivityPresenter;
import com.piratemonkeys.constructapp.view.main.MainView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    @Mock
    MainView view;

    @Mock
    MainController controller;

    MainActivityPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new MainActivityPresenter(view, controller);
    }

    @Test public void shouldReturnShowNoInternetConnectionMessage(){

        given(controller.hasConnection()).willReturn(false);

        presenter.loadData();

        verify(view).showNoContentMessage(false);
        verify(view).showNoConnectionMessage(true);
    }

    @Test public void shouldShowNoContent(){

        given(controller.hasConnection()).willReturn(true);
        //given(controller.requestData(0, 20, any(ProcessResponse.class))).willReturn(Collections.emptyList());

        presenter.loadData();

        verify(view).showLoader(true);
        verify(view).showLoader(false);
        verify(view).showNoConnectionMessage(false);
        verify(view).showNoContentMessage(true);
    }
}
