package contracts.queries.repository;

import cqrs.IQuery;

public class RepositoryByNameQuery implements IQuery<RepositoryByNameResult> {
    public String Name;
}
