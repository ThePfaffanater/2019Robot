/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class PneumaticSubsystem extends Subsystem {
  //Initialize
  DoubleSolenoid phaseOne = new DoubleSolenoid(RobotMap.pistonOne_1, RobotMap.pistonOne_2);
  DoubleSolenoid phaseTwo = new DoubleSolenoid(RobotMap.pistonTwo_1, RobotMap.pistonTwo_2);
  DoubleSolenoid claw = new DoubleSolenoid(RobotMap.pistonThree_1, RobotMap.pistonThree_2);
  DoubleSolenoid discBrake = new DoubleSolenoid(RobotMap.discBrake_1, RobotMap.discBrake_2);

  //Extend the first phase of the arm
  public void partialArmExtend(){
    //If the arm is already extended, retract the arm
    if(phaseOne.get() ==  DoubleSolenoid.Value.kForward){
    phaseOne.set(DoubleSolenoid.Value.kReverse);
  }
    //If the arm is off or retracted, extend the arm
    else{
      phaseOne.set(DoubleSolenoid.Value.kForward);
    }
  }
  
  //Extend the second phase of the arm
  public void fullArmExtend(){
    //If the arm is partially extended, extend the second phase only
    if(phaseOne.get() ==  DoubleSolenoid.Value.kForward && phaseTwo.get() != DoubleSolenoid.Value.kForward){
    phaseTwo.set(DoubleSolenoid.Value.kForward);
  }
    //If neither phase one or phase two are extended, extend both
    else if(phaseOne.get() != DoubleSolenoid.Value.kForward && phaseTwo.get() != DoubleSolenoid.Value.kForward){
      phaseOne.set(DoubleSolenoid.Value.kForward);
      phaseTwo.set(DoubleSolenoid.Value.kForward);
    }
    //If both are extended(only case left), then retract both
    else{
      phaseTwo.set(DoubleSolenoid.Value.kReverse);
      phaseOne.set(DoubleSolenoid.Value.kReverse);
    }
  }
  
  //Activate the claw
  public void activateClaw(){
    //Retract if activated
    if(claw.get() ==  DoubleSolenoid.Value.kForward){
    claw.set(DoubleSolenoid.Value.kReverse);
  }
    else{
      claw.set(DoubleSolenoid.Value.kForward);
    }
  }

  public void engageDiscBrake(){
    discBrake.set(DoubleSolenoid.Value.kReverse);
  }
  
  public void disengageDiscBrake(){
    discBrake.set(DoubleSolenoid.Value.kForward);
  }
    
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
