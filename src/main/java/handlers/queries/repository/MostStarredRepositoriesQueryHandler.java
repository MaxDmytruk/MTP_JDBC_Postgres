package handlers.queries.repository;

import contracts.queries.repository.MostStarredRepositoriesQuery;
import contracts.queries.repository.MostStarredRepositoriesQueryResult;
import cqrs.IQueryHandler;
import entities.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MostStarredRepositoriesQueryHandler implements IQueryHandler<MostStarredRepositoriesQuery, MostStarredRepositoriesQueryResult> {

    @Override
    public MostStarredRepositoriesQueryResult execute(MostStarredRepositoriesQuery query) throws IOException, URISyntaxException, SQLException, ClassNotFoundException {
        List<Repository> repositories = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mtp_lab_9","postgres", "maxmax");

        Statement statement = c.createStatement();

        String sql = "SELECT * FROM \"Repositories\";";
        ResultSet resultSet = statement.executeQuery(sql);
        Repository receivedRepository = new Repository();
        while ( resultSet.next() ) {
            receivedRepository.Name = resultSet.getString("name");
            receivedRepository.Url = resultSet.getString("url");
            receivedRepository.StarsCount = resultSet.getInt("stars");
            receivedRepository.Language = resultSet.getString("language");
            receivedRepository.Description = resultSet.getString("description");
            receivedRepository.Id = UUID.fromString(resultSet.getString("id"));
            receivedRepository.CommitsNum = resultSet.getInt("commitsnum");

            repositories.add(receivedRepository);
        }

        MostStarredRepositoriesQueryResult result = new MostStarredRepositoriesQueryResult();
        result.repositories = repositories;

        return result;
    }
}
