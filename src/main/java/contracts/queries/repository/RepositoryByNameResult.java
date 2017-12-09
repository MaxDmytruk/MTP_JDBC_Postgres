package contracts.queries.repository;

import cqrs.IQueryResult;
import entities.Repository;

public class RepositoryByNameResult implements IQueryResult {
    public Repository Repository;
}
