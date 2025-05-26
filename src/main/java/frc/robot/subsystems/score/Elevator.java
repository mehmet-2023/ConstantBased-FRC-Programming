package frc.robot.subsystems.score;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ALL_CONSTANTS;
import frc.robot.Constants.MOTORS;
import frc.robot.Constants.STATUS;

public class Elevator extends SubsystemBase {

  public Elevator() {
  }

  public void MOVE_MANUAL(){
    MOTORS.Elevator.MOTOR1.set(STATUS.ELEVATOR.CURRENT_DIRECTION ? STATUS.ELEVATOR.UP_SPEED : -STATUS.ELEVATOR.DOWN_SPEED);
    MOTORS.Elevator.MOTOR2.set(STATUS.ELEVATOR.CURRENT_DIRECTION ? STATUS.ELEVATOR.UP_SPEED : -STATUS.ELEVATOR.DOWN_SPEED);
  }

  public void OCAL_PID_PREMIUM() {
    double g = STATUS.ELEVATOR.CURRENT_GOAL;
    double p = STATUS.ELEVATOR.PROCESS_START_POSITION;
    double x = ALL_CONSTANTS.ALL_ENCODERS.get(MOTORS.Elevator.MOTOR1);
    if (Math.abs(g - x) < 0.06) {
        STATUS.ELEVATOR.IS_MOVING = false;
        MOTORS.Elevator.MOTOR1.set(0);
        MOTORS.Elevator.MOTOR2.set(0);
        return;
    }

    int step = Math.abs((int)((g - p) / 6.0));
    if (step == 0) step = 1;
    int index = (int)((x - p) / step);

    if (index <= 3) {
        STATUS.ELEVATOR.PROCESS_SPEED = STATUS.ELEVATOR.CURRENT_DIRECTION
            ? STATUS.ELEVATOR.UP_SPEED + index * (STATUS.ELEVATOR.MAX_UP_SPEED / 6)
            : STATUS.ELEVATOR.DOWN_SPEED + index * (STATUS.ELEVATOR.MAX_DOWN_SPEED / 6);
    } else {
        STATUS.ELEVATOR.PROCESS_SPEED = STATUS.ELEVATOR.CURRENT_DIRECTION
            ? STATUS.ELEVATOR.UP_SPEED + (6 - index) * (STATUS.ELEVATOR.MAX_UP_SPEED / 6)
            : STATUS.ELEVATOR.DOWN_SPEED + (6 - index) * (STATUS.ELEVATOR.MAX_DOWN_SPEED / 6);
    }
    
    double output = STATUS.ELEVATOR.CURRENT_DIRECTION ? STATUS.ELEVATOR.PROCESS_SPEED : -STATUS.ELEVATOR.PROCESS_SPEED;
    MOTORS.Elevator.MOTOR1.set(output);
    MOTORS.Elevator.MOTOR2.set(output);
}

  
}
