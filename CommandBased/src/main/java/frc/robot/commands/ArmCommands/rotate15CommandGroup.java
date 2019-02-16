/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.armCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.armCommands.rotateDegCommand;
import frc.robot.commands.pneumaticCommands.engageDiscBrakeCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class rotate15CommandGroup extends CommandGroup {
  /**
   * Add your docs here.
   */
  public rotate15CommandGroup() {
    requires(Robot.pneumaticSubsystem);
    requires(Robot.shoulderSubsystem);
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.
    addSequential(new rotateDegCommand(RobotMap.ticks15deg));
    addSequential(new engageDiscBrakeCommand());

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
