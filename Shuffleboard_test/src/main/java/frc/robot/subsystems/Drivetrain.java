// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj.simulation.ADXRS450_GyroSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  
    //sample motor controllers
    final PWMVictorSPX sampleVictor;
    final PWMSparkMax samplePwmSparkMax;
    //final CANSparkMax sampleCanSparkMax;
    
    //sample sensors

    //sample encoders
    final Encoder victorEncoder;
    final Encoder pwmSparkMaxEncoder;
    //final RelativeEncoder CanSparkMaxEncoder;

    final EncoderSim simVictorEncoder;
    final EncoderSim simPwmSparkMaxEncoder;
    //final EncoderSim simCanSparkMaxEncoder;

    final ADXRS450_Gyro gyro;
    final ADXRS450_GyroSim simGyro;

    final DifferentialDrivetrainSim difDrivetrainSim;

  public Drivetrain() {
    sampleVictor = new PWMVictorSPX(0);
    samplePwmSparkMax = new PWMSparkMax(1);

    victorEncoder = new Encoder(0, 1);
    pwmSparkMaxEncoder = new Encoder (2, 3);

    simVictorEncoder = new EncoderSim(victorEncoder);
    simPwmSparkMaxEncoder = new EncoderSim(pwmSparkMaxEncoder);

    gyro = new ADXRS450_Gyro();
    simGyro = new ADXRS450_GyroSim(gyro);

    difDrivetrainSim = new DifferentialDrivetrainSim( 
          DCMotor.getNEO(2),  //driveMotor --> 2 NEO motors on each side 
          7.29,               //gearing --> 7.29:1 gear reduction 
          7.5,                //Moment of Inertia --> sample 7.5 kg m^2 
          60.0,               //Mass --> sample 60 kg 
          Units.inchesToMeters(3),  //wheel radius 3" (6" diameter wheels) 
          0.7112,             //trackWidthMeters --> distance between wheels (meters)
            // The standard deviations for measurement noise:
            // x and y:          0.001 m
            // heading:          0.001 rad
            // l and r velocity: 0.1   m/s
            // l and r position: 0.005 m
          VecBuilder.fill(0.001, 0.001, 0.001, 0.1, 0.1, 0.005, 0.005)
        ); 



  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void simulation_periodic() {

  }
}
