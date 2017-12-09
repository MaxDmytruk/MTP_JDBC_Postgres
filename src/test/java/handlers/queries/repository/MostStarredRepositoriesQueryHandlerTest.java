package handlers.queries.repository;

import contracts.commands.contributor.CreateContributorCommand;
import contracts.queries.repository.MostStarredRepositoriesQuery;
import handlers.commands.contributor.CreateContributorCommandHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MostStarredRepositoriesQueryHandlerTest {
    MostStarredRepositoriesQueryHandler handler;
    MostStarredRepositoriesQuery query;
    @Before
    public void setup(){
        handler = new MostStarredRepositoriesQueryHandler();
        query = new MostStarredRepositoriesQuery();
    }
    @Test
    public void execute() throws Exception {
        int exceptionCounter = 0;
        try {
            handler.execute(query);
        }
        catch (Exception ex){
            exceptionCounter++;
        }
        assertEquals(0, exceptionCounter);
    }
}