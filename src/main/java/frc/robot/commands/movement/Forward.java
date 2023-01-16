// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Forward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_db;
  private final double distance;
  

  /**
   * Creates a new ExampleCommand.
   *
   * @param db The subsystem used by this command.
   */
  public Forward(RomiDrivetrain db, double inches) {
    m_db = db;
    //This checks if the number is negative, the robot will not go forward, but if it's not negative instead the robot will go forward
    if ( inches > 0){
      distance = inches;
    }
    else(
      distance = 0;
    )
    addRequirements(db);
}

 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //resets the encoder
    m_db.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //moves the robot forward 
    m_db.arcadeDrive(0.5,0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //stops the robot from moving
    db.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //checks constantly if the robot has passed a certain distance
    return (m_db.getAverageDistance() >= distance);
  }
}
