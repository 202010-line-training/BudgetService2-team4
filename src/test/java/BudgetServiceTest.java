import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BudgetServiceTest {

    private BudgetService budgetService;

    @Test
    public void test_one_day(){
        givenBudget();

        LocalDate start = LocalDate.of(2020, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2020, Month.JANUARY, 1);
        double result = budgetService.query(start,end);
//        assertEquals(result,100);
    }

    private void givenBudget() {
        IBudgetRepo iBudgetRepo = mock(IBudgetRepo.class);
        Budget budget = new Budget("200001",3100);
        List<Budget> list = new ArrayList<Budget>();
        list.add(budget);
        when(iBudgetRepo.getAll()).thenReturn(list);
        budgetService = new BudgetService(iBudgetRepo);
    }

}
