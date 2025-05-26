package frc.robot.subsystems.Other;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeMoverStabilizer extends SubsystemBase {

  public IntakeMoverStabilizer() {
  }

  @Override
  public void periodic() {
    if(!Constants.STATUS.INTAKE_MOVER.IS_MOVING){
    Constants.MOTORS.IntakeMover.MOTOR1.set(Constants.CONTROLL_CONSTANTS.INTAKE_MOVER.PROFILED_PID.calculate(Constants.ALL_CONSTANTS.ALL_ENCODERS.get(Constants.MOTORS.IntakeMover.MOTOR1), Constants.CONTROLL_CONSTANTS.INTAKE_MOVER.SETPOINT));
    Constants.MOTORS.IntakeMover.MOTOR2.set(Constants.CONTROLL_CONSTANTS.INTAKE_MOVER.PROFILED_PID.calculate(Constants.ALL_CONSTANTS.ALL_ENCODERS.get(Constants.MOTORS.IntakeMover.MOTOR2), Constants.CONTROLL_CONSTANTS.INTAKE_MOVER.SETPOINT));
    }
  }
}
