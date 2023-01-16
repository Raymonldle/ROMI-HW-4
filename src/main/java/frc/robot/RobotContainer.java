// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.controller.PIDController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final RomiDrivetrain m_romiDrivetrain = new RomiDrivetrain();

  //creates a new object named forward
  
  //creates a new object named XboxController
  private final static XboxController m_XboxController = new XboxController(0);

  private final Forward m_forward = new Forward(m_romiDriveTrain, 14.0);
  
  private final Backward m_backward = new Backward(m_romiDriveTrain, 14);
  
  private final PIDTurn m_PIDTurn = new PIDTurn(m_romiDriveTrain, 90 );

  private final PIDRomi m_PIDRomi = new PIDRomi(m_romiDriveTrain, 15 );


  


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return ((new PIDRomi(m_romiDriveTrain, 31.5)).andThen(new PIDTurn(m_RomiDriveTrain,90)).andThen(new PIDRomi(m_RomiDriveTrain,47)).andThen(new PIDTurn(m_RomiDriveTrain, -90)).andThen(new PIDRomi(m_RomiDriveTrain, 24)).andThan(new PIDTurn(m_RomiDriveTurn, 90)).andThen(new PIDRomi(m_RomiDriveTrain, 50)))
  }
}


