package handlers.commands.contributor;

import contracts.commands.contributor.DeleteContributorCommand;
import cqrs.ICommandHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteContributorCommandHandler implements ICommandHandler<DeleteContributorCommand> {
    @Override
    public void Execute(DeleteContributorCommand command) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mtp_lab_9","postgres", "maxmax");

        String sql = "DELETE FROM \"Contributors\" WHERE id = ?;";

        PreparedStatement preparedStatement = c.prepareStatement(sql);
        preparedStatement.setString(1, command.Id);

        preparedStatement.executeUpdate();
    }
}
