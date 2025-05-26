package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ALlRobot extends SubsystemBase {

  public ALlRobot() {
    resetAllEncoders();
    Constants.MOTORS.IntakeMover.MOTOR1.setNeutralMode(NeutralModeValue.Brake);
    Constants.MOTORS.IntakeMover.MOTOR2.setNeutralMode(NeutralModeValue.Brake);
    Constants.MOTORS.Elevator.MOTOR1.setNeutralMode(NeutralModeValue.Brake);
    Constants.MOTORS.Elevator.MOTOR2.setNeutralMode(NeutralModeValue.Brake);
    Constants.CONTROLL_CONSTANTS.ELEVATOR.PROFILED_PID.enableContinuousInput(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    Constants.CONTROLL_CONSTANTS.ELEVATOR.PROFILED_PID.setGoal(Constants.CONTROLL_CONSTANTS.ELEVATOR.SETPOINT);
    Constants.CONTROLL_CONSTANTS.INTAKE_MOVER.PROFILED_PID.enableContinuousInput(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    Constants.CONTROLL_CONSTANTS.INTAKE_MOVER.PROFILED_PID.setGoal(Constants.CONTROLL_CONSTANTS.INTAKE_MOVER.SETPOINT);
  }

  public void resetAllEncoders() {
    for (TalonFX motor : Constants.ALL_CONSTANTS.ALL_MOTORS){
      motor.setPosition(0);
    }
  }

  @Override
  public void periodic() {
    for (TalonFX motor : Constants.ALL_CONSTANTS.ALL_MOTORS){
      Constants.ALL_CONSTANTS.ALL_ENCODERS.put(motor,motor.getPosition().getValueAsDouble());
    }
  }
}
