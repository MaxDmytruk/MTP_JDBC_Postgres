package contracts.queries.repository;

import cqrs.IQueryResult;
import entities.Repository;

import java.util.List;

public class MostStarredRepositoriesQueryResult implements IQueryResult{
    public List<Repository> repositories;
}
