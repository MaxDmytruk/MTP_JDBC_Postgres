package handlers.queries.user;

import contracts.queries.repository.RepositoryByNameQuery;
import contracts.queries.user.UserByLoginQuery;
import handlers.queries.repository.RepositoryByNameQueryHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserByLoginQueryHandlerTest {
    UserByLoginQueryHandler handler;
    UserByLoginQuery query;
    @Before
    public void setup(){
        handler = new UserByLoginQueryHandler();
        query = new UserByLoginQuery();
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