package handlers.commands.repository_owner;

import contracts.commands.repository_owner.DeleteRepositoryOwnerCommand;
import cqrs.ICommandHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRepositoryOwnerCommandHandler implements ICommandHandler<DeleteRepositoryOwnerCommand> {
    @Override
    public void Execute(DeleteRepositoryOwnerCommand command) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mtp_lab_9","postgres", "maxmax");

        String sql = "DELETE FROM \"RepositoryOwners\" WHERE id = ?;";

        PreparedStatement preparedStatement = c.prepareStatement(sql);
        preparedStatement.setString(1, command.Id);

        preparedStatement.executeUpdate();
    }
}
