package contracts.queries.user;

import cqrs.IQueryResult;
import entities.User;

public class UserByLoginResult implements IQueryResult{
    public User User;
}
