
# Constant-Based FRC Programming (2025)

This subjective method is based on storing all hardware configuration data as constants and controlling the robot using data structures (such as various arrays). All hardware states and necessary constant variables are defined in a `Constants` file. Additionally, the code is built upon the AdvantageKit TalonFX Swerve codebase.

## OcalPID Premium

OcalPID was originally developed as an alternative to complex control theory approaches. You can see this method in action in the [2025 Amal Hawks Robot Code](https://github.com/Amal-Hawks7611/AmalHawk_2025_Robot_Code). Rather than focusing on speed control, this method used encoders to provide simple positional control. I have since improved it by designing a control system that divides the path into six segments. In this system, the robot accelerates to a desired peak speed at the midpoint and then decelerates back to the target cruising speed — enabling smooth and efficient motion.

## Command Structure

Although a full command-based structure has not yet been implemented, commands and subsystems are organized in a straightforward manner. Background tasks and hardware-level operations that affect the entire robot are written into separate subsystems to maintain modularity and clarity.
