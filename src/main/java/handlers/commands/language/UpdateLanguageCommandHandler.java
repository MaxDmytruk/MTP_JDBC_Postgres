package handlers.commands.language;

import contracts.commands.language.UpdateLanguageCommand;
import cqrs.ICommandHandler;

import java.sql.*;

public class UpdateLanguageCommandHandler implements ICommandHandler<UpdateLanguageCommand> {
    @Override
    public void Execute(UpdateLanguageCommand command) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mtp_lab_9","postgres", "maxmax");

        String sql = "UPDATE \"Languages\" SET name = ? WHERE id = ?;";

        PreparedStatement preparedStatement = c.prepareStatement(sql);
        preparedStatement.setString(1, command.Name);
        preparedStatement.setString(2, command.Id);

        preparedStatement.executeUpdate();
    }
}
