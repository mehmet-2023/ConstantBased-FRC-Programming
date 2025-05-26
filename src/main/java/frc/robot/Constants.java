// Copyright 2021-2025 FRC 6328
// http://github.com/Mechanical-Advantage
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// version 3 as published by the Free Software Foundation or
// available in the root directory of this project.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.

package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.RobotBase;
import java.util.HashMap;
import java.util.Map;

/**
 * This class defines the runtime mode used by AdvantageKit. The mode is always "real" when running
 * on a roboRIO. Change the value of "simMode" to switch between "sim" (physics sim) and "replay"
 * (log replay from a file).
 */
public final class Constants {
  public static final Mode simMode = Mode.SIM;
  public static final Mode currentMode = RobotBase.isReal() ? Mode.REAL : simMode;
  public static int SPEED = 1;

  public static enum Mode {
    /** Running on a real robot. */
    REAL,

    /** Running a physics simulator. */
    SIM,

    /** Replaying from a log file. */
    REPLAY
  }

  public class ID_CONSTANTS {
    public static int ELEVATOR_MOTOR1 = 0;
    public static int ELEVATOR_MOTOR2 = 0;
    public static int INTAKE_MOVER_MOTOR1 = 0;
    public static int INTAKE_MOVER_MOTOR2 = 0;
    public static int INTAKE_MOTOR1 = 0;
  }

  public class SCORING_GOALS{
    public class ELEVATOR{
      public static double START = 0; 
      public static double END = 34.5;
      public static double SOURCE = 0;
      public static double PROCESSOR = 1.5;
      public static double TOZERO = 0;
      public static double ALGZERO = 3;
      public static double L1 = 4.25;
      public static double L2 = 8.20;
      public static double L3 = 20.31;
      public static double L4 = 34.5;
      public static double ALGEA_VALUE_DOWN = 2.5;
      public static double ALGEA_VALUE_MIDDLE = 18.3;
    }

    public class INTAKE_MOVER{
      public static double PROCESSOR = 25.5;
      public static double SOURCE = 0;
      public static double ALGEA = 17.5;
      public static double REEFSCAPE = 2.5;
      public static double CORAL = 3.7;
      public static double L4 = 2.9;
    }
  }

  public class STATUS {
    public class ELEVATOR{
      public static boolean IS_MOVING = false;
      public static double CURRENT_GOAL = SCORING_GOALS.ELEVATOR.START;
      public static double UP_SPEED = 0.3;
      public static double MAX_UP_SPEED = 0.6;
      public static double DOWN_SPEED = 0.03;
      public static double MAX_DOWN_SPEED = 0.06;
      public static boolean CURRENT_DIRECTION = true;
      public static double PROCESS_START_POSITION = 0;
      public static double PROCESS_SPEED = 0.3;
    }
    public class INTAKE_MOVER{
      public static boolean IS_MOVING = false;
      public static double CURRENT_GOAL = SCORING_GOALS.ELEVATOR.START;
      public static double UP_SPEED = 0.3;
      public static double MAX_UP_SPEED = 0.6;
      public static double DOWN_SPEED = 0.3;
      public static double MAX_DOWN_SPEED = 0.6;
      public static boolean CURRENT_DIRECTION = true;
    }
  }

  public class CONTROLL_CONSTANTS {
    public class ELEVATOR {
      public static int PROPORTIONAL = 0;
      public static int INTEGRAL = 0;
      public static int DERIVATIVE = 0;
      public static int MAX_VELOCITY = 0; // MS
      public static int MAX_ACCELERATION = 0; // MS^2
      public static double SETPOINT = 0.0;
      public static ProfiledPIDController PROFILED_PID =
          new ProfiledPIDController(
              PROPORTIONAL,
              INTEGRAL,
              DERIVATIVE,
              new TrapezoidProfile.Constraints(MAX_VELOCITY, MAX_ACCELERATION));
    }

    public class INTAKE_MOVER {
      public static int PROPORTIONAL = 0;
      public static int INTEGRAL = 0;
      public static int DERIVATIVE = 0;
      public static int MAX_VELOCITY = 0; // MS
      public static int MAX_ACCELERATION = 0; // MS^2
      public static double SETPOINT = 0.0;
      public static ProfiledPIDController PROFILED_PID =
          new ProfiledPIDController(
              PROPORTIONAL,
              INTEGRAL,
              DERIVATIVE,
              new TrapezoidProfile.Constraints(MAX_VELOCITY, MAX_ACCELERATION));
    }
  }

  public class MOTORS {
    public class Elevator {
      public static TalonFX MOTOR1 = new TalonFX(ID_CONSTANTS.ELEVATOR_MOTOR1);
      public static TalonFX MOTOR2 = new TalonFX(ID_CONSTANTS.ELEVATOR_MOTOR2);
    }

    public class IntakeMover {
      public static TalonFX MOTOR1 = new TalonFX(ID_CONSTANTS.INTAKE_MOVER_MOTOR1);
      public static TalonFX MOTOR2 = new TalonFX(ID_CONSTANTS.INTAKE_MOVER_MOTOR2);
    }

    public class Intake {
      public static TalonFX MOTOR1 = new TalonFX(ID_CONSTANTS.INTAKE_MOTOR1);
    }
  }

  public class ALL_CONSTANTS {
    public static TalonFX[] ALL_MOTORS =
        new TalonFX[] {
          MOTORS.Elevator.MOTOR1,
          MOTORS.Elevator.MOTOR2,
          MOTORS.IntakeMover.MOTOR1,
          MOTORS.IntakeMover.MOTOR2,
          MOTORS.Intake.MOTOR1
        };
    public static Map<TalonFX, Double> ALL_ENCODERS = new HashMap<>();

    static {
      ALL_ENCODERS.put(MOTORS.Elevator.MOTOR1, 0.0);
    }
  }
}
