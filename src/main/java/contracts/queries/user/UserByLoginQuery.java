package contracts.queries.user;

import cqrs.IQuery;

public class UserByLoginQuery implements IQuery<UserByLoginResult> {
    public String Login;
}
