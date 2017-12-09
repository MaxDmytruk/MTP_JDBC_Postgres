package cqrs;

import contracts.queries.user.UserByLoginQuery;
import contracts.queries.user.UserByLoginResult;
import handlers.queries.user.UserByLoginQueryHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IQueryHandlerTest {
    IQueryHandler<UserByLoginQuery,UserByLoginResult> handler;
    UserByLoginQuery query;

    @Before
    public void setup(){
        handler = new UserByLoginQueryHandler();
        query = new UserByLoginQuery();
        query.Login = "bestwpw";
    }

    @Test
    public void execute() throws Exception {
        int exceptionCount = 0;
        try {
            handler.execute(query);
        } catch (Exception exception){
            exceptionCount++;
        }
        assertEquals(0, exceptionCount);
    }

}