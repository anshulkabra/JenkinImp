package org.uitestingespresso;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.uitestingespresso.utils.DatabaseHelper;

import java.util.List;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    private DatabaseHelper database;
    private String  email_id="imanshulkabra@gmail.com";
    private String password="123456";
    private String type="Food";
    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Exception {
        getTargetContext().deleteDatabase(DatabaseHelper.DB_NAME);
        database = new DatabaseHelper(getTargetContext());
    }

    @After
    public void tearDown() throws Exception {
        database.close();
    }
    @Test
    public void loginActivityTest() {
        database.deleteAllRecord();
        ViewInteraction appCompatAutoCompleteTextView = onView(
                withId(R.id.email));
        appCompatAutoCompleteTextView.perform(scrollTo(), replaceText(email_id), closeSoftKeyboard());

        ViewInteraction appCompatEditText = onView(
                withId(R.id.password));
        appCompatEditText.perform(scrollTo(), replaceText(password), closeSoftKeyboard());

        onView(withId(R.id.email_sign_in_button)).perform(click());

        List<String> expenseTypes = database.getExpenseTypes();
        assertThat(expenseTypes.size(), is(1));
        assertTrue(expenseTypes.get(0).equals(email_id));

    }


    /*@Test
    public void shouldAddExpenseType() throws Exception {


    }*/
}
