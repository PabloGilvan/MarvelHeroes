package com.piratemonkeys.marvelheroes.presenters.hero;

import com.piratemonkeys.marvelheroes.view.activities.hero.HeroView;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HeroActivityPresenterTest {

    @Mock
    private HeroView view;

    @Mock
    private HeroLoader loader;

    private HeroActivityPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new HeroActivityPresenter(view, loader);
    }
}
