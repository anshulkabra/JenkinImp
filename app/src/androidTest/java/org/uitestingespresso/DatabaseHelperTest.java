package org.uitestingespresso;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.uitestingespresso.model.ExpenseType;
import org.uitestingespresso.utils.DatabaseHelper;

import java.util.List;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.is;


@RunWith(AndroidJUnit4.class)
public class DatabaseHelperTest {

    private DatabaseHelper database;

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
    public void shouldAddExpenseType() throws Exception {
        database.addExpenseType(new ExpenseType("Food"));

        List<String> expenseTypes = database.getExpenseTypes();
        assertThat(expenseTypes.size(), is(1));
        assertTrue(expenseTypes.get(0).equals("Food"));
    }
}
