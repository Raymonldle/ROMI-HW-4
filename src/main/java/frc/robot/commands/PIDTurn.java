// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.PIDController;

/** An example command that uses an example subsystem. */
public class PIDTurn extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_db;
  PIDController m_PIDController = new PIDController(0.1, 0, 0);
  private double angle;

  

  /**
   * Creates a new ExampleCommand.
   *
   * @param db The subsystem used by this command.
   */
  public PIDTurn(RomiDrivetrain db, double rotation) {
    
    angle = rotation;

    addRequirements(db);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_RomiGyro.reset();
    //reset encoders
    m_db.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_db.arcadeDrive(0, m_PIDController.calculate(m_db.getZAngle(), angle));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_db.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_db.getZAngle() >= angle );
  }
}
