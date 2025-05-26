package frc.robot.subsystems.Other;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorStabilizer extends SubsystemBase {

  public ElevatorStabilizer() {
  }


  @Override
  public void periodic() {
    if(!Constants.STATUS.ELEVATOR.IS_MOVING){
    Constants.MOTORS.Elevator.MOTOR1.set(Constants.CONTROLL_CONSTANTS.ELEVATOR.PROFILED_PID.calculate(Constants.ALL_CONSTANTS.ALL_ENCODERS.get(Constants.MOTORS.Elevator.MOTOR1), Constants.CONTROLL_CONSTANTS.ELEVATOR.SETPOINT));
    Constants.MOTORS.Elevator.MOTOR2.set(Constants.CONTROLL_CONSTANTS.ELEVATOR.PROFILED_PID.calculate(Constants.ALL_CONSTANTS.ALL_ENCODERS.get(Constants.MOTORS.Elevator.MOTOR2), Constants.CONTROLL_CONSTANTS.ELEVATOR.SETPOINT));
    }
  }
}
