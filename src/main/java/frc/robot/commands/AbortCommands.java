package frc.robot.commands;

import java.util.List;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AbortCommands extends CommandBase 
{
    public List<CommandBase> Commands;

    public AbortCommands(List<CommandBase> commands) 
    {
        Commands = commands;
    }

    @Override
    public void initialize()
    {
        for (CommandBase commands : Commands) 
        {
            commands.end(true);
            commands.cancel();
        }
    }

    @Override
    public boolean isFinished() 
    {
      return true;
    }
}