package handlers.queries.repository;

import contracts.queries.repository.RepositoryByNameQuery;
import contracts.queries.repository.RepositoryByNameResult;
import cqrs.IQueryHandler;
import entities.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.UUID;

public class RepositoryByNameQueryHandler implements IQueryHandler<RepositoryByNameQuery, RepositoryByNameResult> {
    @Override
    public RepositoryByNameResult execute(RepositoryByNameQuery query) throws IOException, URISyntaxException, SQLException, ClassNotFoundException {
        RepositoryByNameResult result = new RepositoryByNameResult();
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mtp_lab_9","postgres", "maxmax");

        String sql = "SELECT * FROM \"Repositories\" WHERE name = ?;";

        PreparedStatement preparedStatement = c.prepareStatement(sql);
        preparedStatement.setString(1, query.Name);

        ResultSet resultSet = preparedStatement.executeQuery();
        Repository receivedRepository = new Repository();
        while ( resultSet.next() ) {
            receivedRepository.Name = resultSet.getString("name");
            receivedRepository.Url = resultSet.getString("url");
            receivedRepository.StarsCount = resultSet.getInt("stars");
            receivedRepository.Language = resultSet.getString("language");
            receivedRepository.Description = resultSet.getString("description");
            receivedRepository.Id = UUID.fromString(resultSet.getString("id"));
            receivedRepository.CommitsNum = resultSet.getInt("commitsnum");

            result.Repository = receivedRepository;
        }

        return result;
    }
}
