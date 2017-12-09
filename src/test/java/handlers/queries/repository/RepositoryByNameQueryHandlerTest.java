package handlers.queries.repository;

import contracts.queries.repository.MostStarredRepositoriesQuery;
import contracts.queries.repository.RepositoryByNameQuery;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RepositoryByNameQueryHandlerTest {
    RepositoryByNameQueryHandler handler;
    RepositoryByNameQuery query;
    @Before
    public void setup(){
        handler = new RepositoryByNameQueryHandler();
        query = new RepositoryByNameQuery();
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