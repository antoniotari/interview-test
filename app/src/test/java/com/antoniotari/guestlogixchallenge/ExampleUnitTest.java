package com.antoniotari.guestlogixchallenge;

import com.antoniotari.guestlogixchallenge.models.Episode;
import com.antoniotari.guestlogixchallenge.models.ShowCharacter;
import com.antoniotari.guestlogixchallenge.ui.activities.MainContract;
import com.antoniotari.guestlogixchallenge.ui.activities.MainPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith (MockitoJUnitRunner.class)
public class ExampleUnitTest {

    @Mock private MainContract.View mockMainActivity;
    private MainPresenter presenter = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter(mockMainActivity);
    }

    @After
    public void tearDown() {
        presenter.onDestroy();
    }

    @Test
    public void testOnViewCreatedFlow() {
        presenter.onViewCreated();
        verify(mockMainActivity).loadEpisodesFragment(); //(any(EpisodesFragment.class));
    }

    @Test
    public void testListClick() {
        Episode episode = new Episode();
        episode.setId(11);
        presenter.onListClick(episode);
        verify(mockMainActivity).loadCharactersFragment(episode);

        ShowCharacter character = new ShowCharacter();
        presenter.onListClick(character);
        verify(mockMainActivity).loadDetailFragment(character);
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}