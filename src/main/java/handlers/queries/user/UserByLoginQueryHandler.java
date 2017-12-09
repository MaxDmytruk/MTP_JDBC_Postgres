package handlers.queries.user;

import contracts.queries.repository.RepositoryByNameResult;
import contracts.queries.user.UserByLoginQuery;
import contracts.queries.user.UserByLoginResult;
import cqrs.IQueryHandler;
import entities.Repository;
import entities.User;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.UUID;

public class UserByLoginQueryHandler implements IQueryHandler<UserByLoginQuery, UserByLoginResult> {
    @Override
    public UserByLoginResult execute(UserByLoginQuery query) throws IOException, URISyntaxException, SQLException, ClassNotFoundException {
        UserByLoginResult result = new UserByLoginResult();
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mtp_lab_9","postgres", "maxmax");

        String sql = "SELECT * FROM \"Users\" WHERE login = ?;";

        PreparedStatement preparedStatement = c.prepareStatement(sql);
        preparedStatement.setString(1, query.Login);

        ResultSet resultSet = preparedStatement.executeQuery();
        User receivedUser = new User();
        while ( resultSet.next() ) {
            receivedUser.Login = resultSet.getString("login");
            receivedUser.Url = resultSet.getString("url");
            receivedUser.Score = resultSet.getInt("score");
            receivedUser.Id = UUID.fromString(resultSet.getString("id"));

            result.User = receivedUser;
        }

        return result;
    }
}
